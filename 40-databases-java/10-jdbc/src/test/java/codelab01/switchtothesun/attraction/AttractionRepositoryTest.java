package codelab01.switchtothesun.attraction;

import codelab01.switchtothesun.Codelab01Config;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(Codelab01Config.class)
class AttractionRepositoryTest {

    private AttractionRepository attractionRepository;

    @Autowired
    AttractionRepositoryTest(AttractionRepository attractionRepository){
        this.attractionRepository = attractionRepository;
    }

    @Test
    void getAllCountries() {
        Assertions.assertThat(true).isFalse();
    }
}
