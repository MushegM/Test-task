package com.Web_test.service;

import com.Web_test.model.Book;
import com.Web_test.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service

public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Page<Book> getFilteredBooks(String title, String brand, int year, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return bookRepository.findByFilters(title, brand, year, pageable);
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}

