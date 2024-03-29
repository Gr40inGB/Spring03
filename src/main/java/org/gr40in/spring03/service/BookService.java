package org.gr40in.spring03.service;

import lombok.RequiredArgsConstructor;
import org.gr40in.spring03.dto.BookDto;
import org.gr40in.spring03.entity.Book;
import org.gr40in.spring03.mapper.BookMapper;
import org.gr40in.spring03.repository.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository repository;
    private final BookMapper mapper;

    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    public Book getBookById(long id) {
        var book = repository.findById(id);
        if (book.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "id " + id + " not found");
        return book.get();
    }

    public Book createBook(BookDto book) {
        return repository.save(mapper.toEntity(book));
    }




}
