package com.geetha.relationships.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.geetha.relationships.models.License;
import com.geetha.relationships.models.Person;
import com.geetha.relationships.service.LicenseService;
import com.geetha.relationships.service.PersonService;

@Controller
public class AppController {
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private LicenseService licenseService;
	
	@GetMapping("/persons")
	public String dashboard(Model model) {
		List<Person> persons=personService.allPersons();
		model.addAttribute("persons", persons);
		return "homePage.jsp";
	}
	
	@GetMapping("/persons/new")
	public String createPerson(@ModelAttribute("newPerson")Person newPerson) {
		return "newPerson.jsp";
	}
	
	@GetMapping("/persons/{person_id}")
	public String showPerson(@PathVariable Long person_id, Model model) {
	    
	    Person someAwesomePerson = personService.findPersonById(person_id);
	    model.addAttribute("person", someAwesomePerson);
	    
	    return "showPerson.jsp";
	}
	
	@GetMapping("/persons/new")
	public String createLicense(@ModelAttribute("newPerson")Person newPerson) {
		return "newLicense.jsp";
	}
	
	@PostMapping("/licenses")
	public String licenses(@Valid @ModelAttribute("license") License license, BindingResult result, Model model) {
	     
		List<Person> registedPersons= personService.allPersons();
		Person person=personService.findPersonById(license.getPerson().getId());
		if(registedPersons.h)
	    licenseService.create(license); // Already has the person!
	        
	    return "redirect:/persons";
	}
	
	@PostMapping("/persons/new")
	public String savePerson(
			@Valid @ModelAttribute("newPerson")Person newPerson, 
			BindingResult result) {
		if(result.hasErrors()) {
			return "newPerson.jsp";
		}else {
			personService.savePerson(newPerson);
			return "redirect:/persons";
		}
		
	}
	
	@GetMapping("/persons/edit/{id}")
	public String editPerson(
			Model model,
			@PathVariable("id") Long id) {
		Person person= personService.findPersonById(id);
		model.addAttribute("person", person);
		System.out.println("Person id is: "+person.getId());
		return "editPerson.jsp";
	}
	
	@PutMapping("/persons/edit/{person_id}")
	public String updatePerson(
			@Valid @ModelAttribute("person")Person person, 
			BindingResult result) {
		System.out.println("In Update Person Method");
		if(result.hasErrors()) {
			return "editPerson.jsp";
		}else {
			System.out.println("person_id "+ person.getId());
			System.out.println("person_name "+ person.getFirstName() +" "+ person.getLastName());
			
			personService.updatePerson(person);
			return "redirect:/persons";
		}
		
	}

}
