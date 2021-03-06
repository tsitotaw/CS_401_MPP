package streams.creation;

import java.util.Random;
import java.util.stream.Stream;

public class ByStreamUsingGenerator {

	public static void main(String[] args) {
		Stream<String> strm = Stream.generate(() -> "Echo");
		
		strm
			.limit(100)
			.forEach(System.out::println);
		
		Stream<Integer> strm2 = Stream.generate(() -> {
			Double val = Math.random() * 100;
			return val.intValue();
		});
		
		strm2
		.limit(20)
		.forEach(System.out::println);
	}

}
