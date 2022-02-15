package com.geetha.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
	@GetMapping("/counter")
	public String homePage(HttpSession session) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 1);
		}
		else {
			int temp = (int) session.getAttribute("count");
			session.setAttribute("count", temp+1);
			
		}
		return "homePage.jsp";
	}
	
	@GetMapping("/showCount")
	public String showCount(HttpSession session, Model model) {
		return "showCount.jsp";
	}
}
