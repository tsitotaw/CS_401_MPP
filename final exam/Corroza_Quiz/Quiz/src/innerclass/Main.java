package innerclass;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import quizclasses.Employee;
import quizclasses.EmployeeTestData;
import quizclasses.Pair;
import quizclasses.Trader;
import quizclasses.TraderPair;
import quizclasses.TraderTransactTestData;
import quizclasses.Transaction;
import quizclasses.Util;

/**
 * SOLVE THE PROBLEMS HERE BY REPLACING LAMBDA EXPRESSIONS IN YOUR PIPELINE
 * SOLUTIONS WITH LOCAL INNER CLASSES
 *
 */
public class Main {
	public static void main(String[] args) {

		// SAMPLE: Use local inner classes to replace lambdas in your pipeline solution
		// to
		// this sample problem:
		// Print all Employee records for which name has length > 5 and birth year is >
		// 1970

		class NameLength implements Predicate<Employee> {
			public boolean test(Employee e) {
				return e.getName().length() > 5;
			}
		}
		class BirthYear implements Predicate<Employee> {
			public boolean test(Employee e) {
				return e.getYearOfBirth() > 1970;
			}
		}
		//System.out.println("Sample Query");
		List<Employee> sampleData = EmployeeTestData.getList();

		List<Employee> result = sampleData.stream().filter(new NameLength()).filter(new BirthYear())
				.collect(Collectors.toList());
		//System.out.println(result);

		prob1();
		prob2();
		prob3();
	}

	// Transform your pipeline solution to prob1 in the pipeline package so that
	// every lambda is replaced by an instance of a
	// local inner class of the correct type
	public static void prob1() {

		class FilterBySalary implements Predicate<Employee> {

			@Override
			public boolean test(Employee x) {
				return x.getSalary() > 55000 && x.getSalary() < 120000;
			}

		}

		class TransformToPair implements Function<Employee, Pair> {

			@Override
			public Pair apply(Employee x) {
				// TODO Auto-generated method stub
				return new Pair(x.getName(), x.getSalary());
			}

		}

		class ComparatorByName implements Comparator<Employee> {

			@Override
			public int compare(Employee o1, Employee o2) {
				return (o1.getName().compareTo(o2.getName()) > 0) ? 1
						: (o1.getName().compareTo(o2.getName()) < 0) ? 1 : 0;
			}

		}

		class ComparatorBySalary implements Comparator<Employee> {

			@Override
			public int compare(Employee o1, Employee o2) {
				return (o1.getSalary() - o2.getSalary() > 0) ? 1 : (o1.getSalary() - o2.getSalary() < 0) ? 1 : 0;
			}

		}
		// use this list
		List<Employee> list = EmployeeTestData.getList();

		System.out.println(list.stream().filter(new FilterBySalary())
				.sorted(new ComparatorByName().thenComparing(new ComparatorBySalary())).map(new TransformToPair())
				.collect(Collectors.toList()));

	}

	/// Transform your pipeline solution to prob2 so that
	// every lambda is replaced by an instance of a
	// local inner class of the correct type
	public static void prob2() {
		// use this list
		class FilterByYear implements Predicate<Transaction>{

			@Override
			public boolean test(Transaction x) {
				return x.getYear() == 2011;
			}
			
		}
		
		class ComparatorByValue implements Comparator<Transaction>{

			@Override
			public int compare(Transaction o1, Transaction o2) {
				return (o1.getValue() - o2.getValue()) > 0 ? 1 : -1;
			}
			
		}
		List<Transaction> list = TraderTransactTestData.getTransactions();
		System.out.println(
				list.stream()
				.filter(new FilterByYear())
				.sorted(new ComparatorByValue())
				.collect(Collectors.toList()));
	}

	// Transform your pipeline solution to prob3 so that
	// every lambda is replaced by an instance of a
	// local inner class of the correct type
	public static void prob3() {
		// Use this list
		List<Transaction> list = TraderTransactTestData.getTransactions();

		List<Trader> traders = list.stream().map(t -> (t.getTrader())).collect(Collectors.toList());

		class FilterByAssociate implements Predicate<TraderPair>{

			@Override
			public boolean test(TraderPair x) {
				return x.getTrader1().isAssociate(x.getTrader2());
			}
			
		}
		class ComparatorByTradeName implements Comparator<TraderPair> {

			@Override
			public int compare(TraderPair o1, TraderPair o2) {
				return (o1.getTrader1().getName().compareTo(o1.getTrader2().getName()) > 0) ? 1 : -1;
			}
			
		}
		
		class TransformTradePair implements Function<TraderPair, TraderPair>{

			@Override
			public TraderPair apply(TraderPair t) {
				return new  TraderPair(t.getTrader1(), t.getTrader2());
			}
			
		}
		
		class FilterByCity implements Predicate<TraderPair>{
			
			@Override
			public boolean test(TraderPair x) {
				return x.getTrader1().getCity().equals(x.getTrader2().getCity());
			}
			
		}

		System.out.println(
				Util.allTraderPairs(traders.stream())
						.filter(new FilterByAssociate())
						.filter(new FilterByCity())
						.map(new TransformTradePair())
						.sorted(new ComparatorByTradeName())
						.distinct()
						.collect(Collectors.toList())
		);
	}
}
