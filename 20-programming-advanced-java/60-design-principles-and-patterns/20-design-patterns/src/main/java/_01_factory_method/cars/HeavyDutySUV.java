package _01_factory_method.cars;

public class HeavyDutySUV extends RentalCar {

    @Override
    public void inspect() {
        System.out.println("Inspecting the Heavy Duty SUV");
    }

    @Override
    public void refuel() {
        System.out.println("Refueling the Heavy Duty SUV");
    }

    @Override
    public void driveToFront() {
        System.out.println("Driving the Heavy Duty SUV to the front, through the snow");
    }

    @Override
    public String toString() {
        return "a Heavy Duty SUV";
    }
}
