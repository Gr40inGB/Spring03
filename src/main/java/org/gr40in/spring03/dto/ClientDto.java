package org.gr40in.spring03.dto;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientDto {
    long id;
    @NotNull
    String name;
    @NotNull
    String contact;
}
