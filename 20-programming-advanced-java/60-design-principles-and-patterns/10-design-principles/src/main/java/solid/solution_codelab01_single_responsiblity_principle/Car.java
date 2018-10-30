package solid.solution_codelab01_single_responsiblity_principle;

public class Car implements Comparable<Car>{
    private final String id;
    private final String model;
    private final String brand;

    public Car(String id, String model, String brand) {
        this.id = id;
        this.model = model;
        this.brand = brand;
    }

    public String getId() {
        return this.id;
    }

    public String getModel() {
        return this.model;
    }

    public String getBrand() {
        return this.brand;
    }

    public String printCar() {
        return String.format("%s %s", getBrand(), getModel());
    }

    @Override
    public int compareTo(Car bestCar) {
        return getModel().compareTo(bestCar.getModel());
    }
}
