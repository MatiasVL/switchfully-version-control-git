package codelab01.be.switchfully.country;

import codelab01.be.switchfully.Codelab01Config;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(Codelab01Config.class)
class CountryRepositoryTest {

    private CountryRepository countryRepository;

    @Autowired
    CountryRepositoryTest(CountryRepository countryRepository){
        this.countryRepository = countryRepository;
    }

    @Test
    void getAllCountries() {
        Assertions.assertThat(true).isTrue();
    }
}