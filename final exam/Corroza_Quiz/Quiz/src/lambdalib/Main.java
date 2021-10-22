package lambdalib;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import quizclasses.Employee;
import quizclasses.EmployeeTestData;
import quizclasses.Trader;
import quizclasses.TraderPair;
import quizclasses.TraderTransactTestData;
import quizclasses.Transaction;

/** SOLVE THE PROBLEMS HERE USING A LAMBDA LIBRARY */
public class Main {
	public static void main(String[] args) {
		System.out.println("Sample Query");
		List<Employee> sampleData = EmployeeTestData.getList();
		//SAMPLE: Create a Lambda Library entry that prints all Employee records for 
		//which name has length > 5 and birth year is > 1970
		System.out.println(LambdaLibrary.SAMPLE.apply(sampleData, 5, 1970));
		
		prob1();
		prob2();
		prob3();
	}
	
		//Create a Lambda Library entry that does the following:
	    //Create a stream pipeline that obtains a list of
		//all name/salary pairs extracted from a list of Employees
		//for which salary > 55000 and less than 120000, in ascending
		//order of name, then descending order of salary
		//Then call your Lambda Library entry to print the list to the console
		public static void prob1() {
			//use this list 
			List<Employee> list = EmployeeTestData.getList();
			System.out.println(LambdaLibrary.EMPLOYEE_LESS_20000.apply(list, 55000, 120000));
		}
		//Create a Lambda Library entry that does the following:
		//Obtain a list of all transactions that took place in the year 2011 and 
		//sort them by value (small to high).
		//(Note: there is an instance variable "value" in Transaction)
		//Then call your Lambda Library entry to print the list to console
		public static void prob2() {
			//use this list	
			List<Transaction> list = TraderTransactTestData.getTransactions();
			System.out.println(LambdaLibrary.TRANSACTION_LIST.apply(list, 2011));
		}
		// Create a Lambda Library entry that does the following:
		// Obtains all pairs of traders who are associates 
		// and come from the same
		// city, where trader pairs are represented by TraderPairs; these should be
		// sorted first by name of first trader, then by name of second trader.
		// There should be no duplicates. 
		// Then call your Lambda Library entry
		// to print to console
		public static void prob3() {
			//Use this list
			List<Transaction> list = TraderTransactTestData.getTransactions();  
			List<Trader> traders = list.stream().map(t -> (t.getTrader())).collect(Collectors.toList());
			Function<TraderPair, String> sortByTrader1Name = x -> {
				return x.getTrader1().getName();
			};
			System.out.println(LambdaLibrary.TRADERPAIRS.apply(traders, sortByTrader1Name));
		                
		}
	
}
