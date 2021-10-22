package terminalOperations;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class count {

	public static void main(String[] args) {
		System.out.println(sortedByWordLengthLambda2());
	}

	static Long sortedByWordLengthLambda2(){
		List<String> words = Arrays.asList("Tom", "Tamirat", "Abebe", "Molla");
		Function<String, Integer> sortByLength = x -> x.length();
		
		return words.stream()
				.sorted(Comparator.comparing(sortByLength))
				.count();
	}
}
