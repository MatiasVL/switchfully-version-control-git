package codelab05;

import org.junit.jupiter.api.Test;

import java.util.List;

import static codelab05.Sum.calculate;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class SumTest {

    @Test
    void calculateShouldReturnTheSumOfAllTheProvidedElements() {
        List<Integer> numbers = asList(1, 2, 3, 4, 5);
        assertThat(calculate(numbers)).isEqualTo(1 + 2 + 3 + 4 + 5);
    }

}