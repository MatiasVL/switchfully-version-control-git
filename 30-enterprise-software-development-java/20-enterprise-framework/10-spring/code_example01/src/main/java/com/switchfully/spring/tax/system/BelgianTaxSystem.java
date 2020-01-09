package com.switchfully.spring.tax.system;

import com.switchfully.spring.person.Person;
import com.switchfully.spring.tax.Taxation;
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
