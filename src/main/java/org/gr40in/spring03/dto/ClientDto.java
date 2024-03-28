package org.gr40in.spring03.dto;

import jakarta.annotation.Nonnull;
import lombok.Data;

@Data
public class ClientDto {
    long id;
    @Nonnull
    String name;
    @Nonnull
    String contact;
}
