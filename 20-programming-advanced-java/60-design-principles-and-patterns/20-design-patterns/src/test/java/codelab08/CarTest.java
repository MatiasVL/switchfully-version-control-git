package codelab08;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CarTest {

    @Test
    void enterCar_givenACarWithoutDriver_thenAddDriverToCar() {
        Car car = new Car();
        Driver expectedDriver = new Driver("Jan Janssen");

        car.enterCar(expectedDriver);

        Assertions.assertThat(car.getDriver()).isEqualTo(expectedDriver);
    }

    @Test
    void enterCar_givenACarWithAlreadyADriver_thenThrowException() {
        Car car = new Car();
        Driver driver = new Driver("Kurt Kurtens");
        car.enterCar(driver);

        IllegalStateException thrownException = assertThrows(IllegalStateException.class,
                () -> car.enterCar(new Driver("Tom Tommens")));


        Assertions.assertThat(thrownException.getMessage()).isEqualTo("There already is a driver in this car!");
    }

    @Test
    void leaveCar_givenACarWithoutADriver_thenThrownException() {
        Car car = new Car();

        IllegalStateException thrownException = assertThrows(IllegalStateException.class,
                () -> car.leaveCar(new Driver("Tom Tommens")));


        Assertions.assertThat(thrownException.getMessage()).isEqualTo("Tom Tommens is not the driver of this car!");
    }

    @Test
    void leaveCar_givenACarWitTheSameDriver_thenDriverIsRemovedFromCar() {
        Car car = new Car();
        Driver driver = new Driver("Jan Janssen");
        car.enterCar(driver);

        car.leaveCar(driver);

        Assertions.assertThat(car.getDriver()).isNull();
    }

    @Test
    void leaveCar_givenACarWithADifferentDriver_thenThrownException() {
        Car car = new Car();
        car.enterCar(new Driver("Tim Timmens"));

        IllegalStateException thrownException = assertThrows(IllegalStateException.class,
                () -> car.leaveCar(new Driver("Tom Tommens")));


        Assertions.assertThat(thrownException.getMessage()).isEqualTo("Tom Tommens is not the driver of this car!");
    }

    @Test
    void turnLightsOn_givenCarWithLightsTurnedOff_thenLightsAreTurnedOn() {
        Car car = new Car();
        car.turnLightsOff();

        car.turnLightsOn();

        Assertions.assertThat(car.areLightsTurnedOn()).isTrue();
    }

    @Test
    void turnLightsOff_givenCarWithLightsTurnedOn_thenLightsAreTurnedOff() {
        Car car = new Car();
        car.turnLightsOn();

        car.turnLightsOff();

        Assertions.assertThat(car.areLightsTurnedOn()).isFalse();
    }

    @Test
    void turnEngineOn_givenCarWithEngineTurnedOff_thenEngineIsTurnedOn() {
        Car car = new Car();
        car.turnEngineOff();

        car.turnEngineOn();

        Assertions.assertThat(car.isEngineOn()).isTrue();
    }

    @Test
    void turnEngineOff_givenCarWithEngineTurnedOn_thenEngineIsTurnedOff() {
        Car car = new Car();
        car.turnEngineOn();

        car.turnEngineOff();

        Assertions.assertThat(car.isEngineOn()).isFalse();
    }

    @Test
    void driveAmountOfMiles_givenCarWithTurnedOnEngineAndDriver_driveTheProvidedAmountOfMiles() {
        Car car = new Car();
        car.turnEngineOn();
        car.enterCar(new Driver("Koen Koensen"));

        car.driveAmountOfMiles(100);

        Assertions.assertThat(car.getMilage()).isEqualTo(100);
    }

    @Test
    void driveAmountOfMiles_givenCarWithTurnedOnEngineButNoDriver_throwException() {
        Car car = new Car();
        car.turnEngineOn();


        IllegalStateException thrownException = assertThrows(IllegalStateException.class,
                () -> car.driveAmountOfMiles(50));


        Assertions.assertThat(thrownException.getMessage()).isEqualTo("You cannot drive a car if it has no driver or if its engine is turned off!");
    }

    @Test
    void driveAmountOfMiles_givenCarWithADriverButTheEngineTurnedOff_throwException() {
        Car car = new Car();
        car.turnEngineOff();
        car.enterCar(new Driver("Sam Sammens"));


        IllegalStateException thrownException = assertThrows(IllegalStateException.class,
                () -> car.driveAmountOfMiles(125));


        Assertions.assertThat(thrownException.getMessage()).isEqualTo("You cannot drive a car if it has no driver or if its engine is turned off!");
    }

}