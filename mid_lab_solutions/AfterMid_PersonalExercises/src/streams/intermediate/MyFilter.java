package streams.intermediate;

import java.util.stream.Stream;

public class MyFilter {

	public static void main(String[] args) {
		Stream<String> strm = Stream.of("Holla", "Hsjs", "shdjs");
		
		strm
			.filter(x -> x.length() > 4)
			.map(x -> x.toUpperCase())
			.forEach(System.out::println);
	}

}
