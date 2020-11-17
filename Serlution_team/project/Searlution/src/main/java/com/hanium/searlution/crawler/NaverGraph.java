package com.hanium.searlution.crawler;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class NaverGraph {
	String keyword;
	String dates;
	String[] ranges;
	String[] genders;
	String[] ages;
	
	public NaverGraph(String key, String date, String[] range, String[] gender, String[] age) {
		keyword = key;
		dates = date;
		ranges = range;
		genders = gender;
		ages = age;
	}
	
    public String[] graphStr() {
    	
    	//input정리
    	//1. 시작 날짜 "yyyy-mm-dd"
    	//2. 끝 날짜 "yyyy-mm-dd"
    	//3. 최소 단위 "date", "week", "month"
    	//4. 검색어
    	//5. device null, "pc", "mo"
    	//6. 연령대 "1", "2", ... ,"11"까지 array로 (중복 선택 가능) 또는 null
    	//6-1. 1: 0∼12세 2: 13∼18세 3: 19∼24세 4: 25∼29세 5: 30∼34세 6: 35∼39세 7: 40∼44세 8: 45∼49세 9: 50∼54세 10: 55∼59세 11: 60세 이상
    	//7. 성별 null, "f", "m"
    	
    	SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
    	
    	//현재 날짜 저장
		Calendar endDate = Calendar.getInstance();
		Calendar startDate = Calendar.getInstance();
		if(dates.equals("oneMonth")) {
			startDate.add(Calendar.MONTH, -1);
		} else if(dates.equals("threeMonth")) {
			startDate.add(Calendar.MONTH, -3);
		} else if(dates.equals("oneYear")) {
			startDate.add(Calendar.YEAR, -1);
		}
		
		String tmpRange = null;
		String tmpGender = null;
		
		if(ranges != null) {
			if(ranges.length != 2) {
				tmpRange = ranges[0];
			}
		}
		if(genders != null) {
			if(genders.length != 2) {
				tmpGender = genders[0];
			}
		}
		
		String startDateStr = formatDate.format(startDate.getTime());
		String endDateStr = formatDate.format(endDate.getTime());
//        NaverGraphApi graph = new NaverGraphApi("2020-01-01", "2020-04-30", "month", "코로나", "pc", tmpAge , "f");
    	//우선 한달 전은 default로
    	System.out.println(keyword);
        NaverGraphApi graph = new NaverGraphApi(startDateStr, endDateStr, "date", keyword, tmpRange, ages , tmpGender);
        graph.graphString();
        
        String[] resultGraph = {graph.labelString, graph.dataString};
        return resultGraph;

    }
}
