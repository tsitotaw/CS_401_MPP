package collectors;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Joining {

	public static void main(String[] args) {
		System.out.println(sortedByWordLengthLambda2());
		System.out.println(joinByComma());
		System.out.println(joinByCommaNumbers());
	}

	static String sortedByWordLengthLambda2(){
		List<String> words = Arrays.asList("Tom", "Tamirat", "Abebe", "Molla");
		Function<String, Integer> sortByLength = x -> x.length();
		
		return words.stream()
				.sorted(Comparator.comparing(sortByLength))
				.collect(Collectors.joining());
	}
	
	static String joinByComma(){
		List<String> words = Arrays.asList("Tom", "Tamirat", "Abebe", "Molla");
		Function<String, Integer> sortByLength = x -> x.length();
		
		return words.stream()
				.sorted(Comparator.comparing(sortByLength))
				.collect(Collectors.joining(", "));
	}
	static String joinByCommaNumbers(){
		List<Integer> words = Arrays.asList(1,2,3);
		
		return words.stream()
				.map(Object::toString)
				.collect(Collectors.joining(", "));
	}
}
