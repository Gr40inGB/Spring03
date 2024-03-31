package org.gr40in.spring03.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @ManyToOne
    private Client client;
    @ManyToOne
    private Book book;

    @DateTimeFormat(pattern = "YYYY-MM-dd")
    LocalDateTime startTime;
    LocalDateTime returnTime;
}
