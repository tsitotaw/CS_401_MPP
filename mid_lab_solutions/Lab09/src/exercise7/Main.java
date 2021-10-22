package exercise7;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;


public class Main {

	public static void main(String[] args) {
		List<Integer> intList = Arrays.asList(4, 5, -2, 0, -3, -1, -5, -4, 1);
		
		//expected output: [0, -1, 1, -2, -3, -4, 4, -5, 5]
		ordering1(intList);
		List<String> stringList = Arrays.asList("cba", "efg", "doe", "fie", "set");
		
		//expected output: [cba, fie, doe, efg, set]
		ordering2(stringList);
		
	}
	
	public static void ordering1(List<Integer> list) {
		
		//Comparator<Integer> absCompare = Comparator.comparing(Math::abs);
		
		System.out.println(
				list.stream()
				.sorted(Comparator.comparing(Integer::intValue).thenComparing(Math::abs))
				.collect(Collectors.toList()));
	}
	
	public static void ordering2(List<String> words) {
		
		Comparator<String> reverseComparator = Comparator.comparing(str -> (new StringBuilder(str).reverse().toString()));
		System.out.println(
				words.stream()
				.sorted(reverseComparator)
				.collect(Collectors.toList()));
		
	}

}
