package org.gr40in.spring03.dto;

import jakarta.persistence.OneToOne;
import org.gr40in.spring03.entity.Book;
import org.gr40in.spring03.entity.Client;

import java.time.LocalDateTime;

public class RentalDto {
    long id;
    long client_id;
    long book_id;
    LocalDateTime startTime;
    LocalDateTime returnTime;
}
