package com.hanium.searlution.search;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
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
import com.hanium.searlution.dao.WordCountDAO;
import com.hanium.searlution.model.Search;
import com.hanium.searlution.model.WordCount;
import com.hanium.searlution.crawler.*;


@Controller
public class CrawlingController {
	private static final Logger logger = LoggerFactory.getLogger(CrawlingController.class);
	
	@Autowired
	private SearchDAO searchDAO;
	
	@Autowired
	private HistoryDAO historyDAO;
	
	@Autowired
	private WordCountDAO wordCountDAO;
	
	@Autowired
	ServletContext servletContext;
	
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
			NaverBlogCrawler blog = new NaverBlogCrawler(keyword, 1, 991); //100페이지까지 검색됨
			blog.blogCrawler();
			searches.addAll(blog.blogList);
			
			NaverCafeCrawler cafe = new NaverCafeCrawler(keyword, 1, 991); //100페이지까지 검색됨
			cafe.cafeCrawler();
			searches.addAll(cafe.cafeList);
			
			NaverWebCrawler web = new NaverWebCrawler(keyword, 1, 81); //10페이지까지 검색됨
			web.webCrawler();
			searches.addAll(web.webList);
			searchDAO.pushKey(keyword);
			searchDAO.insert(keyword,searches); // 키워드 이름의 테이블에 리스트 삽입
		}
		//각 블로그, 카페, 웹에서 크롤링 한 결과 list에 저장
		//element는 키워드, 시작 페이지 번호, 끝 페이지 번호
		//페이지 번호는 (현재 페이지-1)X10 + 1
		
		
		
	
		HttpSession session = request.getSession();
//		List<Search> searches = new ArrayList<Search>(); // 테스트 내용 지우고 종구형이 작업한거 올려주면 됨
		
		/* 아래 내용부터 종구형의 input파일을 저장하는 알고리즘임. */
		
		
		
		
		List<WordCount> resultWCs; // 종구형 가공 이후에 나온 카운트 리스트
		
		
		
		// wordCountDAO.insert(resultWCs, keyword); // 다 작성하면 주석 제거할 것.
		
		if(searchDAO.isExist(keyword)) // 이미 keyword로 검색을 한 경우. 다시 말해 이미 wordcount로 조회한 내역이 DB내에 존재하는 경우.
		{
			// resultWCs = wordCountDAO.select(keyword); // DB에 저장된 값을 리스트에 그냥 받아옴. ★ 이것도 작업 끝나면 주석 풀어주셈. 일단 정상 동작을 위해 주석처리
		}
		else // keyword라는 내용으로 검색을 한 적이 없는 경우, 즉, DB에 저장된 내역이 없는 경우
		{
			// input 파일 생성을 위한 저장
			searchDAO.saveFile(keyword); // 파일 저장 함수. 동작 안할 시 없애고 밑에 주석 풀 것. 근데 아마 동작할 듯. 
//			try // 파일 예외처리.
//			{
//				OutputStream os = new FileOutputStream(servletContext.getRealPath("/resources/wordCount/") + keyword+"_key.txt"); // resource\wordCount 폴더에 검색한 단어_key.txt파일로 저장 제목, 내용의 연속
//				byte[] by; // 바이트 형 배열형성
//				for(int i = 0; i < searches.size(); i++)
//				{
//					by = searches.get(i).getSer_title().getBytes(); // 받아온 객채 내의 제목 스트링을 바이트 형식으로 변환. txt파일에 쓰려면 바이트 형식이어야 하므로.
//					os.write(by); // 제목 저장
//					by = searches.get(i).getSer_content().getBytes(); // 내용 스트링을 바이트 형식으로 변환
//					os.write(by); // 내용 저장
//				}
//			}
//			catch(Exception e) 
//			{
//				System.out.println(e.getMessage());
//			}
			
			/* 종구 형의 작업 공간 wordCount돌리고 어쩌구 저쩌구*/
			
			
			// 이 부분에서 리스트 resultWCs안에 종구형이 작업한 동작하는 카운트를 넣어 주어야 함. get, set함수 이용
			
			// wordCountDAO.insert(resultWCs, keyword); db에 저장하는 함수, wordcount 작업 끝나면 풀 것.
			
		}
		
		for(int i = 0; i < searches.size(); i++) // 출력전 내용을 100글자로 자르는 알고리즘
		{
			if(searches.get(i).getSer_content().length() > 100)
				searches.get(i).setSer_content(searches.get(i).getSer_content().substring(0, 100) + "...");
		}
		
		// model.addAttribute("wordCounts", resultWCs); 종구 형 작업 끝나면 풀 것. 페이지에 wordcount 내역을 저장하기 위함.
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

