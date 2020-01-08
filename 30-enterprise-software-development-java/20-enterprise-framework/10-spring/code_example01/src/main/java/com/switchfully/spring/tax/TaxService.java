package com.switchfully.spring.tax;

import com.switchfully.spring.person.Person;
import com.switchfully.spring.person.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class TaxService {
    private PersonRepository personRepository;
    private TaxSystem taxSystem;

    public TaxService(PersonRepository personRepository, TaxSystem taxSystem) {
        this.personRepository = personRepository;
        this.taxSystem = taxSystem;
    }

    public int calculateTax(int id) {
        Person person = personRepository.getOne(id);
        return taxSystem.calculateTaxFor(person);
    }
}
