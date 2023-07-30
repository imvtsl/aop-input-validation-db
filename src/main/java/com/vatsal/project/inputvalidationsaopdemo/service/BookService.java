package com.vatsal.project.inputvalidationsaopdemo.service;

import com.vatsal.project.inputvalidationsaopdemo.aop.CheckAuthorExists;
import com.vatsal.project.inputvalidationsaopdemo.dto.Book;
import com.vatsal.project.inputvalidationsaopdemo.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // use AOP to check for created_by
    @CheckAuthorExists
    public Book createBook(Book book) {
        bookRepository.insert(book);
        return book;
    }
}
