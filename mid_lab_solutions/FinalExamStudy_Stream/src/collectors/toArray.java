package collectors;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class toArray {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(sortedByWordLengthLambda2()));
	}

	static String[] sortedByWordLengthLambda2(){
		List<String> words = Arrays.asList("Tom", "Tamirat", "Abebe", "Molla");
		Function<String, Integer> sortByLength = x -> x.length();
		Comparator<String> byLength = Comparator.comparing(sortByLength);
		return words.stream()
				.sorted(byLength)
				.toArray(String[]::new);
	}
}
