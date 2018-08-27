package _01_factory_method.cars;

public class SimpleMondeo extends RentalCar {

    @Override
    public void inspect() {
        System.out.println("Inspecting the Mondeo, everything seems OK");
    }

    @Override
    public void refuel() {
        System.out.println("Refueling the Mondeo, which doesn't take long");
    }

    @Override
    public void driveToFront() {
        System.out.println("Driving the Mondeo to the front, easy peasy");
    }

    @Override
    public String toString() {
        return "a Simple Mondeo";
    }
}
