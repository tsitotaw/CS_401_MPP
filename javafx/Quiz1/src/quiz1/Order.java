package quiz1;

import java.time.LocalDate;

public class Order {
    private LocalDate orderDate;

    Order(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderDate=" + orderDate +
                '}';
    }
}
