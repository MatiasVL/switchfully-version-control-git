package _01_factory_method.cars;

public class HeavyDutyOffRoader extends RentalCar {

    @Override
    public void inspect() {
        System.out.println("Inspecting the gigantic Heavy duty Off Roader");
    }

    @Override
    public void refuel() {
        System.out.println("Refueling the gigantic Heavy duty Off Roader, which takes a while");
    }

    @Override
    public void driveToFront() {
        System.out.println("Driving the gigantic Heavy duty Off Roader to the front, plowing through the snow");
    }

    @Override
    public String toString() {
        return "a Heavy Duty Off-Roader";
    }
}
