package prob2B;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * a 1 to many relationship between Order and OrderLine
 */
public class Order {
    private int orderNum;
    private String orderNotes;
    private List<OrderLine> orderLineList;

    public Order(int orderNum, String orderNotes) {
        this.orderNum = orderNum;
        this.orderNotes = orderNotes;
        this.orderLineList = new ArrayList<>();
    }

    public void addOrderLine(String productName, int quantity, BigDecimal price){
        this.orderLineList.add(new OrderLine(productName,quantity,price,this));
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public String getOrderNotes() {
        return orderNotes;
    }

    public void setOrderNotes(String orderNotes) {
        this.orderNotes = orderNotes;
    }

    public List<OrderLine> getOrderLineList() {
        return orderLineList;
    }

    public void setOrderLineList(List<OrderLine> orderLineList) {
        this.orderLineList = orderLineList;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNum=" + orderNum +
                ", orderNotes='" + orderNotes + '\'' + "\n" +
                ", orderLineList=" +  orderLineList +
                '}';
    }
}
