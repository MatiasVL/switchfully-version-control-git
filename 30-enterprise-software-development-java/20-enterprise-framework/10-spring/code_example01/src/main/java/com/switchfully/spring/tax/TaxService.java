package com.switchfully.spring.tax;

import com.switchfully.spring.person.Person;
import com.switchfully.spring.person.PersonRepository;
import com.switchfully.spring.tax.system.TaxSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxService {
    private PersonRepository personRepository;
    private TaxationRepository taxationRepository;
    private TaxSystem taxSystem;
    private TaxationMapper taxationMapper;

    @Autowired
    public TaxService(PersonRepository personRepository, TaxationRepository taxationRepository, TaxSystem taxSystem, TaxationMapper taxationMapper) {
        this.personRepository = personRepository;
        this.taxationRepository = taxationRepository;
        this.taxSystem = taxSystem;
        this.taxationMapper = taxationMapper;
    }

    public TaxationDto taxSimulation(int id, int income) {
        return taxationMapper.toDto(calculateTax(id, income));
    }

    private Taxation calculateTax(int id, int income) {
        Person person = personRepository.getOne(id);
        return taxSystem.calculateTaxFor(person, income);
    }

    public TaxationDto tax(int id, int income) {
        Taxation taxation = calculateTax(id, income);
        taxationRepository.save(taxation);
        return taxationMapper.toDto(taxation);
    }

    public List<TaxationDto> findAll() {
        return taxationMapper.toDto(taxationRepository.findAll());
    }
}
