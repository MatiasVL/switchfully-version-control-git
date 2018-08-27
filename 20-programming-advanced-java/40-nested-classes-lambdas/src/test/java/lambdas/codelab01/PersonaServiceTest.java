package lambdas.codelab01;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PersonaServiceTest {

    @Test
    void sortOnNameAsc() {
        PersonaService personaService = new PersonaService();

        List<Persona> personas = Arrays.asList(
                new Persona("Frederik", 23),
                new Persona("Albert", 80),
                new Persona("Bram", 45));

        List<Persona> sortedPersonas = personaService.sortOnNameAsc(personas);

        assertThat(sortedPersonas).containsExactly(
                new Persona("Albert", 80),
                new Persona("Bram", 45),
                new Persona("Frederik", 23)
        );

    }

    @Test
    void sortOnNameDesc() {
        PersonaService personaService = new PersonaService();

        List<Persona> personas = Arrays.asList(
                new Persona("Frederik", 23),
                new Persona("Albert", 80),
                new Persona("Bram", 45));

        List<Persona> sortedPersonas = personaService.sortOnNameDesc(personas);

        assertThat(sortedPersonas).containsExactly(
                new Persona("Frederik", 23),
                new Persona("Bram", 45),
                new Persona("Albert", 80)
        );

    }

    @Test
    void sortOnNameAscLambda() {
        PersonaService personaService = new PersonaService();

        List<Persona> personas = Arrays.asList(
                new Persona("Frederik", 23),
                new Persona("Albert", 80),
                new Persona("Bram", 45));

        List<Persona> sortedPersonas = personaService.sortOnNameAscLambda(personas);

        assertThat(sortedPersonas).containsExactly(
                new Persona("Albert", 80),
                new Persona("Bram", 45),
                new Persona("Frederik", 23)
        );

    }

    @Test
    void sortOnNameDescLambda() {
        PersonaService personaService = new PersonaService();

        List<Persona> personas = Arrays.asList(
                new Persona("Frederik", 23),
                new Persona("Albert", 80),
                new Persona("Bram", 45));

        List<Persona> sortedPersonas = personaService.sortOnNameDescLambda(personas);

        assertThat(sortedPersonas).containsExactly(
                new Persona("Frederik", 23),
                new Persona("Bram", 45),
                new Persona("Albert", 80)
        );

    }

    @Test
    void sortOnAgeAscLambda() {
        PersonaService personaService = new PersonaService();

        List<Persona> personas = Arrays.asList(
                new Persona("Frederik", 23),
                new Persona("Gert", 88),
                new Persona("Bram", 45));

        List<Persona> sortedPersonas = personaService.sortOnAgeAscLambda(personas);

        assertThat(sortedPersonas).containsExactly(
                new Persona("Frederik", 23),
                new Persona("Bram", 45),
                new Persona("Gert", 88)
        );

    }

    @Test
    void sortOnAgeDescLambda() {
        PersonaService personaService = new PersonaService();

        List<Persona> personas = Arrays.asList(
                new Persona("Frederik", 23),
                new Persona("Gert", 88),
                new Persona("Bram", 45));

        List<Persona> sortedPersonas = personaService.sortOnAgeDescLambda(personas);

        assertThat(sortedPersonas).containsExactly(
                new Persona("Gert", 88),
                new Persona("Bram", 45),
                new Persona("Frederik", 23)
        );

    }

}