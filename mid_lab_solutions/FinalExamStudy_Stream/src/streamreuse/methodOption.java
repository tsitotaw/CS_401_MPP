package streamreuse;

import java.util.stream.IntStream;

public class methodOption {

	public static void main(String[] args) {
		IntStream strm = getIntStream(1,10);
		strm.forEach(System.out::println);
		
		IntStream strm2 = getIntStream(1,10).distinct();		
		strm2.forEach(System.out::println);
	}
	
	static IntStream getIntStream(int lower, int upper) {
		return IntStream.range(lower, upper)
				.map(x -> x/2);
	}

}
