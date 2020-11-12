package com.hanium.searlution.search;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;



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
import com.hanium.searlution.model.Search;
import com.hanium.searlution.crawler.*;


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
		
		if(searchDAO.isExist(keyword)) // 해당 키워드를 담은 테이블이 데이터 베이스에 존재하는 경우
		{
			
			searches = searchDAO.select(keyword); // 이미 존재하는 테이블에서 자료만 빼옴
		}
		else // 해당 키워드를 담은 테이블이 존재하지 않는 경우
		{
			searchDAO.createTable(keyword); // 키워드의 이름으로 테이블 생성
			
			NaverBlogCrawler blog = new NaverBlogCrawler(keyword, 1, 991); //100페이지까지 검색됨
			blog.blogCrawler();
			searches.addAll(blog.blogList);
			
			NaverCafeCrawler cafe = new NaverCafeCrawler(keyword, 1, 991); //100페이지까지 검색됨
			cafe.cafeCrawler();
			searches.addAll(cafe.cafeList);
			
			NaverWebCrawler web = new NaverWebCrawler(keyword, 1, 81); //10페이지까지 검색됨
			web.webCrawler();
			searches.addAll(web.webList);
			
			searchDAO.insert(keyword,searches); // 키워드 이름의 테이블에 리스트 삽입
		}
		//각 블로그, 카페, 웹에서 크롤링 한 결과 list에 저장
		//element는 키워드, 시작 페이지 번호, 끝 페이지 번호
		//페이지 번호는 (현재 페이지-1)X10 + 1
		
		
		/* 종구 형의 작업 공간*/
	
		HttpSession session = request.getSession();
//		List<Search> searches = new ArrayList<Search>(); // 테스트 내용 지우고 종구형이 작업한거 올려주면 됨
		
		for(int i = 0; i < searches.size(); i++)
		{
			if(searches.get(i).getSer_content().length() > 100)
				searches.get(i).setSer_content(searches.get(i).getSer_content().substring(0, 100) + "...");
		}
		model.addAttribute("searches", searches); // 페이지 등록 하기 위함
		model.addAttribute("keyword", keyword);
		
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

