package part3;

import java.time.LocalDate;

public class Main {
	public static void main(String[] args) {
		CustOrderFactory custFactory = new CustOrderFactory();
		Customer cust = custFactory.createCustomer("Bob");
		
		//Order order = custFactory.createOrder(LocalDate.now());
		Order order = custFactory.createOrder(LocalDate.now(), cust);
		order.addItem("Shirt");
		order.addItem("Laptop");

		Order order2 = custFactory.createOrder(LocalDate.now(), cust);
		order2.addItem("Pants");
		order2.addItem("Knife set");

		System.out.println(cust.getOrders());
	}
}

		
