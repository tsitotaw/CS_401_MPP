package streamreuse;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class functionOption {
	
	static final BiFunction<List<String>, String, Stream<String>> startsWith = 
			(list,letter) -> list.stream()
			.filter(x -> x.startsWith(letter));
			
	public static void main(String[] args) {
		List<String> list = Arrays.asList("Tom", "Tamirat", "Abebe", "Molla");
		
		Stream<String> strStream = startsWith.apply(list, "T");
		System.out.println(strStream.collect(Collectors.toList()));
		
		Stream<String> strStream2 = startsWith.apply(list, "A");
		System.out.println(strStream2.collect(Collectors.toList()));
				
	}

}
