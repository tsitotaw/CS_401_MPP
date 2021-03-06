package streams;

import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class StringCreator {
	public static void main(String[] args) {
	  char[] charArray = 
              {'s','p','e','a','k','i','n','g','c','s'};
	  //can create a string from a char array
//	  System.out.println(new String(charArray));
//	  
//	  //do the same using constructor method reference
//	  Function<char[], String> myFunc = String::new;
//	  System.out.println(myFunc.apply(charArray));
	  
	 //.//Stream<char[]> streamString = ;
	 
	 System.out.println(
			 Stream.of(charArray)
			 .map(String::new)
			 //.peek(x -> System.out.println(x))
			 //.reduce("", (x, y) -> x.toString()+y.toString()));
//			 .map(x -> x.toString())
			 .collect(Collectors.toList()));
	  
    }
}
