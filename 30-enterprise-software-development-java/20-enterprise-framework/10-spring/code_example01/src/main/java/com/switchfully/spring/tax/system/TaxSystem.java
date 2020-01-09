package com.switchfully.spring.tax.system;

import com.switchfully.spring.person.Person;
import com.switchfully.spring.tax.Taxation;

public interface TaxSystem {
    Taxation calculateTaxFor(Person person, int income);
}
