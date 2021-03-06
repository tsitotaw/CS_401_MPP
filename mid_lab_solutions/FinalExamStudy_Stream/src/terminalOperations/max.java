package terminalOperations;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class max {

	public static void main(String[] args) {
		System.out.println(sortedByWordLengthLambda2());
	}

	static String sortedByWordLengthLambda2(){
		List<String> words = Arrays.asList("Tom", "Tamirat", "Abebe", "Molla");
		Function<String, Integer> sortByLength = String::length;
		
		Optional<String> optional=  words.stream()
				.sorted(Comparator.comparing(sortByLength))
				.max(Comparator.comparing(sortByLength));
		
		return (optional.isPresent()) ? optional.get() : "";
			
	}
}
