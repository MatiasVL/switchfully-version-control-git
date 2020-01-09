package com.switchfully.spring.tax;

import com.switchfully.spring.person.Person;

public interface TaxSystem {
    Taxation calculateTaxFor(Person person, int income);
}
