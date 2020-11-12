package com.hanium.searlution.crawler;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

class NaverGraphApi {
	
	String apiUrl;
	
    Map<String, String> requestHeaders = new HashMap<>();
	
    String requestBody;
    
    Vector<String> labels = new Vector<String> ();
    Vector<String> data = new Vector<String> ();
    
    private static String post(String apiUrl, Map<String, String> requestHeaders, String requestBody) {
        HttpURLConnection con = connect(apiUrl);

        try {
            con.setRequestMethod("POST");
            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
                con.setRequestProperty(header.getKey(), header.getValue());
            }

            con.setDoOutput(true);
            try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
                wr.write(requestBody.getBytes());
                wr.flush();
            }

            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 응답
                return readBody(con.getInputStream());
            } else {  // 에러 응답
                return readBody(con.getErrorStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("API 요청과 응답 실패", e);
        } finally {
            con.disconnect(); // Connection을 재활용할 필요가 없는 프로세스일 경우
        }
    }

    private static HttpURLConnection connect(String apiUrl) {
        try {
            URL url = new URL(apiUrl);
            return (HttpURLConnection) url.openConnection();
        } catch (MalformedURLException e) {
            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
        } catch (IOException e) {
            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
        }
    }

    private static String readBody(InputStream body) {
        InputStreamReader streamReader = new InputStreamReader(body, StandardCharsets.UTF_8);

        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
            StringBuilder responseBody = new StringBuilder();

            String line;
            while ((line = lineReader.readLine()) != null) {
                responseBody.append(line);
            }

            return responseBody.toString();
        } catch (IOException e) {
            throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
        }
    }
    
	 public NaverGraphApi(String fDate, String lDate, String unit, String keyword, String device, String[] age, String gender) {
        String clientId = "j21b_OkUh45VW3p7ktxM"; // 애플리케이션 클라이언트 아이디
        String clientSecret = "wykeeOHeGg"; // 애플리케이션 클라이언트 시크릿

        apiUrl = "https://openapi.naver.com/v1/datalab/search";

        requestHeaders.put("X-Naver-Client-Id", clientId);
        requestHeaders.put("X-Naver-Client-Secret", clientSecret);
        requestHeaders.put("Content-Type", "application/json");
        
        requestBody = "{\"startDate\":\""+ fDate +"\"," +
                "\"endDate\":\""+ lDate +"\"," +
                "\"timeUnit\":\""+ unit +"\"," +
                "\"keywordGroups\":[{\"groupName\":\""+ keyword +"\"," + "\"keywords\":[\""+ keyword +"\"]}]";
        if(device != null) {
        	requestBody = requestBody + ",\"device\":\""+ device +"\"";
        }
        if(age != null) {
        	requestBody = requestBody + ",\"ages\":[";
        	for(int i=0; i<age.length; i++) {
        		requestBody = requestBody + "\""+ age[i] +"\"";
        		if(i != age.length - 1) {
        			requestBody = requestBody + ",";
        		}
        	}
        	requestBody = requestBody + "]";
        }
        if(gender != null) {
        	requestBody = requestBody + ",\"gender\":\"f\"";
        }
        requestBody = requestBody + "}";
    }
	 public void graphString() {   
        String responseBody = post(apiUrl, requestHeaders, requestBody);
        String[] tempBody = responseBody.split("\"data\"");
        
        //label값 가져오기
        String[] tempLabel = tempBody[1].split("\"period\":\"");
        for(int i=1; i<tempLabel.length; i++) {
        	labels.add(tempLabel[i].substring(5, 10));
        }
        
//        //label test
//        for(int i=0; i<labels.size();i++) {
//        	System.out.println(labels.get(i));
//        }
        
        //data값 가져오기
        String[] tempData = tempBody[1].split("\"ratio\":");
        for(int i=1; i<tempData.length; i++) {
        	if(tempData[i].substring(0, 7).contains("}") == false) {
        		data.add(tempData[i].substring(0, 7));
        	} else {
        		data.add("100");
        	}
        	
        }
        
//        //data test
//        for(int i=0; i<data.size();i++) {
//        	System.out.println(data.get(i));
//        }
	 }

}