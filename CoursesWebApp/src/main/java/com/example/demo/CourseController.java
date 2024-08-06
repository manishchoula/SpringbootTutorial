package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class CourseController {
//	@RequestMapping("/courses")
//	public String courses(@RequestParam("cname")String coursename,HttpSession session) {
////		System.out.println("Welcome to Website");
////		HttpSession session=req.getSession();
////		String cname=req.getParameter("cname");
////		System.out.println("The Course name is "+cname);
//		session.setAttribute("cname",coursename);
//		return "courses";
//	}
	@RequestMapping("/courses")
	public ModelAndView courses(@RequestParam("cname")String coursename) {
		ModelAndView mv=new ModelAndView();
		mv.addObject("cname", coursename);
		mv.setViewName("courses");
		return mv;
	}
}
