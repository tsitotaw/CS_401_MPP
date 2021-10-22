package streams.intermediate;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class MyMap {

	public static void main(String[] args) {
		Stream<String> strm = Stream.of("Holla", "Hsjs", "shdjs");
		Function<String, String> upperCaseFn = x -> x.toUpperCase();
		Function<String, String> lowerCaseFn = x -> x.toLowerCase();
		Consumer<String> printFn = System.out::println;
		strm
			.filter(x -> x.length() > 3) // Predicate<T, Boolean>
			.map(upperCaseFn)   // Function<T,R>
			.map(lowerCaseFn)
			.forEach(printFn);
	}

}
