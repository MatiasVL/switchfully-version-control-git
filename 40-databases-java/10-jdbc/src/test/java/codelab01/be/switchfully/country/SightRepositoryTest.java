package codelab01.be.switchfully.country;

import codelab01.switchtothesun.Codelab01Config;
import codelab01.switchtothesun.sight.SightRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(Codelab01Config.class)
class SightRepositoryTest {

    private SightRepository sightRepository;

    @Autowired
    SightRepositoryTest(SightRepository sightRepository){
        this.sightRepository = sightRepository;
    }

    @Test
    void getAllCountries() {
        Assertions.assertThat(true).isTrue();
    }
}