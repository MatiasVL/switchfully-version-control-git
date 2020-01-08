package com.switchfully.spring.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/persons")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(produces = "application/json")
    public List<PersonDto> findAll() {
        return personService.findAll();
    }

    @GetMapping(produces = "application/json", path = "{id}")
    public PersonDto findById(@PathVariable("id") int id) {
        return personService.findById(id);
    }

    @PostMapping(consumes = "application/json")
    public void save(@RequestBody  PersonDto personDto) {
        personService.save(personDto);
    }
}
