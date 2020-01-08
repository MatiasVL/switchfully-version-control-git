package com.switchfully.spring.person;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonMapper {

    public List<PersonDto> toDto(List<Person> personList) {
        return personList.stream().map(this::toDto).collect(Collectors.toList());
    }
    public PersonDto toDto(Person person) {
        return new PersonDto(person.getId(), person.getFirstName(), person.getLastName());
    }

    public Person toPerson(PersonDto personDto) {
        return new Person(personDto.getId(), personDto.getFirstName(), personDto.getLastName());
    }
}
