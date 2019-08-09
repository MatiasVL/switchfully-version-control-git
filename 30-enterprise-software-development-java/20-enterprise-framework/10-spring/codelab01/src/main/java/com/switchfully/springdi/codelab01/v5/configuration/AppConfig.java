package com.switchfully.springdi.codelab01.v5.configuration;

import com.switchfully.springdi.codelab01.v5.enums.DeliveryVanType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.switchfully.spring.codelab.v5.entities")
public class AppConfig {

    @Bean
    public DeliveryVanType getVanType(){
        return DeliveryVanType.BIG;
    }

    @Bean("DriverName")
    public String getDriverName(){
        return "Karel";
    }

    @Bean("ContentOfParcel")
    public String getContentOfPackage(){
        return "Amazon Echo";
    }

    @Bean
    public int getDriverAge(){
        return 21;
    }

    @Bean
    public int getPriceOfParcel(){
        return 120;
    }

}
