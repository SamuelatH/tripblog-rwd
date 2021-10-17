package com.java017.tripblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class TripBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(TripBlogApplication.class, args);
    }

}
