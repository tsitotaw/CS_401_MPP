package intermediateoperations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class map {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
		
		System.out.println(
				numbers.stream()
				.map(n -> n.toString())
				.collect(Collectors.toList())
				);
		
		
		List<Employee> emps = Arrays.asList(new Employee("Tamirat"), new Employee("Fisseha"));
		
		System.out.println(
				emps.stream()
				.map(emp -> {
					emp.setName("HSHSHS");
					return emp;
				})
				.collect(Collectors.toList())
				);
		
		
		List<String> names = Arrays.asList("Baba", "Mama", "Sami");
		
		Stream<Employee> empStream = names.stream()
				.map(Employee::new);
		
		empStream.collect(Collectors.toList())
			.forEach(System.out::println);
		
		
		List<char[]> nums = new ArrayList<>();
		nums.add(new char[]{'c','d','e'});
		nums.add(new char[]{'f','g','h'});
		
		Stream<String> strStream = nums.stream()
				.map(String::new);
		
		strStream.collect(Collectors.toList())
		.forEach(System.out::println);
		
		List<Integer> ints = new ArrayList<>();//[]{1,2,3,4,5,5,6};
		ints.add(1); 
		ints.add(2);
		
		Stream<Integer> intStream = ints.stream().map(Integer::new);
		intStream.collect(Collectors.toList())
		.forEach(System.out::print);
		
		
	}
}

class Employee {
	private String name;
	
	
	public Employee() {
		this.name = "Holla";
	}

	public Employee(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "[name=" + name + "]";
	}
	
	
	
}
