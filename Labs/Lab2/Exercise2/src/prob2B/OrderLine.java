package prob2B;

import java.math.BigDecimal;
import java.math.MathContext;

public class OrderLine {
    private int lineId;
    private String productName;
    private int quantity;
    private BigDecimal price;
    private Order order;

    OrderLine(String productName, int quantity, BigDecimal price, Order order) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.order = order;
    }

    public int getLineId() {
        return lineId;
    }

    public void setLineId(int lineId) {
        this.lineId = lineId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "\nOrderLine{" +
                "lineId=" + lineId +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price.round(MathContext.DECIMAL32) +
                '}';
    }
}
