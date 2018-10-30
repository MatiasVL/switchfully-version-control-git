package _06_command;

import _06_command.orders.Order;

import java.util.ArrayList;
import java.util.List;

public class Broker {

    private final List<Order> orders;

    public Broker() {
        orders = new ArrayList<>();
    }

    public void registerNewOrder(Order order) {
        orders.add(order);
    }

    public void processOrders() {
        orders.forEach(Order::executeCommand);
        orders.clear();
    }
}
