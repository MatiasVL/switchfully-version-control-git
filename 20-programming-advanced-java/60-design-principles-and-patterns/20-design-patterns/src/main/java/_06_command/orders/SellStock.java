package _06_command.orders;

import _06_command.Stock;

public class SellStock implements Order {

    private Stock stock;
    private int quantityToSell;

    public SellStock(Stock stock, int quantityToSell) {
        this.stock = stock;
        this.quantityToSell = quantityToSell;
    }

    @Override
    public void executeCommand() {
        stock.sell(quantityToSell);
    }
}
