package codelab09.input;

import codelab09.game.Coordinate;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static codelab09.game.Coordinate.coordinate;

class UserInputScannerTest {

    @Test
    void toCoordinate() {
        Coordinate coordinate = UserInputScanner.toCoordinate("15,0");

        Assertions.assertThat(coordinate).isEqualTo(coordinate(15,0));
    }

    @Test
    void oneNumber() {
        Assertions.assertThatThrownBy(() -> UserInputScanner.toCoordinate("5"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void dot() {
        Assertions.assertThatThrownBy(() -> UserInputScanner.toCoordinate("5.1"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void noNumber() {
        Assertions.assertThatThrownBy(() -> UserInputScanner.toCoordinate("fdsjfdsoh,dhslkjqhd"))
                .isInstanceOf(RuntimeException.class);
    }
}