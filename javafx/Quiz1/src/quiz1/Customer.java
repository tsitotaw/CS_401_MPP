package quiz1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Order> orders;

    public Customer(String name){
        this.name=name;
        orders = new ArrayList<>();
    }

    public Order addOrder(LocalDate dateOfOrder){
        Order ord = new Order(dateOfOrder);
        orders.add(ord);
        return ord;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

	@Override
	public String toString() {
		return "Customer [name=" + name + ", orders=" + orders + "]";
	}
    
    
}
