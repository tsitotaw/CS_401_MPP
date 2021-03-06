package prob5;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;


public class MainCoditional {

	
	
	static class StrKCondition implements Predicate<String>{
		public boolean test(String s) {
			return s.contains("K");
		}
	}
	
	static class SalaryCondition implements Predicate<Employee>{
		public boolean test(Employee emp) {
			return emp.getSalary() > 60000;
		}
	}
	
	static class IntegerCondition implements Predicate<Integer>{
		public boolean test(Integer i) {
			return i > 100;
		}
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("unchecked")
		ArrayList<String> list = new ArrayList<String>() {
			{
				add("Hello");
				add("Goodbye");
				//add("Welcome");
			}
			
		};
		
		ArrayList<String> list1 = new ArrayList<String>() {
			{
				add("Kick");
				add("Hello");
				add("World");
				add("Nick");
			}
		};
		
		ArrayList<Employee> list2 = new ArrayList<Employee>() {
			{
				add(new Employee("Bob", 55000, LocalDate.of(2014,  1, 1)));
				add(new Employee("Bob2", 100000, LocalDate.of(2015,  1, 1)));
			}
		};
		
		ArrayList<Integer> list3 = new ArrayList<Integer>() {
			{
				add(Integer.valueOf(64));
				add(Integer.valueOf(124));
				add(83);
				add(345);
				
			}
		};
		
		ConditionalRemove cdr = new ConditionalRemove();
		
		//Test 
		System.out.println("i. Original - Remove: String length = 5 : " + ConditionalRemove.conditionalRemove(list));		
		System.out.println("ii. Charcater k not contained condition : " + ConditionalRemove.conditionalRemove1(list1, new StrKCondition()));
		System.out.println("iii. Remove: Employee salary < 60000 condition : " + ConditionalRemove.conditionalRemove2(list2, new SalaryCondition()));
		System.out.println("iv. Remove: Integer value > 100 condition : " + ConditionalRemove.conditionalRemove3(list3, new IntegerCondition()));
	}

}
