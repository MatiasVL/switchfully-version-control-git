package _05_decorator;

public class MargheritaPizza extends Pizza {

    public MargheritaPizza() {
        description = "A basic margherita pizza";
    }

    @Override
    public double cost() {
        return 8.95;
    }
}
