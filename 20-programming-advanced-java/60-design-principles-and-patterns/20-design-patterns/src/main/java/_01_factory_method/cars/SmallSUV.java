package _01_factory_method.cars;

public class SmallSUV extends RentalCar {

    @Override
    public void inspect() {
        System.out.println("Inspecting the small SUV, nothing wrong here");
    }

    @Override
    public void refuel() {
        System.out.println("Refueling the small SUV");
    }

    @Override
    public void driveToFront() {
        System.out.println("Quickly driving the small SUV to the front");
    }

    @Override
    public String toString() {
        return "a Small SUV";
    }
}
