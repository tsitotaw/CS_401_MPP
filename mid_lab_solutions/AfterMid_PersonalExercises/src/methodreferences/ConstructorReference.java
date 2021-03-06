package methodreferences;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class ConstructorReference {

	public static void main(String[] args) {
//		Stream<Person> func = Stream.generate(() -> new Person());
//		Stream<Person> func = Stream.generate(Person::new);
//		func
//			.limit(10)
//			.forEach(System.out::println);
		
		
		List<String> strings = Arrays.asList("Eleven", "strikes", "the", "clock");
//		
//		//First solution
//		String[] stringArr1 = strings.toArray(new String[0]);
//		Stream.of(stringArr1).forEach(System.out::println);
//		System.out.println(Arrays.toString(stringArr1));
//		
//		//Second solution, using a constructor reference
	String[] stringArr2 = strings.stream().toArray(String[]::new);
		System.out.println(Arrays.toString(stringArr2));
	}

}

class Person {
	
	Person(){
		getName();
	}
	void getName() {
		System.out.println("HEllo Person");
	}
	
}