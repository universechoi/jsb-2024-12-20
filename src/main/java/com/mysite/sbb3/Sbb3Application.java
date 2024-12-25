package com.mysite.sbb3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Sbb3Application {
    public static void main(String[] args) {
        SpringApplication.run(Sbb3Application.class, args);
    }
}
