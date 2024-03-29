package org.gr40in.spring03.controller.mapper;

import org.gr40in.spring03.dto.BookDto;
import org.gr40in.spring03.entity.Book;

import java.util.List;

public class BookMapper {
    public BookDto toDto(Book book) {
        return BookDto.builder()
                .name(book.getName())
                .author(book.getAuthor())
                .build();
    }

    public Book toEntity(BookDto bookDto) {
        Book book = new Book();
        book.setName(bookDto.getName());
        return book;
    }

    public List<BookDto> listEntityToListDto(List<Book> list) {
        return list.stream().map(this::toDto).toList();
    }

    public List<Book> listDtoToListEntity(List<BookDto> list) {
        return list.stream().map(this::toEntity).toList();
    }
}

