package part3;

import java.time.LocalDate;

public final class CustOrderFactory {
	public static Customer createCustomer(String name) {
		
		if(name == null) 
			throw new IllegalArgumentException("Customer name cannot be null");
		
		Customer cust = new Customer(name);	
		
		Order order = new Order(LocalDate.now());
		
		cust.addOrder(order);
		
		return cust;
	}
	
	public static Order createOrder(LocalDate date, Customer cust) {
		
		if(date == null) 
			throw new IllegalArgumentException("Local date cannot be null");
		
		Order order = new Order(date);
		cust.addOrder(order);
		
		return order;
	}

}
