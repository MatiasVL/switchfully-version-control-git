package codelab08;

public class Car {

    private boolean areLightsTurnedOn;
    private boolean isEngineOn;
    private Driver driver;
    private int milage;

    public Car() {
        System.out.println("Car created!");
    }

    void enterCar(Driver driver) throws IllegalStateException {
        if (this.driver != null) {
            throw new IllegalStateException("There already is a driver in this car!");
        }
        this.driver = driver;
        System.out.println(String.format("\t%s entered the car as a driver", driver.getName()));
    }

    void leaveCar(Driver driver) throws IllegalStateException {
        if (driver != this.driver || this.driver == null) {
            throw new IllegalStateException(String.format("%s is not the driver of this car!", driver.getName()));
        }
        this.driver = null;
        System.out.println(String.format("\t%s left the car as a driver", driver.getName()));
    }

    void turnLightsOn() {
        this.areLightsTurnedOn = true;
        System.out.println("\tLights turned on");
    }

    void turnLightsOff() {
        this.areLightsTurnedOn = false;
        System.out.println("\tLights turned off");
    }

    void turnEngineOn() {
        this.isEngineOn = true;
        System.out.println("\tEngine turned on");
    }

    void turnEngineOff() {
        this.isEngineOn = false;
        System.out.println("\tEngine turned off");
    }

    void driveAmountOfMiles(int amountOfMiles) throws IllegalStateException {
        if (this.driver == null || !this.isEngineOn) {
            throw new IllegalStateException("You cannot drive a car if it has no driver or if its engine is turned off!");
        }
        this.milage += amountOfMiles;
        System.out.println(String.format("\tTotal amount of miles driven: %s", milage));
    }

    boolean areLightsTurnedOn() {
        return areLightsTurnedOn;
    }

    boolean isEngineOn() {
        return isEngineOn;
    }

    Driver getDriver() {
        return driver;
    }

    int getMilage() {
        return milage;
    }
}
