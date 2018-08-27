package _02_builder;

public class Car {

    private int numberOfWheels;
    private String color;
    private int numberOfDoors;
    private String brand;
    private String type;

    public Car(CarBuilder carBuilder) {
        numberOfWheels = carBuilder.numberOfWheels;
        color = carBuilder.color;
        numberOfDoors = carBuilder.numberOfDoors;
        brand = carBuilder.brand;
        type = carBuilder.type;
    }

    @Override
    public String toString() {
        return "Car{" +
                "numberOfWheels=" + numberOfWheels +
                ", color='" + color + '\'' +
                ", numberOfDoors=" + numberOfDoors +
                ", brand='" + brand + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    public String getColor() {
        return color;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }
}
