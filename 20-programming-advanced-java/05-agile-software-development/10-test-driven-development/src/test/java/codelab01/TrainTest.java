package codelab01;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class TrainTest {

    @Test
    void setHoursDelayed_givenANegativeHoursDelayedToSet_thenHoursDelayedShouldBeSetTo0() {
        // GIVEN
        Train train = new Train();

        // WHEN
        train.setHoursDelayed(-10);

        // THEN
        Assertions.assertThat(train.getHoursDelayed()).isEqualTo(0);
    }

    @Test
    void setHoursDelayed_happyPath() {
        // GIVEN
        Train train = new Train();

        // WHEN
        train.setHoursDelayed(5);

        // THEN
        Assertions.assertThat(train.getHoursDelayed()).isEqualTo(5);
    }

    @Test
    void customerSatisfaction_whenHoursDelayedEquals0_thenReturnNiceRollingText(){
        Train train = new Train();
        train.setHoursDelayed(0);

        String actualResult = train.customerSatisfaction();

        Assertions.assertThat(actualResult).isEqualTo("Nice ‘n’ rolling!");
    }

    @Test
    void customerSatisfaction_whenHoursDelayedEquals1_thenReturnNiceRollingText(){
        Train train = new Train();
        train.setHoursDelayed(0);

        String actualResult = train.customerSatisfaction();

        Assertions.assertThat(actualResult).isEqualTo("Nice ‘n’ rolling!");
    }

}