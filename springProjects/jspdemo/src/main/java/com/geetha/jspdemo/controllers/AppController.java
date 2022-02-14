package com.geetha.jspdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
	
	@GetMapping("/")
	public String testController() {
		return "index.jsp";
	}
	
	@GetMapping("/dojo")
    public String index(Model model) {
        model.addAttribute("dojoName", "Burbank");
        return "dojo.jsp";
    }

}
