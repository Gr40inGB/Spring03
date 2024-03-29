package org.gr40in.spring03.dto;

import jakarta.annotation.Nonnull;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.NotNull;

@Data
@Builder
public class BookDto {
    long id;
    @NotNull
    String name;
    @NotNull
    String author;
}
