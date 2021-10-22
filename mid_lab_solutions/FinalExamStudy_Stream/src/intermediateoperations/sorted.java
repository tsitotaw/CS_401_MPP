package intermediateoperations;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class sorted {
	public static void main(String[] args) {
		
//		System.out.println(sortedByNaturalOrder());
		System.out.println(sortedByWordLength());
//		System.out.println(sortedByWordLengthLambda());
//		System.out.println(sortedByWordLengthMethodReference());
//		System.out.println(sortedByWordLengthLambda2());
//		System.out.println(sortedEmployeeByNameLength());
//		System.out.println(sortedEmployeeNaturalOrder());
//		System.out.println(sortedEmployeeByClassReference());
//		System.out.println(sortedEmployeeThen());
		
	}
	
	static List<String> sortedByNaturalOrder(){
		List<String> words = Arrays.asList("Tom", "Tamirat", "Abebe", "Molla");
		
		return words.stream()
				.sorted() // natural ordering
				.collect(Collectors.toList());
	}
	
	static List<String> sortedByWordLength(){
		List<String> words = Arrays.asList("Tom", "Tamirat", "Abebe", "Molla");
		class WordComparator implements Comparator<String>{

			@Override
			public int compare(String o1, String o2) {
				if(o1.compareTo(o2) < 0) return -1;
				if(o1.compareTo(o1) > 0) return 1;
				return 0;
			}
			
		}
		return words.stream()
//				.sorted(Comparator.comparing(String::length)) // natural ordering
//				.sorted(new Comparator<String>() {
//
//					@Override
//					public int compare(String o1, String o2) {
//						if(o1.compareTo(o2) < 0) return -1;
//						if(o1.compareTo(o2) > 0) return 1;
//						return 0;
//					}
//					
//				})
//				.sorted((o1,o2) -> {
//					if(o1.compareTo(o2) > 0) return 1;
//					if(o1.compareTo(o2) < 0) return -1;
//					return 0;
//				})
				.sorted(new WordComparator())
				.collect(Collectors.toList());
	}
	
	static List<String> sortedByWordLengthLambda(){
		List<String> words = Arrays.asList("Tom", "Tamirat", "Abebe", "Molla");
		
		return words.stream()
				.sorted((w1,w2) -> (w1.length() > w2.length()) ? 1 : -1) 
				.collect(Collectors.toList());
	}
	
	static List<String> sortedByWordLengthMethodReference(){
		List<String> words = Arrays.asList("Tom", "Tamirat", "Abebe", "Molla");
		
		return words.stream()
				.sorted(Comparator.comparing(String::length))
				.collect(Collectors.toList());
	}
	
	static List<String> sortedByWordLengthLambda2(){
		List<String> words = Arrays.asList("Tom", "Tamirat", "Abebe", "Molla");
		Function<String, Integer> sortByLength = x -> x.length();
		
		return words.stream()
				.sorted(Comparator.comparing(sortByLength))
				.collect(Collectors.toList());
	}
	
	static List<String> sortedByWordLengthComparator(){
		List<String> words = Arrays.asList("Tom", "Tamirat", "Abebe", "Molla");
		Function<String, Integer> sortByLength = x -> x.length();
		Comparator<String> byLength = Comparator.comparing(String::length);
		return words.stream()
				.sorted(byLength)
				.collect(Collectors.toList());
	}
	
	static List<Employee> sortedEmployeeNaturalOrder(){
		List<Employee> emps = Arrays.asList(new Employee("Tom"), new Employee("Tamirat"), new Employee("Abebe"), new Employee("Molla"));
		Function<Employee, String> sortByName = e1 -> e1.getName();
		return emps.stream()
				.sorted(Comparator.comparing(sortByName))
				.collect(Collectors.toList());
	}
	
	static List<Employee2> sortedEmployeeByClassReference(){
		List<Employee2> emps = Arrays.asList(new Employee2("Tom", 1000), new Employee2("Tamirat", 2000), new Employee2("Abebe",5464), new Employee2("Molla", 100));
		Function<Employee2, String> sortByName = e1 -> e1.getName();
		return emps.stream()
				.sorted(Comparator.comparing(Employee2::getName))
				.collect(Collectors.toList());
	}
	
	static List<Employee2> sortedEmployeeThen(){
		List<Employee2> emps = Arrays.asList(new Employee2("Tom", 1000), new Employee2("Tamirat", 2000), new Employee2("Abebe",5464), new Employee2("Molla", 1800));
		Function<Employee2, String> sortByName = e1 -> e1.getName();
		return emps.stream()
				.sorted(Comparator.comparing(Employee2::getSalary).thenComparing(Employee2::getName))
				.collect(Collectors.toList());
	}
	
	static List<Employee> sortedEmployeeByNameLength(){
		List<Employee> emps = Arrays.asList(new Employee("Tom"), new Employee("Tamirat"), new Employee("Abebe"), new Employee("Molla"));
		
		Function<Employee, Integer> sortByNameLength = x -> x.getName().length();
		
		return emps.stream()
				.sorted(Comparator.comparing(sortByNameLength))
				.collect(Collectors.toList());
	}
	
}

class Employee2 {
	private String name;
	private int salary;
	
	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Employee2() {
		this.name = "Holla";
	}

	public Employee2(String name, int salary) {
		this.name = name;
		this.salary = salary;
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
