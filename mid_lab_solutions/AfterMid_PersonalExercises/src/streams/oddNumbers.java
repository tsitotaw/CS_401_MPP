package streams;

import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class oddNumbers {

	public static void main(String[] args) {
		
		Stream<Integer> oddStreams = Stream.iterate(1, n -> n +1);
		oddStreams.filter(n -> n%2 != 0)
			.filter(n -> n == 9 || n == 11 || n == 13 || n == 15)
			.limit(4)
			.collect(Collectors.toList())
			.forEach(System.out::println);

	}

}
