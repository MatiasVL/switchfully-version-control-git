package _05_decorator.toppings;

import _05_decorator.Pizza;

public abstract class ToppingDecorator implements Pizza {

    private final Pizza pizza;

    ToppingDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    public Pizza getPizza() {
        return pizza;
    }
}
