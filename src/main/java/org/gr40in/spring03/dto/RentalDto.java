package org.gr40in.spring03.dto;

import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.gr40in.spring03.entity.Book;
import org.gr40in.spring03.entity.Client;

import java.time.LocalDateTime;

@Data
@Builder
public class RentalDto {
    long id;
    @NotNull
    long client_id;
    @NotNull
    long book_id;
    LocalDateTime startTime;
    LocalDateTime returnTime;
}
