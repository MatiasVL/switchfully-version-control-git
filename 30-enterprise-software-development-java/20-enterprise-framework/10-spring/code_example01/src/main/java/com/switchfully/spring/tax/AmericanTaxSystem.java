package com.switchfully.spring.tax;

import com.switchfully.spring.person.Person;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("USA")
public class AmericanTaxSystem implements TaxSystem {
    @Override
    public int calculateTaxFor(Person person) {
        return 5;
    }
}
