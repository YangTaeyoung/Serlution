package com.hanium.searlution.search;

import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hanium.searlution.dao.SearchDAO;
import com.hanium.searlution.model.Search;

@Controller
public class CrawlingController {
	private static final Logger logger = LoggerFactory.getLogger(CrawlingController.class);
	private SearchDAO searchDAO;
	@RequestMapping(value="search.do")
	public String searchDo(Model model, @RequestParam("keyword") String keyword)
	{
		/* 도경이는 여기서 작업하면 됨. */
		// 결과 값을 넘겨주고 싶으면 model.addAttribute("이름", 보내고 싶은 값); 사용해서 보내기.
		
		/* 종구 형의 작업 공간*/
	
		
		List<Search> searches = null; // 종구형이 리스트 형태로 나눠서 넣어야 하는 곳.
		
		searchDAO.insert(searches); // db삽입 문구
		model.addAttribute("searches", searches); // 페이지 등록 하기 위함
		
		return "search/result"; // 페이지 이동, 받을 떄는 EL사용해서 result페이지에서 받아야함.
		
	}
}
