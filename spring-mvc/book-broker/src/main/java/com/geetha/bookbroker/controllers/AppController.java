package com.geetha.bookbroker.controllers;

import javax.servlet.http.HttpSession;
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

import com.geetha.bookbroker.models.Book;
import com.geetha.bookbroker.service.BookService;
import com.geetha.bookbroker.service.UserService;

@Controller
public class AppController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/books/new")
	public String addNewBookToShelf(@ModelAttribute("book") Book book) {
		return "addBook.jsp";
	}
	
	@PostMapping("/books/new")
	public String saveBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if(result.hasErrors()) {
			return "addBook.jsp";
		}
		bookService.saveBook(book);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/books/{id}")
	public String showBookDetails(@PathVariable("id") Long id, Model model) {
		model.addAttribute("book", bookService.findBookById(id));
		return "showBook.jsp";
	}
	
	@GetMapping("/books/{id}/edit")
	public String editBook( @PathVariable("id") Long id, Model model) {
		model.addAttribute("book", bookService.findBookById(id));
		return "editBook.jsp";
	}
	
	@PutMapping("/books/{id}/edit")
	public String updateBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if(result.hasErrors()) {
			return "editBook.jsp";
		}
		bookService.updateBook(book);
		return "redirect:/dashboard";
	}
	
	@PutMapping("/books/{id}/borrow")
	public String borrowBook(@PathVariable("id") Long id, HttpSession session) {
		Book book=bookService.findBookById(id);
		book.setBorrowedby(userService.getUserById((Long)session.getAttribute("userId")));
		bookService.saveBook(book);
		return "redirect:/dashboard";
	}
	
	@PutMapping("/books/{id}/return")
	public String returnBook(@PathVariable("id") Long id, HttpSession session) {
		Book book=bookService.findBookById(id);
		book.setBorrowedby(null);
		bookService.saveBook(book);
		return "redirect:/dashboard";
	}
	
	@DeleteMapping("/books/delete/{id}")
	public String deleteBook(@PathVariable("id") Long id) {
		bookService.deleteBook(id);
		return "redirect:/dashboard";
	}
}
