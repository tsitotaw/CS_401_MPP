package exceptions_practice;

import java.util.List;
import java.util.stream.Collectors;

public class BestAndFinalClass4 {

	public static List<Integer> scale(List<Integer> values, Integer factor) {
		return values.stream().map(FunctionWithException.wrapper(n-> n / factor)).collect(Collectors.toList());
	}
}
