package com.hanium.searlution.crawler;


public class NaverGraph {
    public static void main(String[] args) {
    	//input정리
    	//1. 시작 날짜 "yyyy-mm-dd"
    	//2. 끝 날짜 "yyyy-mm-dd"
    	//3. 최소 단위 "date", "week", "month"
    	//4. 검색어
    	//5. device null, "pc", "mo"
    	//6. 연령대 "1", "2", ... ,"11"까지 array로 (중복 선택 가능) 또는 null
    	//6-1. 1: 0∼12세 2: 13∼18세 3: 19∼24세 4: 25∼29세 5: 30∼34세 6: 35∼39세 7: 40∼44세 8: 45∼49세 9: 50∼54세 10: 55∼59세 11: 60세 이상
    	//7. 성별 null, "f", "m"
    	
    	String[] tmpAge = {"1", "2"};
//        NaverGraphApi graph = new NaverGraphApi("2020-01-01", "2020-04-30", "month", "코로나", "pc", tmpAge , "f");
        NaverGraphApi graph = new NaverGraphApi("2020-04-01", "2020-04-30", "date", "코로나", null, null , null);
        graph.graphString();
        System.out.println(graph.labels);
        System.out.println(graph.data);
    }
}