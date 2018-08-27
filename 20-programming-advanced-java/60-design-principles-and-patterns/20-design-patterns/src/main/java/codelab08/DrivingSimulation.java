package codelab08;

public class DrivingSimulation {

    public static void main(String[] args) {

        Car car =  new Car();
        car.enterCar(new Driver("Bob Bobbens"));
        car.turnEngineOn();
        car.turnLightsOn();
        car.driveAmountOfMiles(150);

    }

}
