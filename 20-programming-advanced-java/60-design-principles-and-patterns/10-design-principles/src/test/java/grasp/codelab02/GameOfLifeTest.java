package grasp.codelab02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("A Game Of Life implementation")
class GameOfLifeTest {

    @Nested
    @DisplayName("When calling the life method on a Blinker pattern")
    class LifeBlinker {

        @Test
        @DisplayName("Then a correct generation 1 is generated When given a generation 0")
        void life_givenABlinkerPatternOfGeneration0_thenReturnBlinkerOfGeneration1() {
            String[] blinkerGeneration0 =
                    new String[]{
                            "-X-",
                            "-X-",
                            "-X-"
                    };
            String[] expectedBlinkerGeneration1 =
                    new String[]{
                            "---",
                            "XXX",
                            "---"
                    };

            String[] actualBlinkerGeneration1 = GameOfLife.life(blinkerGeneration0);

            assertThat(actualBlinkerGeneration1).contains(expectedBlinkerGeneration1);
        }

        @Test
        @DisplayName("Then a correct generation 2 is generated When given a generation 1")
        void life_givenABlinkerPatternOfGeneration1_thenReturnBlinkerOfGeneration2() {
            String[] blinkerGeneration1 =
                    new String[]{
                            "---",
                            "XXX",
                            "---"
                    };
            String[] expectedBlinkerGeneration2 =
                    new String[]{
                            "-X-",
                            "-X-",
                            "-X-"
                    };

            String[] actualBlinkerGeneration2 = GameOfLife.life(blinkerGeneration1);

            assertThat(actualBlinkerGeneration2).contains(expectedBlinkerGeneration2);
        }
    }

    @Nested
    @DisplayName("When calling the life method on a Toad pattern")
    class LifeToad {

        @Test
        @DisplayName("Then a correct generation 1 is generated When given a generation 0")
        void life_givenAToadPatternOfGeneration0_thenReturnToadOfGeneration1() {
            String[] toadGeneration0 =
                    new String[]{
                            "------",
                            "---X--",
                            "-X--X-",
                            "-X--X-",
                            "--X---",
                            "------",
                    };
            String[] expectedToadGeneration1 =
                    new String[]{
                            "------",
                            "------",
                            "--XXX-",
                            "-XXX--",
                            "------",
                            "------",
                    };

            String[] actualToadGeneration1 = GameOfLife.life(toadGeneration0);

            assertThat(actualToadGeneration1).contains(expectedToadGeneration1);
        }
    }
}
