package _05_decorator;

public class HawaiPizza extends Pizza{

    public HawaiPizza() {
        description = "A delicious pizza hawai";
    }

    @Override
    public double cost() {
        return 10.50;
    }
}
