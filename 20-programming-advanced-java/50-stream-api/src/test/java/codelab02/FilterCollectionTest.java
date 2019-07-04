package codelab02;

import org.junit.jupiter.api.Test;

import java.util.List;

import static codelab02.FilterCollection.transform;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class FilterCollectionTest {

    @Test
    public void transformShouldFilterCollectionSoThatItOnlyContainsElementsWithLessThan4Characters() {
        List<String> collection = asList("My", "name", "is", "John", "Doe");
        List<String> expected = asList("My", "is", "Doe");
        assertThat(transform(collection)).hasSameElementsAs(expected);
    }

}