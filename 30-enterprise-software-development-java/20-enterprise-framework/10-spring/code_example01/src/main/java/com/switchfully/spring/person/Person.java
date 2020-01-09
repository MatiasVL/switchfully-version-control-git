package com.switchfully.spring.person;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.EnumType.STRING;

@Entity
@Table(name = "PERSON")
public class Person {
    @Id
    private int id;
    private String firstName;
    private String lastName;
    @Enumerated(STRING)
    private Job job;

    protected Person() {

    }

    public Person(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Job getJob() {
        return job;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
