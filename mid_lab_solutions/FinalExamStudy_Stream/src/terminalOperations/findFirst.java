package terminalOperations;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class findFirst {

	public static void main(String[] args) {
		System.out.println(startWithM());
	}

	static String startWithM(){
		List<String> words = Arrays.asList("Tom", "Tamirat", "Abebe", "Molla");
		
		Optional<String> optional=  words.stream()
				.filter(s -> s.startsWith("Moh"))
				.findFirst();
		
		return (optional.isPresent()) ? optional.get() : "";
			
	}
}
