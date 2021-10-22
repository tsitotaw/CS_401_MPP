package exercise1;

import java.util.function.Supplier;

public class Main {

	public static void main(String[] args) {
		Supplier<Double> s = Math::random;
		Supplier<Double> s2 = () -> Math.random();
		
		System.out.println(s.get()); // Using Method Reference
		System.out.println(s2.get()); // Using lambda Expression		
		System.out.println(getRandom()); // Using local inner class
	}
	
	public static Double getRandom() {
		class RandomInner {
			public Double get() {
				return (Double)Math.random();
			}
		}
		return new RandomInner().get();
	}

}
