package com.heidichen.firstmvcdemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.heidichen.firstmvcdemo.models.Icecream;
import com.heidichen.firstmvcdemo.services.IcecreamService;

@RestController
public class APIController {

	@Autowired
	private IcecreamService icecreamService;
	
	// FindAll
	@GetMapping("/api/icecreams")
	public List<Icecream> showAll(){
		return icecreamService.allIcecreams();
	}
	
	// Create
	@PostMapping("/api/icecreams")
	public Icecream createIcecream(
			@RequestParam("flavor")String flavor,
			@RequestParam("price")Double price,
			@RequestParam("description") String description
			) {
		Icecream icecream = new Icecream(flavor, price, description);
		return icecreamService.createIcecream(icecream);
	}
	
	
	// showOne
	@GetMapping("/api/icecreams/{id}")
	public Icecream showOne(@PathVariable("id")Long id) {
		return icecreamService.findIcecream(id);
	}
	
	
	//updateOne
	
	//bind in the controller
	@PutMapping("/api/icecreams/{id}")
	public Icecream updateOne(@PathVariable("id")Long id,
			@RequestParam("flavor")String flavor,
			@RequestParam("price")Double price,
			@RequestParam("description") String description) {
		// get the icecream to be editted
		Icecream icecream = icecreamService.findIcecream(id);
		icecream.setFlavor(flavor);
		icecream.setDescription(description);
		icecream.setPrice(price);
		return icecreamService.updateIcecream(icecream);
	}
	
	//deleteOne
	@DeleteMapping("/api/icecreams/{id}")
	public void deleteOne(@PathVariable("id")Long id) {
		icecreamService.deleteIcecream(id);
	}
	
	
}












