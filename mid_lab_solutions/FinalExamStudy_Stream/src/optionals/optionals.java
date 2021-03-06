package optionals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class optionals {

	public static void main(String[] args) {
		//System.out.println(startWithM());
		//System.out.println(findAny());
		System.out.println(Optional.of(findAnyCustomOptional()).get());
	}
	
	static String startWithM(){
		List<String> words = Arrays.asList("Tom", "Tamirat", "Abebe", "Molla");
		
		Optional<String> optional=  words.stream()
				.filter(s -> s.startsWith("Moh"))
				.findFirst();
		
		return (optional.isPresent()) ? optional.get() : "";
	}
	
	static String findAny(){
		List<String> words = Arrays.asList("Tom", "Tamirat", "Abebe", "Molla");
		
		Optional<String> optional=  words.stream()
				.filter(s -> s.startsWith("Toh"))
				.findAny();
		
		return optional.orElse("No data found!");
			
	}
	
	static String findAnyCustomOptional(){
		List<String> words = Arrays.asList("Tom", "Tamirat", "Abebe", "Molla");
		
		final Optional<String> optional=  words.stream()
				.filter(s -> s.startsWith("To"))
				.findAny();
		
		return optional.orElse("NOT");
		
	}
}
