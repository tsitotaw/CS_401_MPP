package exceptions_practice;

import java.util.List;
import java.util.stream.Collectors;

public class InnerExceptionHandlingClass2 {
	
	public static List<Integer> scale(List<Integer> values, Integer factor) {
		return values.stream().map(n -> {
			try {
				return n / factor;
			} catch (ArithmeticException ex) {
				throw new RuntimeException("division by zero");
			}
		}).collect(Collectors.toList());
	}
}
