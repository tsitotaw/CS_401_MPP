package lambdalib;

import static java.util.Comparator.comparing;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;


import quizclasses.*;


public class LambdaLibrary {
	public final static String IMPLEMENT = "implement!";
	
	//sample query
	public final static TriFunction<List<Employee>, Integer, Integer, List<Employee>> SAMPLE
	   = (list, namelength, year) -> list.stream()
	                                     .filter(e -> e.getName().length() > namelength)
	                                     .filter(e -> e.getYearOfBirth() > year)
	                                     .collect(Collectors.toList());
	   
	public final static TriFunction<List<Employee>, Integer, Integer, List<Pair>> EMPS
		  = (list, lower, upper) -> list.stream()
		                                .filter(e -> e.getSalary() > lower && e.getSalary() < upper)
		                                .map(e -> new Pair(e.getName(), e.getSalary()))
		                                .sorted(Comparator.comparing((Pair p) -> p.name)
		                                .thenComparing((Pair p) -> -p.salary))
		                                .collect(Collectors.toList());
		  
    public final static BiFunction<List<Transaction>, Integer, List<Transaction>> TRANSACTIONS
		   = (list, year) -> list.stream()
	                             .filter(transaction -> transaction.getYear()==year.intValue())
	                             .sorted(comparing(Transaction::getValue))
	                             .collect(Collectors.toList());
		   
	public final static Function<List<Transaction>, List<TraderPair>> TRADERS
		      = list -> Util.allTraderPairs(list.stream().map(trans -> trans.getTrader()))
			            .filter(p -> p.getTrader1().getCity().equals(p.getTrader2().getCity()))
			            .filter(p -> p.getTrader1().isAssociate(p.getTrader2()))
			            .distinct()
			            .collect(Collectors.toList());
}
