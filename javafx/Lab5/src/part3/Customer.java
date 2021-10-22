package part3;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String name;
	private List<Order> orders;
	Customer(String name) {
		this.name = name;
		orders = new ArrayList<Order>();	
	}
	public void addOrder(Order order) {
		orders.add(order);
	}
	public String getName() {
		return name;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
}
