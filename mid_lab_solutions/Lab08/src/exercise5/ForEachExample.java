package exercise5;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ForEachExample {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("Hello there", "Goodbye", "Back soon", 
				"Away", "On Vacation", "Everywhere you want to be");
		
		//print each element of the list in upper case format
		Consumer<String> cons = (item) -> System.out.println(item.toUpperCase());
		list.forEach(cons);	//(s -> System.out.println(s.toUpperCase())
	}
	
	static class MyConsumer implements Consumer<String> {
		public void accept(String s) {
			System.out.println(s.toUpperCase());
		}
	}
}
