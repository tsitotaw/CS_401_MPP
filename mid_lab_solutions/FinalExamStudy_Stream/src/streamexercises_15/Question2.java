package streamexercises_15;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Question2 {

	public static void main(String[] args) {
		
		List<Product> products = Arrays.asList(
				new Product(1L, "Book1", "Books", 121.0),
				new Product(2L, "Book2", "Books", 211.0),
				new Product(3L, "Book3", "ExerciseBooks", 121.0),
				new Product(4L, "Book4", "ExerciseBooks", 21.0),
				new Product(5L, "Book5", "ExerciseBooks", 21.0)
				);
		
		Customer cust = new Customer(1L, "Abera", 3);
		List<Order> orders = Arrays.asList(
				new Order(1L, "delivered", LocalDate.now(), LocalDate.now(), products, cust),
				new Order(2L, "ordered", LocalDate.now(), LocalDate.now(), products, cust),
				new Order(3L, "delivered", LocalDate.now(), LocalDate.now(), products, cust),
				new Order(4L, "ordered", LocalDate.now(), LocalDate.now(), products, cust),
				new Order(5L, "shipped", LocalDate.now(), LocalDate.now(), products, cust)
				);
		streamExcercise2(orders);
		streamExcercise3(products);
		streamExcercise4(orders);
	}
	
	/**
	 * Obtain a list of order with products belong to category “ExerciseBooks”
	 */
	public static void streamExcercise2(List<Order> orders) {
		System.out.println(
				orders.stream()
				.filter(p -> p.getProducts()
						.stream()
						.anyMatch(pq ->
						pq.getCategory().equals("ExerciseBooks")))
				.collect(Collectors.toList())
				);
	}
	
	/**
	 * Obtain a list of product with category = “Toys” and then apply 10% discount
	 * @param orders
	 */
	public static void streamExcercise3(List<Product> products) {
		System.out.println(
				products.stream()
				.filter(p -> p.getCategory().equals("Books"))
				.map(p -> {
					p.setPrice(p.getPrice() - 0.1*p.getPrice());
					return p;
				})
				.collect(Collectors.toList())
				);
	}
	
	/**
	 * Obtain a list of products ordered by customer of tier 2 between 01-Feb-2021 and 01-Apr-2021
	 * @param orders
	 */
	public static void streamExcercise4(List<Order> orders) {
		System.out.println(
				orders.stream()
				.filter(o -> o.getCustomer().getTier().equals(2))
				.filter(o -> o.getOrderDate().isAfter(LocalDate.of(2021, 2, 1)) &&  o.getOrderDate().isBefore(LocalDate.of(2021, 4, 1)))
				.flatMap(p -> p.getProducts().stream())
				.distinct()
				.collect(Collectors.toList())
				);
		
//		List<Product> result = orders
//				  .stream()
//				  .filter(o -> o.getCustomer().getTier() == 2)
//				  .filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 2, 1)) >= 0)
//				  .filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 4, 1)) <= 0)
//				  .flatMap(o -> o.getProducts().stream())
//				  .distinct()
//				  .collect(Collectors.toList());
	}

}
