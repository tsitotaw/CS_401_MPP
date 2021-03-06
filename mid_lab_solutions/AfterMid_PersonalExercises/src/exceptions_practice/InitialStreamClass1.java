package exceptions_practice;

import java.util.List;
import java.util.stream.Collectors;

public class InitialStreamClass1 {

	public static List<Integer> scale(List<Integer> values, Integer factor) {
	    return values.stream()
	        .map(n -> n / factor)
	        .collect(Collectors.toList());
	}
}
