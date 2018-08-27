package _05_decorator.toppings;

import _05_decorator.Pizza;

public abstract class ToppingDecorator extends Pizza {

    private Pizza pizza;

    ToppingDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    public Pizza getPizza() {
        return pizza;
    }

    // All toppings should reimplement the getDescription method
    public abstract String getDescription();
}
