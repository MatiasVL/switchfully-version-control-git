package _05_decorator;

public class HawaiiPizza implements Pizza{

    private final String description;

    public HawaiiPizza() {
        description = "A delicious pizza hawaii";
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double cost() {
        return 10.50;
    }
}
