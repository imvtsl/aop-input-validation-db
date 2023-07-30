package com.vatsal.project.inputvalidationsaopdemo.controller;

import com.vatsal.project.inputvalidationsaopdemo.aop.CheckAuthorExists;
import com.vatsal.project.inputvalidationsaopdemo.dto.Book;
import com.vatsal.project.inputvalidationsaopdemo.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Validated
@RestController
@RequestMapping(value = "/v1/book", produces = MediaType.APPLICATION_JSON_VALUE)
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping(value = "/")
    public ResponseEntity<Book> insertBook(@RequestBody Book book) {
        return ResponseEntity.ok(bookService.createBook(book));
    }
}
