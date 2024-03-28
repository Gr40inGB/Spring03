package org.gr40in.spring03.service;

import lombok.RequiredArgsConstructor;
import org.gr40in.spring03.entity.Book;
import org.gr40in.spring03.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository repository;

    public List<Book> getAllBooks() {
        return repository.findAll();
    }
}
