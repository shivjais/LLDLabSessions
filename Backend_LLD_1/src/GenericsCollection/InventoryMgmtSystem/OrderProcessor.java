package GenericsCollection.InventoryMgmtSystem;

import java.util.PriorityQueue;
import java.util.Queue;

//This class processes the orders in the order of their order type
public class OrderProcessor {
    private Queue<Order> orders;

    public OrderProcessor() {
        orders = new PriorityQueue<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void processOrders() {
        while(!orders.isEmpty()) {
            Order order = orders.poll();
            System.out.println("Processing order: "+order.getOrderId());
        }
    }

}
