package pipeline;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import quizclasses.Employee;
import quizclasses.EmployeeTestData;
import quizclasses.Pair;
import quizclasses.Trader;
import quizclasses.TraderPair;
import quizclasses.TraderTransactTestData;
import quizclasses.Transaction;
import quizclasses.Util;

/** USE STREAM PIPELINES TO SOLVE THE PROBLEMS HERE */
public class Main {
	@SuppressWarnings("serial")
	public static void main(String[] args) {
		System.out.println("Sample Query");
		List<Employee> sampleData = EmployeeTestData.getList();
		// SAMPLE: Create a stream pipeline that does the following:
		// Print all Employee records for which name has length > 5 and birth year is >
		// 1970
//		List<Employee> result = sampleData.stream()
//							        .filter(e -> e.getName().length() > 5)
//							        .filter(e -> e.getYearOfBirth() > 1970)
//							        .collect(Collectors.toList());
//		System.out.println(result);
//				
		prob1();
		prob2();
		prob3();
	}

	// Create a stream pipeline that obtains a list of
	// all name/salary pairs extracted from a list of Employees
	// for which salary > 55000 and less than 120000, in ascending
	// order of name, then descending order of salary
	// Then print the list to the console. Represent pairs using
	// the Pair class that is provided in the quizclasses package
	public static void prob1() {
		// use this list
		List<Employee> list = EmployeeTestData.getList();
		System.out.println(list.stream().filter(x -> x.getSalary() > 55000 && x.getSalary() < 120000)
				.sorted(Comparator.comparing(Employee::getName)
						.thenComparing(Comparator.comparing(Employee::getSalary).reversed()))
				.map(x -> new Pair(x.getName(), x.getSalary())).collect(Collectors.toList()));

	}

	// Create a stream pipeline to find all transactions that took place
	// in the year 2011
	// and sort them by value (small to high), and print to console
	// (Note: there is an instance variable "value" in Transaction)
	public static void prob2() {
		// use this list
		List<Transaction> list = TraderTransactTestData.getTransactions();
		System.out.println(list.stream().filter(x -> x.getYear() == 2011)
				.sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList()));
	}

	// Create a stream pipeline to find all pairs of traders who are associates
	// and come from the same
	// city. Use the class TraderPair to represent pairs of traders.
	// Sort these TraderPairs first by name of first trader, then by name of second
	// trader.
	// Finally, print these pairs to the console. Make sure the final list contains
	// no duplicates (Example: the pair (Tom, Joe) is a duplicate of (Joe, Tom).)
	// HINT: To get started, use the method in the Util class in quizclasses
	// package.
	public static void prob3() {
		// Use this list
		List<Transaction> list = TraderTransactTestData.getTransactions();

		List<Trader> traders = list.stream().map(t -> (t.getTrader())).collect(Collectors.toList());

		Function<TraderPair, String> sortByTrader1Name = x -> {
			return x.getTrader1().getName();
		};

		System.out.println(
				Util.allTraderPairs(traders.stream())
						.filter(tp -> tp.getTrader1().isAssociate(tp.getTrader2()))
						.filter(tp -> tp.getTrader1().getCity().equals(tp.getTrader2().getCity()))
						.map(tp -> new TraderPair(tp.getTrader1(), tp.getTrader2()))
						.sorted(Comparator.comparing(sortByTrader1Name))
						.distinct()
						.collect(Collectors.toList())
		);

	}
}
