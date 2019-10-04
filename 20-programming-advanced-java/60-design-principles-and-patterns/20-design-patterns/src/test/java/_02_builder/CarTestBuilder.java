package _02_builder;

class CarTestBuilder {

    private Car.CarBuilder carBuilder;

    private CarTestBuilder() {
        carBuilder = Car.CarBuilder.carBuilder();
    }

    /**
     * This is actually an example of even another design pattern, called the static factory method.
     * (not to be confused with Factory method).
     */
    public static CarTestBuilder aDefaultCar() {
        return aCar()
                .withBrand("Ford")
                .withType("Mondeo")
                .withColor("White")
                .withNumberOfDoors(5)
                .withNumberOfWheels(4);
    }

    /**
     * This is actually an example of even another design pattern, called the static factory method.
     * (not to be confused with Factory method).
     */
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
