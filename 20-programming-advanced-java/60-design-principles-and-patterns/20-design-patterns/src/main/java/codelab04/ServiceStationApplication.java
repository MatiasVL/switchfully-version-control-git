package codelab04;

import codelab04.vehicles.Bus;
import codelab04.vehicles.Car;
import codelab04.vehicles.Truck;

public class ServiceStationApplication {

    public static void main(String[] args) {
        Truck truck = new Truck();
        Car car = new Car();
        Bus bus = new Bus();

        ServiceStation.fill(truck);

        // Somehow, something like this should work! (your job)
        // ServiceStation.fill(car);
        // ServiceStation.fill(bus);
    }

}
