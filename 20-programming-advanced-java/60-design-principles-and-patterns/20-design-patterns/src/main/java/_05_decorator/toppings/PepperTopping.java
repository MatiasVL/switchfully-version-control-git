package _05_decorator.toppings;

import _05_decorator.Pizza;

public class PepperTopping extends ToppingDecorator {

    public PepperTopping(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return this.getPizza().getDescription() + ", with extra Peppers";
    }

    @Override
    public double cost() {
        return this.getPizza().cost() + 0.50;
    }
}
