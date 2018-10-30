package _06_command;

public class Stock {

    private final String name;
    private int quantity;

    public Stock(String name) {
        this.name = name;
    }

    public void buy(int quantityToBuy) {
        System.out.println(String.format("\tBought quantity %s of stock %s", quantityToBuy, name));
        quantity += quantityToBuy;
    }

    public void sell(int quantityToSell) {
        if(quantityToSell > quantity) {
            System.out.println(String.format("\tUnable to sell stock %s, the specified quantity of %s " +
                    "exceeds the owned quantity of %s", name, quantityToSell, quantity));
        } else {
            System.out.println(String.format("\tSold quantity %s of stock %s", quantityToSell, name));
            quantity -= quantityToSell;
        }
    }

    @Override
    public String toString() {
        return "Stock{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
