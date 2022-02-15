package com.geetha.displaydate.controllers;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
	
	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		return "dashboard.jsp";
	}
	
	@GetMapping("/displayDate")
	public String displayDate(Model model) {
		Date date= new Date();
		
		return "displayDate.jsp";
	}
	
	@GetMapping("/displayTime")
	public String displayTime(Model model) {
		return "displayTime.jsp";
	}
}
