package _06_command.orders;

import _06_command.Stock;

public class BuyStock implements Order {

    private final Stock stock;
    private final int quantityToBuy;

    public BuyStock(Stock stock, int quantityToBuy) {
        this.stock = stock;
        this.quantityToBuy = quantityToBuy;
    }

    @Override
    public void executeCommand() {
        stock.buy(quantityToBuy);
    }
}
