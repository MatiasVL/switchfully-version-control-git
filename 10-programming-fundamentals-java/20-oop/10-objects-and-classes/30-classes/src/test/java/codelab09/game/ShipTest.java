package codelab09.game;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static codelab09.game.Coordinate.coordinate;
import static java.util.Arrays.asList;

class ShipTest {

    @Test
    void checkIfHit_WillReturnTrueIfHit() {
        Ship ship = new Ship(asList(coordinate(0, 0), coordinate(1, 1)));

        boolean isHit = ship.isHit(coordinate(0, 0));

        Assertions.assertThat(isHit).isTrue();
    }

    @Test
    void checkIfHit_WillReturnFalseIfMiss() {
        Ship ship = new Ship(asList(coordinate(0, 0), coordinate(2, 2)));

        boolean isHit = ship.isHit(coordinate(1, 1));

        Assertions.assertThat(isHit).isFalse();
    }
}