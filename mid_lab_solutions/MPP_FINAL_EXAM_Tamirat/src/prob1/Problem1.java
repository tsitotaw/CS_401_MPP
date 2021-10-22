package prob1;

import java.util.function.BiPredicate;

//work with this lambda expression:   (Double x, Double y) -> x * y < x + y
public class Problem1 {
	
	// name and type of lambda goes here
	BiPredicate<Double, Double> bipredicate = (Double x, Double y) -> x * y < x + y;
	
	// representing lambda as a method reference
	BiPredicate<Double, Double> bipredicate2 = Problem1::isNumbersLessWhenMultOrAdd;
	
	//representing lambda as a static nested class
	class MyBiPredicate implements BiPredicate<Double, Double>{

		@Override
		public boolean test(Double x, Double y) {
			return x * y < x + y;
		}
	}	
	
	private static boolean isNumbersLessWhenMultOrAdd(Double x, Double y) {
		return x * y < x + y;
	}
	
	//evaluate with Double inputs 2.1, 0.35
	public void evaluator() {
		
		System.out.println(bipredicate.test(2.1, 0.35));
		System.out.println(bipredicate2.test(2.1, 0.35));		
		System.out.println((new MyBiPredicate()).test(2.1,  0.35));
		
	}
	public static void main(String[] args) {
		Problem1 p = new Problem1();
		p.evaluator();
	}
	
	
}
