package org.gr40in.spring03.repository;

import org.gr40in.spring03.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
