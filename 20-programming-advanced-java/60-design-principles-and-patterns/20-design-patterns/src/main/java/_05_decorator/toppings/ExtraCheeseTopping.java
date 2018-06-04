package _05_decorator.toppings;

import _05_decorator.Pizza;

public class ExtraCheeseTopping extends ToppingDecorator {

    public ExtraCheeseTopping(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return this.getPizza().getDescription() + ", with extra cheese";
    }

    @Override
    public double cost() {
        return this.getPizza().cost() + 0.35;
    }
}
