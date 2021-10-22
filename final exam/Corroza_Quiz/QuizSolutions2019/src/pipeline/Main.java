package pipeline;

import static java.util.Comparator.comparing;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import quizclasses.*;


public class Main {
	public static void main(String[] args) {
		
		//System.out.println("Sample Query");
		List<Employee> sampleData = EmployeeTestData.getList();
		//SAMPLE: Create a stream pipeline that does the following:
		//Print all Employee records for which name has length > 5 and birth year is > 1970
		List<Employee> result = sampleData.stream()
							        .filter(e -> e.getName().length() > 5)
							        .filter(e -> e.getYearOfBirth() > 1970)
							        .collect(Collectors.toList());
		//System.out.println(result);
				
		//prob1();
		//prob2();
		prob3();
	}
	
	//Create a stream pipeline that obtains a list of
	//all name/salary pairs extracted from a list of Employees
	//for which salary > 55000 and less than 120000, in ascending
	//order of name, then descending order of salary
	//Then print the list to the console. Represent pairs using
	//the Pair class that is provided in the quizclasses package
	public static void prob1() {
		//use this list 
		List<Employee> list = EmployeeTestData.getList();
		System.out.println(list.stream()
			.filter(e -> e.getSalary() > 55000 && e.getSalary() < 120000)
	        .map(e -> new Pair(e.getName(), e.getSalary()))
	        .sorted(Comparator.comparing((Pair p) -> p.name).reversed()
	        .thenComparing((Pair p) -> p.salary).reversed())
	        .collect(Collectors.toList()));	
	}
	
	
	//Create a stream pipeline to find all transactions from year 2011 
	//and sort them by value (small to high), and print to console
	//(Note: there is an instance variable "value" in Transaction)
	public static void prob2() {
		//use this list	
		List<Transaction> list = TraderTransactTestData.getTransactions();
		list.stream()
	        .filter(transaction -> transaction.getYear()==2011)
	        .sorted(comparing(transaction -> transaction.getValue()))
	        .collect(Collectors.toList());
		System.out.println(list);
	}
	
	
	// Create a stream pipeline to find all pairs of traders who are associates 
	// and come from the same
	// city. Use the class TraderPair to represent pairs of traders.
	// Sort these TraderPairs first by name of first trader, then by name of second trader.
	// Finally, print these pairs to the console. Make sure the final list contains
	// no duplicates (Example:  the pair (Tom, Joe) is a duplicate of (Joe, Tom).)
	// HINT: Use the method in the Util class in quizclasses package.
	public static void prob3() {
		//Use this list
		List<Transaction> list = TraderTransactTestData.getTransactions();
		System.out.println(
				Util.allTraderPairs(list.stream().map(trans -> trans.getTrader()))
				.filter(p -> p.getTrader1().getCity().equals(p.getTrader2().getCity()))
				.filter(p -> p.getTrader1().isAssociate(p.getTrader2()))
				.distinct()
				.sorted(Comparator.comparing((TraderPair p)->p.getTrader1().getName())
						.thenComparing(p->p.getTrader2().getName()))
				.collect(Collectors.toList()));
		
		//test for allTraderPairs method
//		System.out.println(
//				Util.allTraderPairs(list.stream().map(trans -> trans.getTrader())).collect(Collectors.toList()));
		
		
	}
}
