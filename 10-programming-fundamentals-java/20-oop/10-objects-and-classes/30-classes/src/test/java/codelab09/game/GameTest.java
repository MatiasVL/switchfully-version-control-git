package codelab09.game;

import org.junit.jupiter.api.Test;

import static codelab09.game.Coordinate.coordinate;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    @Test
    void canHit() {
        boolean hit = new Game(new Ship(asList(coordinate(5,5))))
                .checkIfHit(coordinate(5, 5));

        assertThat(hit).isTrue();
    }

    @Test
    void canMiss() {
        boolean hit = new Game(new Ship(asList(coordinate(5,5))))
                .checkIfHit(coordinate(5, 4));

        assertThat(hit).isFalse();
    }
}