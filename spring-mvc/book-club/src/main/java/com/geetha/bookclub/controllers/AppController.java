package com.geetha.bookclub.controllers;

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

import com.geetha.bookclub.models.Book;
import com.geetha.bookclub.service.BookService;

@Controller
public class AppController {
	
	@Autowired
	private BookService bookservice;
	
	@GetMapping("/books/new")
	public String addNewBook(@ModelAttribute("book") Book book) {
		return "addBook.jsp";
	}
	
	@PostMapping("/books/new")
	public String saveNewBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if(result.hasErrors()) {
			return "addBook.jsp";
		}
		bookservice.saveBook(book);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/books/{id}")
	public String showBookDetails(@PathVariable("id") Long id, Model model) {
		model.addAttribute("book", bookservice.findBookById(id));
		return "showBook.jsp";
	}
	
	@GetMapping("/books/{id}/edit")
	public String editBook(@PathVariable("id") Long id, Model model) {
		model.addAttribute("book", bookservice.findBookById(id));
		return "editBook.jsp";
	}
	
	@PutMapping("/books/{id}/edit")
	public String updateBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if(result.hasErrors()) {
			return "editBook.jsp";
		}
		bookservice.updateBook(book);
		return "redirect:/dashboard";
	}

}
