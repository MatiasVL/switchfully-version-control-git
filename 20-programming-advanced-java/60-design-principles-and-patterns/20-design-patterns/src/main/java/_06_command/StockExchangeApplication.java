package _06_command;

import _06_command.orders.BuyStock;
import _06_command.orders.SellStock;

public class StockExchangeApplication {

    public static void main(String[] args) {

        Stock stockGoogle = new Stock("GOO");
        Stock stockMicrosoft = new Stock("MIC");
        Stock stockApple = new Stock("APP");

        Broker myBroker = new Broker();
        myBroker.registerNewOrder(new BuyStock(stockGoogle, 10));
        myBroker.registerNewOrder(new BuyStock(stockApple, 15));
        myBroker.registerNewOrder(new BuyStock(stockMicrosoft, 7));
        myBroker.registerNewOrder(new SellStock(stockApple, 2));

        // At this point, you haven't yet bought or sold any stocks (the orders are not yet processed)
        System.out.println("Before processing");
        System.out.println("\t" + stockGoogle);
        System.out.println("\t" + stockApple);
        System.out.println("\t" + stockMicrosoft);

        // Process the orders
        System.out.println("During processing");
        myBroker.processOrders();

        System.out.println("After processing");
        System.out.println("\t" + stockGoogle);
        System.out.println("\t" + stockApple);
        System.out.println("\t" + stockMicrosoft);
    }

}
