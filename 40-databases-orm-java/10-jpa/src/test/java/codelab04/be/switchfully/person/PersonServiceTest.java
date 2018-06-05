package codelab04.be.switchfully.person;

import codelab04.be.switchfully.Codelab04Config;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(Codelab04Config.class)
class PersonServiceTest {

    private PersonService personService;

    @Autowired
    PersonServiceTest(PersonService personService){
        this.personService = personService;
    }

    @Test
    void test() {
        Assertions.assertThat(true).isTrue();
    }
}