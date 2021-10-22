package streamexercises_15;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Question1 {

	public static void main(String[] args) {
		/**
		 * Obtain a list of products belongs to category “Books” with price > 100
		 */
		List<Product> products = Arrays.asList(
				new Product(1L, "Book1", "Books", 121.0),
				new Product(2L, "Book2", "Books", 211.0),
				new Product(3L, "Book3", "ExerciseBooks", 121.0),
				new Product(4L, "Book4", "ExerciseBooks", 21.0),
				new Product(5L, "Book5", "ExerciseBooks", 21.0)
				);
		
		System.out.println(
				products.stream()
				.filter(p -> p.getCategory().equals("Books"))
				.filter(p -> p.getPrice() > 100)
				.collect(Collectors.toList())
				);
	}

}
