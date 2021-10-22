package exercise4;

import java.math.BigInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimeStream_A {

	public static void main(String[] args) {
		final Stream<BigInteger> primes = Stream.iterate(BigInteger.valueOf(2), BigInteger::nextProbablePrime); 
		System.out.println(primes.limit(2).collect(Collectors.toList()));	
	}
}
