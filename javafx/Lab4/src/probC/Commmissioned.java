package probC;

import java.util.ArrayList;
import java.util.List;

public class Commmissioned extends Employee{

	private Double commision;
	private Double baseSalary;
	
	private List<Order> orders;
	
	
	public Commmissioned(Double commision, Double baseSalary) {
		this.commision = commision;
		this.baseSalary = baseSalary;
		this.orders = new ArrayList<>();
	}

	public void addOrder(Order order) {
		this.orders.add(order);
	}

	public Double getCommision() {
		return commision;
	}


	public void setCommision(Double commision) {
		this.commision = commision;
	}


	public Double getBaseSalary() {
		return baseSalary;
	}


	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}


	public List<Order> getOrders() {
		return orders;
	}


	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}


	@Override
	public Double calcGrossPay(int month, int year) {
		return null;
	}

	@Override
	public Double calcCompensation(int month, int year) {
		return this.orders.size()*commision;
	}
}
