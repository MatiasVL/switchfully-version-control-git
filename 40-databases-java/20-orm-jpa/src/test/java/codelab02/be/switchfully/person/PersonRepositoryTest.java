package codelab02.be.switchfully.person;

import codelab02.be.switchfully.Codelab02Config;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(Codelab02Config.class)
class PersonRepositoryTest {

    private PersonRepository personRepository;

    @Autowired
    PersonRepositoryTest(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Test
    void test() {
        Assertions.assertThat(true).isTrue();
    }
}