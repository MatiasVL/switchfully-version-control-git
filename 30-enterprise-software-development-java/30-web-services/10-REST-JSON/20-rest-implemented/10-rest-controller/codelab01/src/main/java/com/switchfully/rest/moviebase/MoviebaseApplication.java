package com.switchfully.rest.moviebase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.switchfully.rest.moviebase")
public class MoviebaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoviebaseApplication.class, args);
    }

}
