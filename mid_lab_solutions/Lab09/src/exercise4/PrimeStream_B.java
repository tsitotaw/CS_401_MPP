package exercise4;

import java.math.BigInteger;
import java.util.stream.Stream;

public class PrimeStream_B {

	public static void main(String[] args) {
		PrimeStream_B ps = new PrimeStream_B(); //PrimeStream is enclosing class
		ps.printFirstNPrimes(10);
		System.out.println("\n============================================");
		ps.printFirstNPrimes(5);
	}

	private void printFirstNPrimes(int limit) {
		returnSharedStream(limit)
          .forEach(x -> System.out.format("%s ", x));
	}
	
	private Stream<BigInteger> returnSharedStream(int length){
		return Stream.iterate(BigInteger.valueOf(2), BigInteger::nextProbablePrime)
				.limit(length);
	}
}
