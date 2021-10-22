package streams.creation;

import java.util.stream.Stream;

public class ByStreamOfFromArray {

	public static void main(String[] args) {
		
		Integer[] myScores = {1,4,3,5,7};
		
		Stream.of(myScores)
			.forEach(System.out::println);

	}

}
