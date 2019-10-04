package _05_decorator;


import _05_decorator.toppings.ExtraCheeseTopping;
import _05_decorator.toppings.PepperTopping;

public class PizzaApplication {

    public static void main(String[] args) {
        // Create a pizza hawaii with no extra topping
        Pizza pizzaHawaii = new HawaiiPizza();

        printOrder(pizzaHawaii);

        // Create a basic pizza
        Pizza orderedPizza = new MargheritaPizza();

        // Add some extra toppings to the basic pizza
        orderedPizza = new PepperTopping(orderedPizza);
        orderedPizza = new ExtraCheeseTopping(orderedPizza);

        printOrder(orderedPizza);
    }

    private static void printOrder(Pizza orderedPizza) {
        System.out.println("Your order:");
        System.out.println("\t" +  orderedPizza.getDescription());
        System.out.println(String.format("\tWill cost you: €%2.2f", orderedPizza.cost()));
        System.out.println("----------------");
    }

}
