package com.geetha.bookbroker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geetha.bookbroker.models.Book;
import com.geetha.bookbroker.repositories.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepo;
	
	public Book saveBook(Book book) {
		return bookRepo.save(book);
	}
	
	public List<Book> findAllBooks(){
		return bookRepo.findAll();
	} 
	
	public Book findBookById(Long id){
		Optional<Book> potentialBook=bookRepo.findById(id);
		if(potentialBook.isPresent()) {
			return potentialBook.get();
		}
		return null;
	} 
	
	public List<Book> findAvailableBooks(){
		return bookRepo.findByBorrowedbyIsNull();
	} 
	
	public Book updateBook(Book book) {
		return bookRepo.save(book);
	}

	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
	}
}
