package com.switchfully.spring.tax;

import com.switchfully.spring.person.Person;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("belgium")
public class BelgianTaxSystem implements TaxSystem {
    @Override
    public Taxation calculateTaxFor(Person person, int income) {
        return new Taxation(person.getFullName(), income, 0, 0);
    }
}
