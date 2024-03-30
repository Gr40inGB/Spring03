package org.gr40in.spring03.config;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@NoArgsConstructor
@ConfigurationProperties(prefix = "library")
public class LibraryProperties {
    private Integer allowed = 1;
}
