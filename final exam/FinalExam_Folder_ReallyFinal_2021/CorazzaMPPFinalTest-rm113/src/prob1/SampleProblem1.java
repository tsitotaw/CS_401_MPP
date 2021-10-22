package prob1;

import java.util.function.BiConsumer;

// working with lambda expression:   (Integer x, Integer y) -> System.out.println(x + y);
public class SampleProblem1 {
	// name and type of lambda goes here
	BiConsumer<Integer, Integer> biconsumer =
			(x, y) -> System.out.println(x + y);
	
	// representing lambda as a method refrence
	BiConsumer<Integer, Integer> biconsumer2 =
			SampleProblem1::printSum;
	
	//representing lambda as a static nested class
	static class PrintSum implements BiConsumer<Integer, Integer> {
		public void accept(Integer x, Integer y) {
			System.out.println(x + y);
		}
	}
	
	private static void printSum(Integer x, Integer y) {
		System.out.println(x + y);
	}
	
	//evaluate with Integer inputs 2, 7
	public void evaluator() {
		biconsumer.accept(2, 7);
		biconsumer2.accept(2,7);
		(new PrintSum()).accept(2,  7);
	}
	public static void main(String[] args) {
		SampleProblem1 p = new SampleProblem1();
		p.evaluator();
	}
	
	
	

}
