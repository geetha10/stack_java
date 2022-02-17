package com.heidichen.firstmvcdemo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.heidichen.firstmvcdemo.models.Icecream;
import com.heidichen.firstmvcdemo.services.IcecreamService;

@Controller
public class HomeController {
	
	@Autowired
	private IcecreamService icecreamService;
	
	@GetMapping("/")
	public String dashboard(Model model) {
		List<Icecream> icecreams = icecreamService.allIcecreams();
		model.addAttribute("icecreams", icecreams);
		return "dashboard.jsp";
	}
	
	@GetMapping("/icecreams/{id}")
	public String showOneIcecream(@PathVariable("id")Long id, Model model) {
		Icecream icecream = icecreamService.findIcecream(id);
		model.addAttribute("icecream", icecream);
		return "showOne.jsp";
	}
	
	// ******************* CREATE *********************
	// CREATE  --  Get to render a form, post to process the form
	
	// RENDER CREATE FORM (GET)
	// OPTION 1
	@GetMapping("/icecreams/new")
	public String createForm(@ModelAttribute("icecream")Icecream icecream) {
		return "createForm.jsp";
	}
	
	//OPTION 2
	@GetMapping("/icecreams2/new")
	public String createForm2(Model model) {
		Icecream i = new Icecream();
		model.addAttribute("icecream", i);
		return "createForm.jsp";
		// @ModelAttribute create an empty object
	}
	
	
	// PROCESS THE CREATE FORM (POST)
	@PostMapping("/icecreams/new")
	public String processCreate(@Valid @ModelAttribute("icecream")Icecream icecream, BindingResult result) {
		if(result.hasErrors()) {
			return "createForm.jsp";
		}else {
			icecreamService.createIcecream(icecream);
			return "redirect:/icecreams";			
		}		
	}
	
	// ******************* DASHBOARD WITH CREATE FORM *********************
	
	@GetMapping("/icecreams")
	public String dashboardForm(Model model,@ModelAttribute("icecream")Icecream icecream) {
//		model.addAttribute("icecream", new Icecream());
		List<Icecream> icecreams = icecreamService.allIcecreams();
		model.addAttribute("icecreams", icecreams);
		return "dashboardForm.jsp";
	}
	
	@PostMapping("/icecreams")
	public String processDashboardCreate(@Valid @ModelAttribute("icecream")Icecream icecream, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("icecreams", icecreamService.allIcecreams());
			return "dashboardForm.jsp";
		}else {
			icecreamService.createIcecream(icecream);
			return "redirect:/icecreams";			
		}		
	}
	
	// ******************* EDIT *********************
	// findOne + create
	@GetMapping("/icecreams/edit/{id}")
	public String editForm(@PathVariable("id")Long id, Model model) {
		Icecream icecream = icecreamService.findIcecream(id);
		model.addAttribute("icecream", icecream);
		return "editForm.jsp";
	}
	
	@PutMapping("/icecreams/edit/{id}")
	public String processEdit(@Valid @ModelAttribute("icecream")Icecream icecream, BindingResult result) {
		if(result.hasErrors()) {
			return "editForm.jsp";
		}else{
			icecreamService.updateIcecream(icecream);
			return "redirect:/icecreams";
		}
	}
	
	// ******************* DELETE *********************
	@DeleteMapping("/icecreams/delete/{id}")
	public String deleteIcecream(@PathVariable("id")Long id) {
		icecreamService.deleteIcecream(id);
		return "redirect:/icecreams";
	}
	
	
	
	
}
