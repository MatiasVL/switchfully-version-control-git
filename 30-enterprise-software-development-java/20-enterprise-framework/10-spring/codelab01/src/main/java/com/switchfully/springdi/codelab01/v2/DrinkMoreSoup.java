package com.switchfully.springdi.codelab01.v2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class DrinkMoreSoup {
    public static void main(String... args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(DrinkMoreSoup.class);

        Soup deliciousSoup = applicationContext.getBean(Soup.class);

        deliciousSoup.drink();
    }
}
