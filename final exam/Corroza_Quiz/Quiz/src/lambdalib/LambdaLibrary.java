package lambdalib;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

import quizclasses.Employee;
import quizclasses.Pair;
import quizclasses.Trader;
import quizclasses.TraderPair;
import quizclasses.Transaction;
import quizclasses.Util;

public class LambdaLibrary {
	public final static String IMPLEMENT = "implement!";

	// sample query
	public final static TriFunction<List<Employee>, Integer, Integer, List<Employee>> SAMPLE = (list, namelength,
			year) -> list.stream().filter(e -> e.getName().length() > namelength).filter(e -> e.getYearOfBirth() > year)
					.collect(Collectors.toList());

	public static final TriFunction<List<Employee>, Integer, Integer, List<Pair>> EMPLOYEE_LESS_20000 = (list,
			lowerSalary, upperSalary) -> list.stream()
					.filter(x -> x.getSalary() > lowerSalary && x.getSalary() < upperSalary)
					.sorted(Comparator.comparing(Employee::getName)
							.thenComparing(Comparator.comparing(Employee::getSalary).reversed()))
					.map(x -> new Pair(x.getName(), x.getSalary())).collect(Collectors.toList());

	public static final BiFunction<List<Transaction>, Integer, List<Transaction>> TRANSACTION_LIST = (list,
			year) -> list.stream().filter(x -> x.getYear() == year).sorted(Comparator.comparing(Transaction::getValue))
					.collect(Collectors.toList());

	public static final BiFunction<List<Trader>, Function<TraderPair, String>, List<TraderPair>> TRADERPAIRS = (traders,
			sortByTrader1Name) -> Util.allTraderPairs(traders.stream())
					.filter(tp -> tp.getTrader1().isAssociate(tp.getTrader2()))
					.filter(tp -> tp.getTrader1().getCity().equals(tp.getTrader2().getCity()))
					.map(tp -> new TraderPair(tp.getTrader1(), tp.getTrader2()))
					.sorted(Comparator.comparing(sortByTrader1Name)).distinct().collect(Collectors.toList());
}
