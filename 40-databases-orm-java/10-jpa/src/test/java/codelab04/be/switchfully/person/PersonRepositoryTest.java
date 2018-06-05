package codelab04.be.switchfully.person;

import codelab04.be.switchfully.Codelab04Config;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.assertj.core.api.Assertions.assertThat;

@SpringJUnitConfig(Codelab04Config.class)
class PersonRepositoryTest {

    private PersonRepository personRepository;

    @Autowired
    PersonRepositoryTest(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Test
    void save_WillCreateThatPersonInTheDatabase() {
        Person expected = personRepository.save(new Person("firstName", "lastName"));
        Person actual = personRepository.findByName("lastName");

        assertThat(actual.getId()).isEqualTo(expected.getId());
    }
}