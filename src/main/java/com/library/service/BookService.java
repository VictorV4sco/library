package com.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.model.Book;
import com.library.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	BookRepository repository;

	public List<Book> findAll() {
		return repository.findAll();
	}

	public Book findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new RuntimeException("No records found for this ID"));
	}

	public Book create(Book book) {
		return repository.save(book);
	}

	public Book update(Book book) {
		Book entity = repository.findById(book.getId())
				.orElseThrow(() -> new RuntimeException("No records found for this ID"));

		entity.setName(book.getName());
		entity.setAuthor(book.getAuthor());
		entity.setLiteraryGenre(book.getLiteraryGenre());
		entity.setPrice(book.getPrice());

		return repository.save(entity);
	}

	public void delete(Long id) {
		Book entity = repository.findById(id).orElseThrow(() -> new RuntimeException("No records found for this ID"));
		repository.delete(entity);
	}
}
