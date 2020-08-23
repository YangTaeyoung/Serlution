package com.hanium.searlution.search;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hanium.searlution.dao.HistoryDAO;
import com.hanium.searlution.dao.SearchDAO;
import com.hanium.searlution.model.History;
import com.hanium.searlution.model.Search;

class NaverBlogCrawler {
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
	List<Search> blogList = new ArrayList<Search>();
	
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
			//검색 결과 사이트 html 가져오기
			Document blogSearch = Jsoup.connect(blogCompleteUrl).get();
			
			//블로그 검색결과 각 게시글들 가져오기
			Elements blogUrl = blogSearch.select("li.sh_blog_top");
			
			//날짜 포멧
			SimpleDateFormat formatDate = new SimpleDateFormat("yyyy.MM.dd");
			
			for(Element element : blogUrl) {
				//블로그 주소
				String url = element.select("a.sh_blog_title").attr("href");
				
				//블로그 제목
				String blogTitle = element.select("a.sh_blog_title").text();
				
				//게시글 날짜
				String blogDate = element.select("dd.txt_inline").text();
				
				//도메인이 blog.me일 경우
				if(url.contains("blog.me")) {
					String tempStr = url;
					String tempStr2 = tempStr.substring(8);
					String[] tempStr3 = tempStr2.split(".blog.me/");
					url = "https://blog.naver.com/"+tempStr3[0]+"/"+tempStr3[1];
				}
				
				//임시 블로그 주소 접속
				Document blogTemp = Jsoup.connect(url).get();
				
				String blogTextStr;
				
				try {
					//daum블로그일 경우
					if(url.contains("daum")) {
						blogTextStr = "";
					}
					else {
						//블로그의 실제 주소 가져오기
						Elements frame;
						Document blog;
						if(url.contains("blog.naver.com")) {
						frame = blogTemp.select("iframe#mainFrame");
						blog = Jsoup.connect("https://blog.naver.com"+frame.attr("src")).get();
						} else { //개인 도메인 사용하는 경우
							Elements tempFra = blogTemp.select("iframe#screenFrame");
							Document tempDoc = Jsoup.connect(tempFra.attr("src")).get();
							
							frame = tempDoc.select("iframe#mainFrame");
							blog = Jsoup.connect("https://blog.naver.com"+frame.attr("src")).get();
						}
						
						//내용 글 저장
						Elements blogText = blog.select("div.se-main-container");
						blogTextStr = blogText.text();
					}
				} catch (IllegalArgumentException e) {
					blogTextStr = "";
				} catch (Exception e) {
					blogTextStr = "";
					System.out.println("블로그 url중 이상한 오류 발생");
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
				tempSearch.setSer_title(blogTitle);
				tempSearch.setSer_link(url);
				tempSearch.setSer_date(blogDate);
				tempSearch.setSer_content(blogTextStr);
				
				//리스트에 저장
				blogList.add(tempSearch);
				
			}
			
			//다음 페이지로 이동하기
			sPage += 10;
			blogUrlPage = sPage;
			blogCompleteUrl = blogUrlF + blogUrlKeyword + blogUrlB + Integer.toString(blogUrlPage);
		}
	}
}

class NaverCafeCrawler {
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
	List<Search> cafeList = new ArrayList<Search>();
	
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
			Elements cafeUrl = cafeSearch.select("li.sh_cafe_top");
			
			//날짜 포멧
			SimpleDateFormat formatDate = new SimpleDateFormat("yyyy.MM.dd");
			
			for(Element element : cafeUrl) {
				//카페 링크
				String url = element.select("a.sh_cafe_title").attr("href");
				
				//카페 제목
				String cafeTitle = element.select("a.sh_cafe_title").text();
				
				//카페 검색결과 각 게시글들 가져오기
				String cafeDate = element.select("dd.txt_inline").text();
				
				//카페 내용 가져오기
				String cafeText = element.select("dd.sh_cafe_passage").text();
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
				tempSearch.setSer_title(cafeTitle);
				tempSearch.setSer_link(url);
				tempSearch.setSer_date(cafeDate);
				tempSearch.setSer_content(cafeText);
				
				//리스트에 저장
				cafeList.add(tempSearch);
				
			}
			
			//다음 페이지
			sPage += 10;
			cafeUrlPage = sPage;
			cafeCompleteUrl = cafeUrlF + cafeUrlKeyword + cafeUrlB + Integer.toString(cafeUrlPage);
		}
	}
}

class NaverWebCrawler {
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
	List<Search> webList = new ArrayList<Search>();
	
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
			Elements webUrl = webSearch.select("li.sh_web_top");
			
			for(Element element : webUrl) {
				//웹사이트 링크
				String url = element.select("a.title_link").attr("href");
				
				//웹사이트 제목
				String webTitle = element.select("a.title_link").text();

				//웹사이트 내용
				String webText = element.select("dd.sh_web_passage").text();
				
				//임시 Search 클래스 변수에 저장
				Search tempSearch = new Search();
				tempSearch.setSer_title(webTitle);
				tempSearch.setSer_link(url);
				tempSearch.setSer_date("");
				tempSearch.setSer_content(webText);
				
				//리스트에 저장
				webList.add(tempSearch);
			}
			
			//다음 페이지 이동
			sPage += 10;
			webUrlPage = sPage;
			webCompleteUrl = webUrlF + webUrlKeyword + webUrlM + Integer.toString(webUrlPage) + webUrlB;
		}
	}
}

@Controller
public class CrawlingController {
	private static final Logger logger = LoggerFactory.getLogger(CrawlingController.class);
	
	@Autowired
	private SearchDAO searchDAO;
	
	@Autowired
	private HistoryDAO historyDAO;
	
	@RequestMapping(value="search.do")
	public String searchDo(HttpServletRequest request, Model model, @RequestParam("keyword") String keyword) throws IOException
	{
		/* 도경이는 여기서 작업하면 됨. */
		//jsoup-1.13.1.jar 필요함
		List<Search> searches = new ArrayList<Search>(); //하둡이 아직이니 우선 크롤링 데이터 바로 list 저장
		
		//각 블로그, 카페, 웹에서 크롤링 한 결과 list에 저장
		//element는 키워드, 시작 페이지 번호, 끝 페이지 번호
		//페이지 번호는 (현재 페이지-1)X10 + 1
		NaverBlogCrawler blog = new NaverBlogCrawler(keyword, 1, 991); //100페이지까지 검색됨
		blog.blogCrawler();
		searches.addAll(blog.blogList);
		
		NaverCafeCrawler cafe = new NaverCafeCrawler(keyword, 1, 991); //100페이지까지 검색됨
		cafe.cafeCrawler();
		searches.addAll(cafe.cafeList);
		
		NaverWebCrawler web = new NaverWebCrawler(keyword, 1, 91); //10페이지까지 검색됨
		web.webCrawler();
		searches.addAll(web.webList);
		
		/* 종구 형의 작업 공간*/
	
		HttpSession session = request.getSession();
//		List<Search> searches = new ArrayList<Search>(); // 테스트 내용 지우고 종구형이 작업한거 올려주면 됨
		searchDAO.insert(searches); // db삽입 문구
		model.addAttribute("searches", searches); // 페이지 등록 하기 위함
		
		/*
		if(session.getAttribute("user_no") != null)
		{
			int count = historyDAO.getHistoryCount(Integer.parseInt(session.getAttribute("user_no")+""), keyword);
			History history = new History();
			history.setUser_no(Integer.parseInt(session.getAttribute("user_no")+""));
			history.setHistory_key(keyword);
			if(count == 0)
			{
				history.setHistory_count(1);
				historyDAO.insert(history);
			}
			else
			{
				historyDAO.countUp(Integer.parseInt(session.getAttribute("user_no")+""), keyword);
			}
			
		}*/
		return "search/result"; // 페이지 이동, 받을 떄는 EL사용해서 result페이지에서 받아야함.
		
	}
}
