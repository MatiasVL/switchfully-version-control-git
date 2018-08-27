package codelab01;

import org.junit.jupiter.api.Test;

import java.util.List;

import static codelab01.ToUpperCase.transform;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class ToUpperCaseTest {

    @Test
    void transformShouldConvertCollectionElementsToUpperCase() {
        List<String> collection = asList("My", "name", "is", "John", "Doe");
        List<String> expected = asList("MY", "NAME", "IS", "JOHN", "DOE");
        assertThat(transform(collection)).hasSameElementsAs(expected);
    }

}