package com.switchfully.springdi.codelab01.v5.configuration;

import com.switchfully.springdi.codelab01.v5.entities.DriversLicense;
import com.switchfully.springdi.codelab01.v5.enums.DeliveryVanType;
import com.switchfully.springdi.codelab01.v5.enums.DriverLicenseType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = "com.switchfully.springdi.codelab01.v5.entities")
public class AppConfig {

    @Bean("DriverName")
    public String getDriverName() {
        return "Karel";
    }

    @Bean("ContentOfParcel")
    public String getContentOfPackage() {
        return "Amazon Echo";
    }

    @Bean
    public int getDriverAge() {
        return 21;
    }

    @Bean
    public int getPriceOfParcel() {
        return 120;
    }

    @Bean
    @Primary
    public DriversLicense getDriversLicense() {
        return new DriversLicense(DriverLicenseType.A);
    }

    @Bean
    public DriversLicense getAnOtherDriversLicense() {
        return new DriversLicense(DriverLicenseType.B);
    }

    @Bean
    public DriversLicense i_can_call_this_method_anything_i_want_but_that_is_not_a_good_idea() {
        return new DriversLicense(DriverLicenseType.C);
    }

    @Bean
    /**
     * ⚠️This @Bean only exists as an example.
     * It supports the autowiring of the DeliveryVan.
     *
     * In reality it is very unlikely to turn an Enum into a bean.
     * When a bean requires an enum, you'll usually configure it in a a different way.
     * Ex: The 2 DriversLicense beans.
     * */
    public DeliveryVanType getVanType() {
        return DeliveryVanType.BIG;
    }
}
