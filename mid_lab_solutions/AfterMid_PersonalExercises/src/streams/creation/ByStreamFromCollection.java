package streams.creation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ByStreamFromCollection {

	public static void main(String[] args) {
		List<String> myList = Arrays.asList("hello", "world", "is", "the", "first", "output", "when", "learning", "programming");
		
		List<String> myListStream = myList.stream()
				.collect(Collectors.toList());
		myListStream
			.forEach(System.out::println);
		
		Long count = myList.stream()
		.count();
		
		
		System.out.println(count);

	}

}
