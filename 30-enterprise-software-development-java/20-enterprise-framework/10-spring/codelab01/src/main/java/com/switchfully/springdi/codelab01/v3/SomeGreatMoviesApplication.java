package com.switchfully.springdi.codelab01.v3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.switchfully"})
public class SomeGreatMoviesApplication {
    public static void main(String... args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SomeGreatMoviesApplication.class);

        for (var beanName : applicationContext.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }
    }
}
