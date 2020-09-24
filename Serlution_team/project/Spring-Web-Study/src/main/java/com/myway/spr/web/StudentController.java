package com.myway.spr.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myway.spr.dao.StudentDAO;
import com.myway.spr.model.Student;

@Controller
public class StudentController {
	Logger logger = LoggerFactory.getLogger(StudentController.class);
	@Autowired
	private StudentDAO studentDAO;
	
	@RequestMapping(value="/student01.do", method=RequestMethod.GET)
	public String student01(Model model)
	{
		model.addAttribute("student", new Student());
		return "student/student";
	}
	
	@RequestMapping(value="/student02.do", method=RequestMethod.GET)
	public ModelAndView student02()
	{
		return new ModelAndView("student/student", "student", new Student());
	}
	
	@RequestMapping(value = "/add/student.do", method=RequestMethod.POST)
	public String addStudent(@ModelAttribute Student student, Model model)
	{
		model.addAttribute("student", student);
		//studentDAO.create(student);
		studentDAO.sampleTransaction(student);
		return "student/result";			
	}
	// student 조회 요청
	@RequestMapping(value="/student_list", method=RequestMethod.GET)
	public String getStudents(Model model, @RequestParam(value="seq",required = false, defaultValue = "0") Integer seq)
	{
		if(seq == 0)
		{
			// 학생 리스트 조회
			List<Student> students = studentDAO.select();
			model.addAttribute("students", students);
			return "student/list";
		}
		else
		{
			// 학생 단건 조회
			model.addAttribute("student", studentDAO.select(seq));
			return "student/result";
		}
	}
}
