package com.switchfully.vaadin_solutions.exercise_01_basic_layouts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:exercise_01.properties")
public class Application_Exercise_01 {

    public static void main(String[] args) {
        SpringApplication.run(com.switchfully.vaadin.exercise_01_basic_layouts.Application_Exercise_01.class);
    }

}