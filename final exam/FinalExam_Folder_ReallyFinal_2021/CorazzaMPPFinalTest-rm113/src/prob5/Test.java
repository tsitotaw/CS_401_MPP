package prob5;

import java.time.LocalDate;
import java.util.*;

public class Test {
	public static void main(String[] args) {
		testIntegers();
		testStrings();
		testEmployees();
		testLocalDates();
	}
	
	public static void testIntegers() {
		List<Integer> ints = Arrays.asList(4, 8, -2);
		List<Pair<Integer, Integer>> pairList = AllPairs.allIncreasingPairs(ints);
		System.out.println(pairList);
	}
	
	public static void testStrings() {
		 List<String> strs = Arrays.asList("Bob", "Alice", "Steve");
		 //uncomment when ready
		 //List<Pair<String, String>> pairList = AllPairs.allIncreasingPairs2(strs);
		 //System.out.println(pairList);
		 
	}
	
	public static void testLocalDates() {
		
		 List<LocalDate> dates = Arrays.asList(LocalDate.of(1994, 1, 2), 
				 LocalDate.of(2003, 9, 11), LocalDate.of(2001, 4, 15));
		 //uncomment when ready
		 //List<Pair<LocalDate, LocalDate>> pairList = AllPairs.allIncreasingPairs2(dates);
		 //System.out.println(pairList);
		 
	}
	public static void testEmployees() {		
		 List<Employee> emps = Arrays.asList(new Employee("Bob", 100000), new Employee("Jim", 55000), 
				 new Employee("Adrian", 90000), new Employee("Jim", 60000));
		 //complete implementation of test when ready
		 
	}
}
