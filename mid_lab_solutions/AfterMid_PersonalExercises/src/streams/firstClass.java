package streams;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class firstClass {

	public static void main(String[] args) {
		Integer[] arrOfInt = {1, 3, 5, 7};
		//one-element Stream
		Stream<Integer> strOfInt = Stream.of(arrOfInt);
		;
		System.out.println(strOfInt.filter(x -> x < 5).collect(Collectors.toList()));
	}
}
