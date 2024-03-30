package org.gr40in.spring03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class Spring03Application {

    public static void main(String[] args) {
        SpringApplication.run(Spring03Application.class, args);

    }

}
