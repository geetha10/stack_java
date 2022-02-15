package com.geetha.omikuji.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppController {
	
	@GetMapping("/omikuji")
	public String sendOmikujiForm() {
		return "sendOmikujiForm.jsp";
	}
	
	@PostMapping("/processOmikuji")
	public String processOmikuji(
			@RequestParam("choosedNumber") int choosedNumber,
			@RequestParam("city") String  city,
			@RequestParam("personName") String personName,
			@RequestParam("hobby") String hobby,
			@RequestParam("thing") String thing,
			@RequestParam("niceThing") String niceThing,
			HttpSession session
			) {
		session.setAttribute("choosedNumber", choosedNumber);
		session.setAttribute("city", city);
		session.setAttribute("personName", personName);
		session.setAttribute("hobby", hobby);
		session.setAttribute("thing", thing);
		session.setAttribute("niceThing", niceThing);
		return "redirect:/omikujiResult";
	}
	
	@GetMapping("/omikujiResult")
	public String omikujiResult() {
		return "omikujiResult.jsp";
	}

}
