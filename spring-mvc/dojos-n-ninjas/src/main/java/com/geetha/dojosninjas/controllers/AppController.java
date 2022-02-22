package com.geetha.dojosninjas.controllers;

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

import com.geetha.dojosninjas.models.Dojo;
import com.geetha.dojosninjas.models.Ninja;
import com.geetha.dojosninjas.service.AppService;

@Controller
public class AppController {
	
	@Autowired
	AppService appService;
	
	@GetMapping("/dashboard")
	public String dashboard(@ModelAttribute("dojo") Dojo dojo, Model model){
		List<Dojo> dojoLocations = appService.getAllDojos();
		model.addAttribute("dojoLocations", dojoLocations);
		return "dashboard.jsp";
	}
	
	//Dojo Table related routes
	@PostMapping("/dojo/new")
	public String saveDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Dojo> dojoLocations = appService.getAllDojos();
			model.addAttribute("dojoLocations", dojoLocations);
			return "dashboard.jsp";
		}else {
			appService.saveDojo(dojo);
			return "redirect:/dashboard";
		}
	}
	
	@GetMapping("/dojo/ninjas/{id}")
	public String getAllNinjas(@PathVariable("id") Long id, Model model) {
		Dojo dojo=appService.findDojoById(id);
		List<Ninja> allNinjas=appService.getAllNinjas();
		model.addAttribute("dojo", dojo);
		model.addAttribute("ninjas", allNinjas);
		return "showNinjas.jsp";
	}
	
	//Ninja Table related routes
	@GetMapping("/ninja/new")
	public String addNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> dojoLocations = appService.getAllDojos();
		model.addAttribute("dojoLocations", dojoLocations);
		return "addNinja.jsp";
	}
	
	@PostMapping("/ninja/new")
	public String saveNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			return "addNinja.jsp";
		}else {
			appService.saveNinja(ninja);
			return "redirect:/dashboard";
		}
	}
	
	@GetMapping("/ninja/edit/{id}")
	public String editNinja(@ModelAttribute("ninja") Ninja ninja, Model model, @PathVariable("id") Long id) {
		List<Dojo> dojoLocations = appService.getAllDojos();
		Ninja ninjaToEdit=appService.findNinjaById(id);
		model.addAttribute("ninja", ninjaToEdit);
		model.addAttribute("dojoLocations", dojoLocations);
		return "editNinja.jsp";
	}
	
	@PutMapping("/ninja/edit/{id}")
	public String editNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result,@PathVariable("id") Long id) {
		if(result.hasErrors()) {
			return "editNinja.jsp";
		}else {
			appService.updateNinja(ninja);
			return "redirect:/dojo/ninjas/"+String.valueOf(ninja.getDojo().getId());
		}
	}
	
	@DeleteMapping("/ninja/delete/{id}")
	public String deletNinja(@PathVariable("id") Long id) {
		Long dojoId=appService.findNinjaById(id).getDojo().getId();
		appService.deleteNinja(id); 
		return "redirect:/dojo/ninjas/"+String.valueOf(dojoId);
	}
}
