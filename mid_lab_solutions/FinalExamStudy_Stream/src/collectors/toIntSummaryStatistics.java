package collectors;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class toIntSummaryStatistics {

	public static void main(String[] args) {
		summerizingInt();
	}

	static void summerizingInt(){
		List<String> words = Arrays.asList("Tom", "Tamirat", "Abebe", "Molla");
		
		IntSummaryStatistics summary = words.stream()
				.collect(Collectors.summarizingInt(String::length));
		
		System.out.println("Average = " + summary.getAverage());
		System.out.println("Count = " + summary.getCount());
		System.out.println("Maximum = " + summary.getMax());
		System.out.println("Minimum = " + summary.getMin());
		System.out.println("Sum = " + summary.getSum());
		
	}
}
