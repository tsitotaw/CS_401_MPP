package primitivestreams;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class myIntStream {

	public static void main(String[] args) {
		IntStream myInts = IntStream.range(1,25)
				.map(x -> x*1);
		
		System.out.println(Arrays.toString(myInts.toArray()));
		
		// back to the wrapper class
		Stream<Integer> wrapperStream = myInts.boxed();
		
		//back to Primitive Type
		IntStream backToInt = wrapperStream.mapToInt(Integer::intValue);
		
	}

}
