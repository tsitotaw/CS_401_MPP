package collectors;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class toSet {

	public static void main(String[] args) {
		System.out.println(sortedByWordLengthLambda2());
	}

	static Set<String> sortedByWordLengthLambda2(){
		List<String> words = Arrays.asList("Tom", "Tamirat", "Abebe", "Molla", "Tom");
		Function<String, Integer> sortByLength = x -> x.length();
		
		return words.stream()
				.sorted(Comparator.comparing(sortByLength))
				.collect(Collectors.toSet());
	}
}
