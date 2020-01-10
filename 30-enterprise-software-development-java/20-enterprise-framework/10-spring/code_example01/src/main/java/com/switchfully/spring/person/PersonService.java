package com.switchfully.spring.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PersonService {

    private PersonMapper personMapper;
    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonMapper personMapper, PersonRepository personRepository) {
        this.personMapper = personMapper;
        this.personRepository = personRepository;
    }

    public List<PersonDto> findAll() {
        return personMapper.toDto(personRepository.findAll());
    }

    public PersonDto findById(int id) {
        return personMapper.toDto(personRepository.getOne(id));
    }

    public void save(PersonDto personDto) {
        personRepository.save(personMapper.toPerson(personDto));
    }

}
