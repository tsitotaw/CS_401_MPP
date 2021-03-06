package exercise8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

public class Main {
	List<OrderItem> orderItems = new ArrayList<>();

	public static void main(String[] args) {
		Main m = new Main();
		m.loadOrderItemData();
		System.out.println("Do any of these Order Items have an order of flowers? " + m.findProduct("Tools"));
		System.out.println("Do any of these Order Items have an order of flowers? " + m.findProduct(null));
	}
	
	private boolean findProduct(String prodName) {
		
		Optional<String> isProductFound = orderItems.stream()
		.map(item -> item.getProduct())
		.map(prod -> prod.getProductName())
		.filter(name -> name.equals(prodName))
		.findAny();
		
		return (isProductFound.isPresent());
	}
//	IntUnaryOperator squareNum = n -> n*n + 1;
//	IntStream intStream = IntStream.iterate(1,squareNum).limit(num); 
//	
//	intStream.forEach(i -> System.out.print(i+" "));
	private void loadOrderItemData() {
		orderItems.add(new OrderItem(new Product("1016", "Tools", 131.00), 3));
		orderItems.add(new OrderItem(new Product("1017", "Fishing Rod", 111.00), 1));
		orderItems.add(new OrderItem(new Product("1018", "Game of Go", 66.00), 2));
		orderItems.add(new OrderItem(new Product("1019", "Flowers", 221.00), 5));
	}
}
