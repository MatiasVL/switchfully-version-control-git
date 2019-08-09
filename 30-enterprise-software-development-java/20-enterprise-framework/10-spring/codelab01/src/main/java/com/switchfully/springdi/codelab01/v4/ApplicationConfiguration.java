package com.switchfully.springdi.codelab01.v4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ApplicationConfiguration {
    @Bean("NewLine")
    public String getString1() {
        return "\n";
    }

    @Bean("WhoAmITalkingTo")
    @Primary
    public String getSubject() {
        return "Lord";
    }

    @Bean
    public String abc() {
        return "friends";
    }

    @Bean
    public String more() {
        return "Porsches";
    }

    @Bean
    public String theFinalString() {
        return "Mercedes Benz";
    }
}