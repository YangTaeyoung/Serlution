package com.hanium.searlution.search;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CrawlingController {
	private static final Logger logger = LoggerFactory.getLogger(CrawlingController.class);
	
	@RequestMapping(value="search.do")
	public String searchDo(Model model, @RequestParam("keyword") String keyword)
	{
		
		/* 도경이는 여기서 작업하면 됨. */
		// 결과 값을 넘겨주고 싶으면 model.addAttribute("이름", 보내고 싶은 값); 사용해서 보내기.
		
		return "result"; // 받을 떄는 EL사용해서 result페이지에서 받아야함.
		
	}
}
