package _02_builder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ExampleTest {

    @Test
    void aSimpleTestUsingATestBuilder() {
        Car aCar = CarTestBuilder
                .aDefaultCar()
                .build();

        Assertions.assertThat(aCar.getBrand()).isEqualTo("Ford");
        Assertions.assertThat(aCar.getType()).isEqualTo("Mondeo");
        Assertions.assertThat(aCar.getColor()).isEqualTo("White");
        Assertions.assertThat(aCar.getNumberOfDoors()).isEqualTo(5);
        Assertions.assertThat(aCar.getNumberOfWheels()).isEqualTo(4);
    }

}
