package com.hanium.searlution.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hanium.searlution.dao.UserDAO;
import com.hanium.searlution.model.User;

@Controller
public class UserContorller {
	
	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping(value="/join/user", method=RequestMethod.POST)
	public String join()
	{
		
		return "main/main";
	}
	
	@RequestMapping(value="/login/user", method=RequestMethod.POST)
	public String login(HttpServletRequest request, @RequestParam(value="user_email") String user_email, @RequestParam(value="user_pw") String user_pw)
	{
		HttpSession session = request.getSession();
		User userChk = userDAO.select(user_email);
		if(userChk !=null && userChk.getUser_pw().equals(user_pw)) // 로그인 성공 시
		{
			session.setAttribute("user_no", userChk.getUser_no()); // 로그인 처리는 오직 유저 번호로만 처리하겠음.
			return "main/main";
		}
		else // 로그인 실패 시   
		{
			return "main/main";
		}
	}
}
