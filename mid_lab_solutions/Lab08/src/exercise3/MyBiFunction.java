package exercise3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class MyBiFunction {

	public static void main(String[] args) {
		BiFunction<Double, Double, List<Double>> bif = (x,y) -> {
			List<Double> list = new ArrayList<>();
			list.add(Math.pow(x,y));
			list.add(x * y);
			return list;
		};
		
		System.out.println(bif.apply(2.0,  3.0));
	}

}
