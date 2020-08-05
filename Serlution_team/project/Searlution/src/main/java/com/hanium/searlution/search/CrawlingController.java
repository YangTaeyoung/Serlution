package com.hanium.searlution.search;

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
import com.hanium.searlution.model.History;
import com.hanium.searlution.model.Search;

@Controller
public class CrawlingController {
	private static final Logger logger = LoggerFactory.getLogger(CrawlingController.class);
	
	@Autowired
	private SearchDAO searchDAO;
	
	@Autowired
	private HistoryDAO historyDAO;
	
	@RequestMapping(value="search.do")
	public String searchDo(HttpServletRequest request, Model model, @RequestParam("keyword") String keyword)
	{
		/* 도경이는 여기서 작업하면 됨. */
		// 결과 값을 넘겨주고 싶으면 model.addAttribute("이름", 보내고 싶은 값); 사용해서 보내기.
		
		/* 종구 형의 작업 공간*/
	
		HttpSession session = request.getSession();
		List<Search> searches = new ArrayList<Search>(); // 테스트 내용 지우고 종구형이 작업한거 올려주면 됨
		Search sample = new Search();
		sample.setSer_no(0);
		sample.setSer_title("테스트 게시글 제목");
		sample.setSer_content("게시글 테스트 내용");
		sample.setSer_link("테스트 게시글 링크");
		sample.setSer_date("2020-08-05");
		searches.add(sample);
		System.out.println(sample);
		searchDAO.insert(sample); // db삽입 문구
		model.addAttribute("searches", searches); // 페이지 등록 하기 위함
		
		
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
			
		}
		return "search/result"; // 페이지 이동, 받을 떄는 EL사용해서 result페이지에서 받아야함.
		
	}
}
