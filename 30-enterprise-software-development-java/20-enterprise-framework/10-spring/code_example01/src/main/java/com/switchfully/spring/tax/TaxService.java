package com.switchfully.spring.tax;

import com.switchfully.spring.person.Person;
import com.switchfully.spring.person.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaxService {
    private PersonRepository personRepository;
    private TaxSystem taxSystem;
    private TaxationMapper taxationMapper;

    @Autowired
    public TaxService(PersonRepository personRepository, TaxSystem taxSystem, TaxationMapper taxationMapper) {
        this.personRepository = personRepository;
        this.taxSystem = taxSystem;
        this.taxationMapper = taxationMapper;
    }

    public TaxationDto calculateTax(int id, int income) {
        Person person = personRepository.getOne(id);
        return taxationMapper.toDto(taxSystem.calculateTaxFor(person, income));
    }
}
