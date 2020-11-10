package com.hanium.searlution.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hanium.searlution.dao.UserDAO;
import com.hanium.searlution.model.User;

@Controller
public class UserContorller {
	
	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping(value="/user/join", method=RequestMethod.GET)
	public String join(Model model)
	{		
		model.addAttribute("user", new User());
		return "member/join";
	}
	@RequestMapping(value="/user/join/chk", method=RequestMethod.POST)
	public String joinChk(@RequestParam(value="user_pwChk") String user_pwChk,@ModelAttribute User user )
	{
		if(user.getUser_pw().equals(user_pwChk))
		{
			userDAO.insert(user);
			return "main/main";	
		}
		else
		{
			return "member/join";
		}
	}
	@RequestMapping(value="/user/login", method=RequestMethod.GET)
	public String getLoginPg()
	{
		return "member/login";
	}
	
	@RequestMapping(value="/user/logout", method=RequestMethod.GET)
	public String logout(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		session.invalidate();
		return "main/main";
	}
	@RequestMapping(value="/user/login/chk", method=RequestMethod.GET)
	public String login(HttpServletRequest request, HttpServletResponse response, @RequestParam(value="user_email") String user_email, @RequestParam(value="user_pw") String user_pw) throws IOException
	{ 
		HttpSession session = request.getSession();
		User userChk = userDAO.select(user_email);
		System.out.println("Email:" + userChk.getUser_email() + "\nPW:" + userChk.getUser_pw());
		if(userChk !=null && userChk.getUser_pw().equals(user_pw)) // 로그인 성공 시
		{
			session.setAttribute("user_no", userChk.getUser_no()); // 로그인 처리는 오직 유저 번호로만 처리하겠음.	
		}
		else // 로그인 실패 시   
		{
			//response.setContentType("text/html; charset=UTF-8");
			//PrintWriter out = response.getWriter();
			//out.println("<script>alert('로그인 정보를 확인해주세요.'); history.go(-1);</script>");
		//	out.flush();
		}
		return "main/main";
	}
}
