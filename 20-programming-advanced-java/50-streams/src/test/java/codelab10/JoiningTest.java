package codelab10;

import org.junit.jupiter.api.Test;

import java.util.List;

import static codelab10.Joining.namesToString;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class JoiningTest {

    @Test
    public void namesToStringShouldReturnPeopleNamesSeparatedByComma() {
        Person sara = new Person("Sara", 4);
        Person viktor = new Person("Viktor", 40);
        Person eva = new Person("Eva", 42);
        List<Person> collection = asList(sara, viktor, eva);
        assertThat(namesToString(collection))
                .isEqualTo("Names: Sara, Viktor, Eva.");
    }

}