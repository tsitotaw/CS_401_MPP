package exercise9;

import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;

public class Main {
	static int count = 1;
	
	public static void main(String[] args) {
		printSquares(4);
	}

	public static void printSquares(int num) {
		IntUnaryOperator squarer = (i) -> {
			++count;
			return count*count;
		};
		IntStream intStream = IntStream.iterate(1,squarer).limit(num); 		
		//IntStream intStream = IntStream.iterate(1,n-> calcSquare(++count)).limit(num); 		
		intStream.forEach(i -> System.out.print(i+" "));
	}
	
	public static int calcSquare(int num) {
		return (int)Math.pow(num, 2);
	}
}