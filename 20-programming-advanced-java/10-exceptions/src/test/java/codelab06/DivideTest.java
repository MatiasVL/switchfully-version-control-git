package codelab06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DivideTest {

    @Test
    void divide_happyPath() {
        double actualResult = Divide.divide("5.0", "2.0");
        assertThat(actualResult).isEqualTo(2.5);
    }

    @Test
    void divide_whenDenominatorIs0_0_theReturnInfinity() {
        double actualResult = Divide.divide("5.0", "0.0");
        assertThat(Double.isInfinite(actualResult)).isTrue();
    }

    @Test
    void divide_whenDenominatorIs0_theReturnInfinity() {
        double actualResult = Divide.divide("5.0", "0");
        assertThat(Double.isInfinite(actualResult)).isTrue();
    }

    @Test
    void divide_whenNumeratorIsNotANumber_throwNumberFormatException() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            Divide.divide("hello", "5.0");
        });
    }

    @Test
    void divide_whenDenominatorIsNotANumber_throwNumberFormatException() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            Divide.divide("8.2", "hello");
        });
    }

    @Test
    void divide_whenNeitherANumber_throwNumberFormatException() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            Divide.divide("hello", "world");
        });
    }

}