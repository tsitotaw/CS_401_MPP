package streams.intermediate;

import java.util.Comparator;
import java.util.stream.Stream;

public class MyDistinct {
	
	
	public static void main(String[] args) {
		
		Comparator<String> comp = (a, b) -> b.length() - a.length();
		Comparator<String> then = (a, b) -> a.compareTo(b);
		Stream<String> strm = Stream.of("sampl", "record", "smpe", "sale", "recrd");
		strm
			.distinct()
			.sorted(comp.reversed().thenComparing(then))
			.forEach(System.out::println);
	}
}
