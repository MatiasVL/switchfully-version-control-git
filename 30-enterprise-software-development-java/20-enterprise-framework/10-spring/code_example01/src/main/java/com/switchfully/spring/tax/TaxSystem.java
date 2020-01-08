package com.switchfully.spring.tax;

import com.switchfully.spring.person.Person;

public interface TaxSystem {
    int calculateTaxFor(Person person);
}
