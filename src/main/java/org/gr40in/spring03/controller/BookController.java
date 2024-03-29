package org.gr40in.spring03.controller;

import lombok.RequiredArgsConstructor;
import org.gr40in.spring03.dto.BookDto;
import org.gr40in.spring03.entity.Book;
import org.gr40in.spring03.repository.BookRepository;
import org.gr40in.spring03.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService service;

    @GetMapping()
    public ResponseEntity<List<Book>> getBooks(Model model) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllBooks());
    }

    @PostMapping()
    public ResponseEntity<List<Book>> createBook( @RequestBody BookDto book) {

        service.createBook(book);
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllBooks());
    }
}
