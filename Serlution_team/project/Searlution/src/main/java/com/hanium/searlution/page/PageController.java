package com.hanium.searlution.page;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hanium.searlution.crawler.*;

@Controller
public class PageController {
	
	// 로딩중으로 가는 페이지 컨트롤러
	@RequestMapping(value="loading.do", method=RequestMethod.GET)
	public String goLoading(Model model,@RequestParam("keyword") String keyword) 
	{
		model.addAttribute("keyword", keyword);
		return "search/loading";
	}
	
	// 원형 차트로 가는 페이지 컨트롤러
	@RequestMapping(value="circle.chart", method=RequestMethod.GET)
	String goCircle(HttpServletRequest request, Model model, @RequestParam("keyword") String keyword) // 원형 차트 페이지 이동 
	{
		HttpSession session = request.getSession();
		
		model.addAttribute("keyword", keyword);
		if(session.getAttribute("user_no") != null) // 로그인시
			return "result/chart/circle";  // 원형차트 페이지로 이동하겠음.
		else
			return "search/result";
	}
	
	// 그래프로 가는 페이지 컨트롤러
	@RequestMapping(value="graph.chart", method=RequestMethod.GET)
	String goGraph(HttpServletRequest request, Model model, @RequestParam("keyword") String keyword) throws UnsupportedEncodingException
	{
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		String[] tmpStr = new NaverGraph(keyword).graphStr();
		// model.addattribute("변수명: 넘길 값의 이름", 넘길 실제 값): jsp 페이지로 넘기고 싶은 값을 전달함.  
		// 받을 떄는 JSTL을 통해서 받아야 함. JSP 내부에서 사용하는 예시: ${변수명} 밑에 키워드 값을 넘기는 예제 있음.
		model.addAttribute("label", tmpStr[0]);
		model.addAttribute("data", tmpStr[1]);
 		model.addAttribute("keyword", keyword); // 키워드를 헤당 페이지에 넘김. 받는 JSP페이지 -> ${keyword}로 받음
		if(session.getAttribute("user_no") != null) // 로그인 시
			return "result/chart/graph"; // 그래프 페이지로 이동
		else // 로그인 안하면
			return "search/result"; // 못가지롱
	}
	@RequestMapping(value="analysis.do", method=RequestMethod.GET)
	String goAnalysis(HttpServletRequest request, Model model, @RequestParam("keyword") String keyword) // 
	{
		HttpSession session = request.getSession();
		model.addAttribute("keyword", keyword);
		if(session.getAttribute("user_no") != null)
			return "result/analysis";
		else
			return "search/result";
	}
	
	
}
