package exercises._9_4;

import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		BinaryOperator<String> reducer = (x,y) -> x + " " + y;
		System.out.println(
				Stream.of("A", "good", "day", "to", "write", "some", "Java")
				.reduce("", reducer)
				);
	}

}
