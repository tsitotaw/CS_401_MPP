package streams.creation;

import java.util.stream.Stream;

public class ByStreamOfFromArguments {

	public static void main(String[] args) {
		
		Stream.of("hello", "world", "is")
		.forEach(System.out::println);
		
	}

}
