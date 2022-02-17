package com.example.mvcdemo.contollers;



import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.example.mvcdemo.models.Book;
import com.example.mvcdemo.service.BookService;

@Controller
public class BooksApi {
    private final BookService bookService;
    public BooksApi(BookService bookService){
        this.bookService = bookService;
    }
    // other methods removed for brevity
    
    @GetMapping("/books")
    public String getAllBooks(Model model){
    	List<Book> books= bookService.allBooks();
    	model.addAttribute("books", books);
    	return "dashboard.jsp";
    }
    
    @GetMapping("/books/{id}")
    public String getAllBooks(@PathVariable("id") Long id, Model model){
    	Book book = bookService.findBook(id);
    	model.addAttribute("book", book);
    	return "viewBook.jsp";
    }
    
    @PostMapping("/api/books/new")
    public Book create(@RequestParam(value="title") String title, 
    		@RequestParam(value="description") String description, 
    		@RequestParam(value="language") String lang,
    		@RequestParam(value="pages") Integer numOfPages) {
    	Book book = new Book( title,  description,  lang,  numOfPages);
    	return bookService.save(book);
    	
    }
    
    @PostMapping("/api/books/{id}")
    public Book update(
    		@PathVariable("id") Long id, 
    		@RequestParam(value="title") String title, 
    		@RequestParam(value="description") String description, 
    		@RequestParam(value="language") String lang,
    		@RequestParam(value="pages") Integer numOfPages) {
    	
    	Book book = bookService.findBook(id);
    	book.setTitle(title);
    	book.setDescription(description);
        book.setLanguage(lang);
        book.setNumberOfPages(numOfPages);
        bookService.updateBook(book);
        return book;
    }
    
    @RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
    }
}