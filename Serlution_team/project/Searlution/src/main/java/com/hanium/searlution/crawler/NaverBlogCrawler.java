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

public class NaverBlogCrawler {
	static String blogUrlF = "https://search.naver.com/search.naver?date_from=&date_option=0&date_to=&dup_remove=1&nso=&post_blogurl=&post_blogurl_without=&query="; 
	
	static String blogUrlB = "&sm=tab_pge&srchby=all&st=sim&where=post&start=";
	
	//키워드 입력
	static String blogUrlKeyword = "";
	
	//베이스 번호
	static int blogUrlPage = 1;
	
	//검색할 주소
	static String blogCompleteUrl = "";
	
	//시작, 끝 번호
	int blogStart;
	int blogEnd;
	
	//값 저장할 list
	public List<Search> blogList = new ArrayList<Search>();
	
	public NaverBlogCrawler(String keyword, int start, int end) {
		blogUrlKeyword = keyword;
		blogCompleteUrl = blogUrlF + blogUrlKeyword + blogUrlB + Integer.toString(blogUrlPage);
		blogStart = start;
		blogEnd = end;
	}
	
	public void blogCrawler() throws IOException{
		//시작, 끝 페이지
		int sPage = blogStart;
		int ePage = blogEnd;
		
		while(sPage <= ePage) {		
			boolean blogOk = true;
			
			//검색 결과 사이트 html 가져오기
			Document blogSearch = null;
			try {
				blogSearch= Jsoup.connect(blogCompleteUrl).get();
			} catch(Exception e) {
				System.out.println("blog searchresult url error");
				blogOk = false;
			}
			
			//날짜 포멧
			SimpleDateFormat formatDate = new SimpleDateFormat("yyyy.MM.dd");
			
			int crawlCounter = 0;
			
			if(blogOk == true) {
				Elements blogUrl = blogSearch.select("li.bx");
				
				for(Element element : blogUrl) {
					if (crawlCounter >= 10) {
						break;
					}
					
					//블로그 주소
					String url = element.select("a.api_txt_lines").attr("href");
					
					//블로그 제목
					String blogTitle = element.select("a.api_txt_lines").text();
					
					//게시글 날짜
					String blogDate = element.select("span.sub_time").text();
					
					//도메인이 blog.me일 경우
					if(url.contains("blog.me")) {
						String tempStr = url;
						String tempStr2 = tempStr.substring(8);
						String[] tempStr3 = tempStr2.split(".blog.me/");
						url = "https://blog.naver.com/"+tempStr3[0]+"/"+tempStr3[1];
					}
					
					String blogTextStr;
					
					try {
						
						//임시 블로그 주소 접속
						Document blogTemp = Jsoup.connect(url).get();
						
						//블로그의 실제 주소 가져오기
						Elements frame;
						Document blog;
						if(url.contains("blog.naver.com")) {
						frame = blogTemp.select("iframe#mainFrame");
						blog = Jsoup.connect("https://blog.naver.com"+frame.attr("src")).get();
						
						//내용 글 저장
						Elements blogText = blog.select("div.se-main-container");
						blogTextStr = blogText.text();
						} else { //개인 도메인 사용하는 경우
							blogTextStr = "";
						}
						
						if(blogTextStr.equals("")) {
							blogTextStr = element.select("div.api_txt_lines").text();
						}
						
					} catch (IllegalArgumentException e) {
						System.out.println("blog url itself error");
						blogTextStr = "";
					} catch (Exception e) {
						System.out.println("blog url error");
						blogTextStr = "";
					}
					
					//현재 날짜 저장
					Calendar cal = Calendar.getInstance();
					
					//다른 수식어들 날짜로 변환해주기
					if(blogDate.contains("분 전")) {
						int tempMin = Integer.parseInt(blogDate.substring(0, blogDate.length()-3));
						cal.add(Calendar.MINUTE, -tempMin);
						blogDate = formatDate.format(cal.getTime());
					}
					
					else if(blogDate.contains("시간 전")) {
						int tempHour = Integer.parseInt(blogDate.substring(0, blogDate.length()-4));
						cal.add(Calendar.HOUR_OF_DAY, -tempHour);
						blogDate = formatDate.format(cal.getTime());
					}
					
					else if(blogDate.contains("어제")) {
						cal.add(Calendar.DAY_OF_MONTH, -1);
						blogDate = formatDate.format(cal.getTime());
					}
					
					else if(blogDate.contains("일 전")) {
						int tempDay = Integer.parseInt(blogDate.substring(0, blogDate.length()-3));
						cal.add(Calendar.DAY_OF_MONTH, -tempDay);
						blogDate = formatDate.format(cal.getTime());
					}
					
					//임시 Search 클래스 변수에 저장
					Search tempSearch = new Search();
					if(!blogTitle.equals("") && !blogTextStr.equals(""))
					{
						tempSearch.setSer_title(CharSwitcher.checkIntegrity(blogTitle));
						tempSearch.setSer_link(url);
						tempSearch.setSer_date(blogDate);
						tempSearch.setSer_content(CharSwitcher.checkIntegrity(blogTextStr));

						//리스트에 저장
						blogList.add(tempSearch);
					}
					crawlCounter++;
				}
			}
			//다음 페이지로 이동하기
			sPage += 10;
			blogUrlPage = sPage;
			blogCompleteUrl = blogUrlF + blogUrlKeyword + blogUrlB + Integer.toString(blogUrlPage);
		}
	}
}
