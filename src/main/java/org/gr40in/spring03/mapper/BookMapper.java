package org.gr40in.spring03.mapper;

import org.gr40in.spring03.dto.BookDto;
import org.gr40in.spring03.entity.Book;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class BookMapper {
    public BookDto toDto(Book book) {
        return BookDto.builder()
                .name(book.getName())
                .author(book.getAuthor())
                .build();
    }

    public Book toEntity(BookDto bookDto) {
        return Book.builder()
                .id(bookDto.getId())
                .author(bookDto.getAuthor())
                .name(bookDto.getName())
                .build();
    }

    public List<BookDto> listEntityToListDto(List<Book> list) {
        return list.stream().map(this::toDto).toList();
    }

    public List<Book> listDtoToListEntity(List<BookDto> list) {
        return list.stream().map(this::toEntity).toList();
    }
}

