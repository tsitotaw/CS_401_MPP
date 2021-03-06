package terminalOperations;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class findAny {

	public static void main(String[] args) {
		System.out.println(findAny());
	}

	static String findAny(){
		List<String> words = Arrays.asList("Tom", "Tamirat", "Abebe", "Molla");
		
		Optional<String> optional=  words.stream()
				.filter(s -> s.startsWith("Toh"))
				.findAny();
		
		return optional.orElse("No data found!");//(optional.isPresent()) ? optional.get() : "";
			
	}
}
