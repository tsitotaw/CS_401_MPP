package intermediateoperations;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class concat {

	public static void main(String[] args) {
		Stream<Integer> myConcatStream = Stream.concat(myIteratorStream(), myGeneratorStream());
		myConcatStream.forEach(System.out::print);
		
		System.out.println(Stream.concat(Stream.of("Hello"), Stream.of("World")).collect(Collectors.toList()));
	}
	
	public static Stream<Integer> myIteratorStream(){
		return Stream.iterate(1, n -> n+2).limit(5);
	}
	
	public static Stream<Integer> myGeneratorStream(){
		return Stream.generate(() -> 3).limit(5);
	}

}
