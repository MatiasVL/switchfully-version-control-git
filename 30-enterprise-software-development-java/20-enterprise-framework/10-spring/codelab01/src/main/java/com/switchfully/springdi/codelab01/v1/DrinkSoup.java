package com.switchfully.springdi.codelab01.v1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.switchfully.springdi.codelab01.v1"})
public class DrinkSoup {
    public static void main(String... args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(DrinkSoup.class);

        Royco deliciousSoup = applicationContext.getBean(Royco.class);

        deliciousSoup.drink();
    }
}
