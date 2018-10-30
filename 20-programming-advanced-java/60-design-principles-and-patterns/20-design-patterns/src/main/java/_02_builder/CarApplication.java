package _02_builder;

import static _02_builder.Car.CarBuilder.carBuilder;

public class CarApplication {

    public static void main(String[] args) {

        Car car = carBuilder()
                .withNumberOfWheels(4)
                .withColor("red")
                .withNumberOfDoors(5)
                .withBrand("Volvo")
                .withType("V40")
                .build();

        System.out.println(car);

    }
}
