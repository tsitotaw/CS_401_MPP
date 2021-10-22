package exercise6;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// A - (Employee e) -> e.getName()
		
		Function<Employee, String> empA1 = (Employee e) -> e.getName();
		Function<Employee, String> empA2 = Employee::getName; // Method reference type: Class::instanceMethod
		
		// B - (Employee e,String s) -> e.setName(s)
		BiConsumer<Employee, String> empB1 = (Employee e,String s) -> e.setName(s);
		BiConsumer<Employee, String> empB2 = Employee::setName; // Method reference type: Class::instanceMethod
		
		// C - (String s1,String s2) -> s1.compareTo(s2)
		BiFunction<String, String, Integer> empC1 = (String s1,String s2) -> s1.compareTo(s2);
		BiFunction<String, String, Integer> empC2 = String::compareTo; // Method reference type: Class::instanceMethod
		
		// D - (Integer x,Integer y) -> Math.pow(x,y)
		BiFunction<Integer, Integer, Double> empD1 = (Integer x,Integer y) -> Math.pow(x,y);
		BiFunction<Integer, Integer, Double> empD2 = Math::pow; // Method reference type: Class::staticMethod
		
		// E - (Apple a) -> a.getWeight()
		Function<Employee, Double> empE1 = (Employee e) -> e.getWeight();
		Function<Employee, Double> empE2 = Employee::getWeight; // Method reference type: Class::instanceMethod
		
		// F - (String x) -> Integer.parseInt(x);
		Function<String, Integer> empF1 = (String x) -> Integer.parseInt(x);
		Function<String, Integer> empF2 = Integer::parseInt; // Method reference type: Class::instanceMethod
		
		// G EmployeeNameComparator comp = new EmployeeNameComparator();
		// (Employee e1, Employee e2) -> comp.compare(e1,e2)
		EmployeeNameComparator comp = new EmployeeNameComparator();
		BiFunction<Employee, Employee, Integer> empG1 = (Employee e1, Employee e2) -> comp.compare(e1,e2);
		BiFunction<Employee, Employee, Integer> empG2 = comp::compare;
	}

}
