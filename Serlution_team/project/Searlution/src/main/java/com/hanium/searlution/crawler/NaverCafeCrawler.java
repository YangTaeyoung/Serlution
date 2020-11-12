package com.hanium.searlution.crawler;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.hanium.searlution.model.Search;

public class NaverCafeCrawler {
	static String cafeUrlF = "https://search.naver.com/search.naver?where=article&ie=utf8&query="; 
	
	static String cafeUrlB = "&prdtype=0&t=0&st=rel&date_option=0&date_from=&date_to=&srchby=text&dup_remove=1&cafe_url=&without_cafe_url=&board=&sm=tab_pge&start=";
	
	//키워드 입력
	static String cafeUrlKeyword = "";
	
	//베이스 번호
	static int cafeUrlPage = 1;
	
	//검색할 주소
	static String cafeCompleteUrl = "";
	
	//시작, 끝 번호
	int cafeStart;
	int cafeEnd;
	
	//값 저장할 list
	public List<Search> cafeList = new ArrayList<Search>();
	
	public NaverCafeCrawler(String keyword, int start, int end) {
		cafeUrlKeyword = keyword;
		cafeCompleteUrl = cafeUrlF + cafeUrlKeyword + cafeUrlB + Integer.toString(cafeUrlPage);
		cafeStart = start;
		cafeEnd = end;
	}
	
	public void cafeCrawler() throws IOException{
		//시작, 끝 페이지
		int sPage = cafeStart;
		int ePage = cafeEnd;
		
		while(sPage <= ePage) {			
			//검색 결과 사이트 html 가져오기
			Document cafeSearch = Jsoup.connect(cafeCompleteUrl).get();
			
			//카페 검색결과 각 게시글들 가져오기
			Elements cafeUrl = cafeSearch.select("li.bx");
			
			//날짜 포멧
			SimpleDateFormat formatDate = new SimpleDateFormat("yyyy.MM.dd");
			
			int crawlCounter = 0;
			
			for(Element element : cafeUrl) {
				if (crawlCounter >= 10) {
					break;
				}
				//카페 링크
				String url = element.select("a.api_txt_lines").attr("href");
				
				//카페 제목
				String cafeTitle = element.select("a.api_txt_lines").text();
				
				//카페 검색결과 각 게시글들 가져오기
				String cafeDate = element.select("span.sub_time").text();
				
				//카페 내용 가져오기
				String cafeText = element.select("div.api_txt_lines").text();
				cafeText = cafeText.replace("...", "");
				
				//현재 날짜 저장
				Calendar cal = Calendar.getInstance();
				
				//다른 수식어들 날짜로 변환해주기
				if(cafeDate.contains("분 전")) {
					int tempMin = Integer.parseInt(cafeDate.substring(0, cafeDate.length()-3));
					cal.add(Calendar.MINUTE, -tempMin);
					cafeDate = formatDate.format(cal.getTime());
				}
				
				else if(cafeDate.contains("시간 전")) {
					int tempHour = Integer.parseInt(cafeDate.substring(0, cafeDate.length()-4));
					cal.add(Calendar.HOUR_OF_DAY, -tempHour);
					cafeDate = formatDate.format(cal.getTime());
				}
				
				else if(cafeDate.contains("어제")) {
					cal.add(Calendar.DAY_OF_MONTH, -1);
					cafeDate = formatDate.format(cal.getTime());
				}
				
				else if(cafeDate.contains("일 전")) {
					int tempDay = Integer.parseInt(cafeDate.substring(0, cafeDate.length()-3));
					cal.add(Calendar.DAY_OF_MONTH, -tempDay);
					cafeDate = formatDate.format(cal.getTime());
				}
				
				//임시 Search 클래스 변수에 저장
				Search tempSearch = new Search();
				
				if(!cafeTitle.equals("") && !cafeText.equals(""))
				{
					tempSearch.setSer_title(CharSwitcher.checkIntegrity(cafeTitle));
					tempSearch.setSer_link(url);
					tempSearch.setSer_date(cafeDate);
					tempSearch.setSer_content(CharSwitcher.checkIntegrity(cafeText));
					
					//리스트에 저장
					cafeList.add(tempSearch);
				}
				crawlCounter++;
			}
			
			//다음 페이지
			sPage += 10;
			cafeUrlPage = sPage;
			cafeCompleteUrl = cafeUrlF + cafeUrlKeyword + cafeUrlB + Integer.toString(cafeUrlPage);
		}
	}
}