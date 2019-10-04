package _02_builder;

/**
 * Car has, as a static nested class, a CarBuilder.
 */
public class Car {

    private final int numberOfWheels;
    private final String color;
    private final int numberOfDoors;
    private final String brand;
    private final String type;

    private Car(CarBuilder carBuilder) {
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

    /**
     * The CarBuilder class: used for building Car objects.
     */
    public static class CarBuilder {

        private int numberOfWheels;
        private String color;
        private int numberOfDoors;
        private String brand;
        private String type;

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
}
