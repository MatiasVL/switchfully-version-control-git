package _02_builder;

class CarTestBuilder {

    private int numberOfWheels;
    private String color;
    private int numberOfDoors;
    private String brand;
    private String type;

    private CarBuilder carBuilder;

    private CarTestBuilder() {
        carBuilder = CarBuilder.carBuilder();
    }

    public static CarTestBuilder aDefaultCar() {
        return aCar()
                .withBrand("Ford")
                .withType("Mondeo")
                .withColor("Black")
                .withNumberOfDoors(5)
                .withNumberOfWheels(4);
    }

    public static CarTestBuilder anEmptyCar() {
        return aCar()
                .withBrand("")
                .withType("")
                .withColor("")
                .withNumberOfDoors(0)
                .withNumberOfWheels(0);
    }

    public static CarTestBuilder aCar() {
        return new CarTestBuilder();
    }

    public Car build() {
        return carBuilder.build();
    }

    public CarTestBuilder withNumberOfWheels(int numberOfWheels) {
        carBuilder.withNumberOfWheels(numberOfWheels);
        return this;
    }

    public CarTestBuilder withColor(String color) {
        carBuilder.withColor(color);
        return this;
    }

    public CarTestBuilder withNumberOfDoors(int numberOfDoors) {
        carBuilder.withNumberOfDoors(numberOfDoors);
        return this;
    }

    public CarTestBuilder withBrand(String brand) {
        carBuilder.withBrand(brand);
        return this;
    }

    public CarTestBuilder withType(String type) {
        carBuilder.withType(type);
        return this;
    }
}