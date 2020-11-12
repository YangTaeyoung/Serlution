package com.hanium.searlution.crawler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.hanium.searlution.model.Search;

public class NaverWebCrawler {
	static String webUrlF = "https://search.naver.com/search.naver?f=&fd=2&filetype=0&nso=so%3Ar%2Ca%3Aall%2Cp%3Aall&query="; 
	
	static String webUrlM = "&research_url=&sm=tab_pge&start=";
	
	static String webUrlB = "&where=webkr";
	
	//키워드 입력
	static String webUrlKeyword = "";
	
	//베이스 번호
	static int webUrlPage = 1;
	
	//검색할 주소
	static String webCompleteUrl = "";
	
	//시작, 끝 번호
	int webStart;
	int webEnd;
	
	//값 저장할 list
	public List<Search> webList = new ArrayList<Search>();
	
	public NaverWebCrawler(String keyword, int start, int end) {
		webUrlKeyword = keyword;
		webCompleteUrl = webUrlF + webUrlKeyword + webUrlM + Integer.toString(webUrlPage) + webUrlB;
		webStart = start;
		webEnd = end;
	}
	
	public void webCrawler() throws IOException{
		//시작, 끝 페이지
		int sPage = webStart;
		int ePage = webEnd;
		
		while(sPage <= ePage) {			
			//베이스 번호
			Document webSearch = Jsoup.connect(webCompleteUrl).get();
			
			//검색할 주소
			Elements webUrl = webSearch.select("li.bx");
			
			int crawlCounter = 0;
			
			for(Element element : webUrl) {
				if(crawlCounter >= 10) {
					break;
				}
				
				//웹사이트 링크
				String url = element.select("a.link_tit").attr("href");
				
				//웹사이트 제목
				String webTitle = element.select("a.link_tit").text();

				//웹사이트 내용
				String webText = element.select("div.api_txt_lines").text();
				
				//임시 Search 클래스 변수에 저장
				Search tempSearch = new Search();
				
				if(webTitle.equals("") && webText.equals(""))
				{
				tempSearch.setSer_title(CharSwitcher.checkIntegrity(webTitle));
				tempSearch.setSer_link(url);
				tempSearch.setSer_date("");
				tempSearch.setSer_content(CharSwitcher.checkIntegrity(webText));
				
				//리스트에 저장
				webList.add(tempSearch);
				}
				crawlCounter++;
			}
			
			//다음 페이지 이동
			sPage += 10;
			webUrlPage = sPage;
			webCompleteUrl = webUrlF + webUrlKeyword + webUrlM + Integer.toString(webUrlPage) + webUrlB;
		}
	}
}