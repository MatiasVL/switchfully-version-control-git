package codelab06;

import org.junit.jupiter.api.Test;

import java.util.List;

import static codelab06.Kids.getKidNames;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class KidsTest {

    @Test
    public void getKidNameShouldReturnNamesOfAllKidsFromNorwayUnder18Years() {
        Person sara = new Person("Sara", 4);
        Person viktor = new Person("Viktor", 40);
        Person eva = new Person("Eva", 42);
        Person anna = new Person("Anna", 5);
        List<Person> collection = asList(sara, eva, viktor, anna);
        assertThat(getKidNames(collection))
                .contains("Sara", "Anna")
                .doesNotContain("Viktor", "Eva");
    }

}