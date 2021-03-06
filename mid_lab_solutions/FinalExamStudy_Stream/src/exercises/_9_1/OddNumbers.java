package exercises._9_1;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OddNumbers {

	public static void main(String[] args) {
		Stream<Integer> oddStreams = Stream.iterate(1, n-> n+1);
		System.out.println(
				oddStreams
					.filter(x -> x%2 != 0)
					.limit(50)
					.collect(Collectors.toList())
					);
		
		Stream<Integer> oddStreamsFilteredFurther = Stream.iterate(1, n-> n+1);
		System.out.println(
				oddStreamsFilteredFurther
					.filter(x -> x%2 != 0)
					.filter(x -> x > 8 && x < 16)
					.limit(4)
					.collect(Collectors.toList())
					);
	}

}
