package code_example01.vehicles.engines;

public abstract class Engine {

    private int amountOfHorsePower;
    private boolean hasHighConsumption;

    public Engine(int amountOfHorsePower, boolean hasHighConsumption) {
        this.amountOfHorsePower = amountOfHorsePower;
        this.hasHighConsumption = hasHighConsumption;
    }

    public abstract String start();

    public abstract String stop();

    public int getAmountOfHorsePower() {
        return amountOfHorsePower;
    }

    public boolean hasHighConsumpotion() {
        return hasHighConsumption;
    }
}
