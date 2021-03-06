package getputwildcard;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GetPutPrinciple {

	public static void main(String[] args) {
		List<Double> dblList = Arrays.asList(4.6, 7.66, 4.66);
		List<Double> dist = Arrays.asList(4.0,6.0,23.0,232.0);
		System.out.println(returnSum(dblList));
		System.out.println(returnSumGenerics(dblList));
		System.out.println(copy(dist, dblList));
	}

	public static double returnSum(List<Double> dbl) {
		return dbl.stream().collect(Collectors.summarizingDouble(Double::doubleValue)).getSum();
	}

	public static double returnSumGenerics(Collection<? extends Number> dbl) {
		double sum = 0;

		for (Number d : dbl) {
			sum += d.doubleValue();
		}

		return sum;
	}

	public static <T> T copy(List<? super T> destination, List<? extends T> source) {
		for (int i = 0; i < source.size(); ++i) {
			destination.set(i, source.get(i));
		}
		
		return (T) destination;
	}

}
