package streams.creation;

import java.util.stream.Stream;

public class ByStreamUsingInterator {

	public static void main(String[] args) {
		Stream<Integer> strm = Stream.iterate(67, (i) -> i+1 );
		
		strm
		.limit(11)
		.forEach(System.out::println);
		
		Stream<Integer> strmOdd = Stream.iterate(1, (i) -> i+1)
				.filter(x -> x%2 != 0);
		
		strmOdd.limit(100).forEach(System.out::println);
		
		Stream<Integer> onlyFew = strmOdd
				.filter(x -> {
					return x > 8 && x < 16;
				});
		
		onlyFew.forEach(System.out::println);
		
	}

}
