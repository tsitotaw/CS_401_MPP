package exercise11b;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class LambdaLibrary {
	
	 public static final Function<List<Employee>, String> EMPLOYEES_MORE_THAN_100K_AND_AFTER_M 
	  		= (list) -> list.stream()
						.filter(e -> e.getSalary() > 100000 && e.getLastName().matches("^[n-zN-Z].*$"))
						.map(e -> e.getFirstName() + " " + e.getLastName())
						.sorted()
	  					.collect(Collectors.joining(", "));
}
