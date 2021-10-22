package prob2B;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Order order = new Order(1, "My First Order");

        order.addOrderLine("Bag", 1, new BigDecimal(23.50));
        order.addOrderLine("Blanket", 1, new BigDecimal(15.12));
        order.addOrderLine("Kittle", 1, new BigDecimal(13.50));

        System.out.println(order);
    }
}
