package exercise_4;

import java.math.BigInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrimeStream {
	
	Function<Integer, Stream<BigInteger>> primes = (len) -> 
	Stream.iterate(
			BigInteger.valueOf(2), BigInteger::nextProbablePrime)
			.limit(len);
	
	public static void main(String[] args) {
		PrimeStream ps = new PrimeStream(); //PrimeStream is enclosing class
		ps.printFirstNPrimes(10);
		System.out.println("====");
		ps.printFirstNPrimes(5);
	}
	
	private void printFirstNPrimes(Integer n) {
		System.out.println(
				primes.apply(n)
				.collect(Collectors.toList())
		);
		
	}
	
	private Stream<BigInteger> getStream(long len){
		return Stream.iterate(BigInteger.valueOf(2), BigInteger::nextProbablePrime)
				.limit(len);
	}

}
