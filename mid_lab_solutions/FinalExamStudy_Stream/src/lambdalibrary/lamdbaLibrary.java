package lambdalibrary;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class lamdbaLibrary {
	public static final BiFunction<List<Customer>, Integer, List<Customer>> customerQuery = (list, age) -> list.stream()
			.filter((x) -> {
				return (x.getAge() > age);
			}).sorted(Comparator.comparing(Customer::getName)).collect(Collectors.toList());

}
