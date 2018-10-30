package codelab08;

public class DrivingSimulation {

    public static void main(String[] args) {

        Car car =  new Car();
        car.enterCar(new Driver("Bobby McBobbens"));
        car.turnEngineOn();
        car.turnLightsOn();
        car.driveAmountOfMiles(150);

    }

}
