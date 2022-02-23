package com.geetha.bookclub.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geetha.bookclub.models.Book;
import com.geetha.bookclub.repositories.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepo;
	
	public Book findBookById(Long Id) {
		Optional<Book> book=bookRepo.findById(Id);
		if(book.isPresent()) {
			return book.get();
		}
		return null;
	}

	public List<Book> findAll() {

		return bookRepo.findAll();
	}
	
	public Book saveBook(Book book) {
		return bookRepo.save(book);
	}

	public Book updateBook(Book book) {
		return bookRepo.save(book);
	}
}
