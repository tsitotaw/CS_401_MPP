package exceptions_practice;

import java.util.List;
import java.util.stream.Collectors;

public class AuxillaryMethodExceptionHandlingClass3 {

	public static List<Integer> scale(List<Integer> values, Integer factor) {
		return values.stream().map(n -> helper(n, factor)).collect(Collectors.toList());
	}
	
	private static int helper(int num, int factor) {
		try {
			return num / factor;
		} catch (ArithmeticException ex) {
			throw new RuntimeException("division by zero");
		}
	}
}
