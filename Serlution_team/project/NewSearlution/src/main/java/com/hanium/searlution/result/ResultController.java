package com.hanium.searlution.result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ResultController {
	
	@RequestMapping(value="circle.chart", method=RequestMethod.GET)
	String goCircle(HttpServletRequest request) // 원형 차트 페이지 이동 
	{
		HttpSession session = request.getSession();
		if(session.getAttribute("user_no") != null) // 로그인시
			return "result/chart/circle";  // 원형차트 페이지로 이동하겠음.
		else
			return "search/result";
	}
	
	@RequestMapping(value="graph.chart", method=RequestMethod.GET)
	String goGraph(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		
		if(session.getAttribute("user_no") != null) // 로그인 시
			return "result/chart/graph"; // 그래프 페이지로 이동
		else // 로그인 안하면
			return "search/result"; // 못가지롱
	}
	
	@RequestMapping(value="analysis.do", method=RequestMethod.GET)
	String goAnalysis(HttpServletRequest request) // 
	{
		HttpSession session = request.getSession();
		if(session.getAttribute("user_no") != null)
			return "result/analysis";
		else
			return "search/result";
	}
	
	
}
