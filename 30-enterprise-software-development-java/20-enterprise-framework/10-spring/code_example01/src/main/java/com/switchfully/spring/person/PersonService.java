package com.switchfully.spring.person;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private PersonMapper personMapper;
    private PersonRepository personRepository;

    public PersonService(PersonMapper personMapper, PersonRepository personRepository) {
        this.personMapper = personMapper;
        this.personRepository = personRepository;
    }

    public List<PersonDto> findAll() {
        return personMapper.toDto(personRepository.findAll());
    }
}
