package _02_builder;

public class CarBuilder {

    int numberOfWheels;
    String color;
    int numberOfDoors;
    String brand;
    String type;

    private CarBuilder() {}

    /**
     * Static factory method
     */
    public static CarBuilder carBuilder() {
        return new CarBuilder();
    }

    public Car build() {
        return new Car(this);
    }

    public CarBuilder withNumberOfWheels(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
        return this;
    }

    public CarBuilder withColor(String color) {
        this.color = color;
        return this;
    }

    public CarBuilder withNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
        return this;
    }

    public CarBuilder withBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public CarBuilder withType(String type) {
        this.type = type;
        return this;
    }
}
