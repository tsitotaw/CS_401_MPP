package functional.interfaces;

/**
 * what is unique about this implementation? 
 * since we are using an interface, we can polymorphically add implementations as we wish in two ways
 * 	1 - by creating different implementation classes
 *  2 - by using anonymous classes and create implementations on the fly
 *  
 *  How about using lambda expressions?
 * @author tfisseha
 *
 */
public class MyAnnonymous implements IMyComparator<Integer, Integer>{

	public static void main(String[] args) {
		/**
		 * Here we have used class implementation
		 */
		IMyComparator<Integer, Integer> inst = new MyAnnonymous();
		System.out.println(inst.compare(1, 2));
		
		/**
		 * Here we have used annonymous class implementations
		 */
		IMyComparator<Integer, Integer> inst2 = new IMyComparator<Integer, Integer>() {
			
			@Override
			public Integer compare(Integer a, Integer b) {
				return 2;
			}
		};
		
		System.out.println(inst2.compare(1, 2));
		
		/**
		 * Here we have used lambda expressions
		 * What does it tell us?
		 * 	we reduced verbose code 
		 *  code became concise and 
		 *  code became clear
		 *  
		 *  Though, we still need to access the method through the interface instance
		 *  functions are still not first class citizens
		 */
		IMyComparator<Integer, Integer> inst3 = (a, b) -> {
			return a + b;
		};
		
		System.out.println(inst3.compare(34, 56));
		
		/**
		 * Here we are passing an interface instance as arguments
		 * which will be used to call the lambda expression
		 * 
		 * is this not similar as passing an object instance?
		 */
		printMe(inst3);
		
		/**
		 * Same implementation goes here ---
		 * What is changed?
		 * we are not really passing a function here --- are we?
		 */
		printMeObject(new MyAnnonymous());
		printMe(new MyAnnonymous());
	}

	@Override
	public Integer compare(Integer a, Integer b) {
		return a + b;
	}
	
	private static void printMe(IMyComparator<Integer, Integer> inst) {
		System.out.println(inst.compare(66, 6));
	}
	
	private static void printMeObject(MyAnnonymous inst) {
		System.out.println(inst.compare(66, 6));
	}

}
