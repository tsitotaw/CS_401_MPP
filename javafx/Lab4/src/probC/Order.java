package probC;

import java.time.LocalDate;

public class Order {

	private int orderNo;
	private LocalDate orderDate;
	private Double orderAmount;
	
	Order(int orderNo, LocalDate orderDate, Double orderAmount) {
		super();
		this.orderNo = orderNo;
		this.orderDate = orderDate;
		this.orderAmount = orderAmount;
	}
	
	
}
