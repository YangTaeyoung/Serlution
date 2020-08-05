package com.hanium.searlution;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hanium.searlution.dao.SearchDAO;
import com.hanium.searlution.dao.UserDAO;
import com.hanium.searlution.model.Search;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MainController 
{
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	@Autowired
	private UserDAO userDAO;
	private SearchDAO searchDAO;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) 
	{
		return "main/main";
	}
	
	public String getResult(Model model)
	{
		
		
		return "search/result";
	}
	
	
}
