package wildcardhelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * In some cases, the compiler infers the type of a wildcard. For example, a
 * list may be defined as List<?> but, when evaluating an expression, the
 * compiler infers a particular type from the code. This scenario is known as
 * wildcard capture
 * 
 * For the most part, you don't need to worry about wildcard capture, except
 * when you see an error message that contains the phrase "capture of".
 * 
 * @author tfisseha
 *
 */
public class UnBoundedWildcard {

	public static void main(String[] args) {
		List<Integer> ints = Arrays.asList(1, 3, 5, 2, 32);
		System.out.println(countList(ints));
		System.out.println(countListGenerics(Arrays.asList("String", 'C', 5, true, 32)));
		System.out.println(sumList(ints));
	}

	private static int countList(List<Integer> list) {
		return list.size();
	}

	private static int countListGenerics(List<?> list) {
		return list.size();
	}

	private static int sumList(List<Integer> list) {
		int sum = 0;
		for (int ele : list) {
			sum += ele;
		}
		return sum;
	}
//	private static <T> T sumListGenerics(List<?> list) {
//		int sum = 0;
//		for(T ele: list) {
//			sum +=ele;
//		}
//		return ele;
//	}

	/**
	 * In this example, the compiler processes the i input parameter as being of
	 * type Object. When the foo method invokes List.set(int, E), the compiler is
	 * not able to confirm the type of object that is being inserted into the list,
	 * and an error is produced. When this type of error occurs it typically means
	 * that the compiler believes that you are assigning the wrong type to a
	 * variable. Generics were added to the Java language for this reason — to
	 * enforce type safety at compile time
	 * 
	 * @param i
	 */
	void foo(List<?> i) {
		// i.set(0, i.get(0));
		fooHelper(i);
	}

	/**
	 * In this example, the code is attempting to perform a safe operation, so how
	 * can you work around the compiler error? You can fix it by writing a private
	 * helper method which captures the wildcard. In this case, you can work around
	 * the problem by creating the private helper method, fooHelper
	 */

	/**
	 * Thanks to the helper method, the compiler uses inference to determine that T
	 * is CAP#1, the capture variable, in the invocation. The example now compiles
	 * successfully.
	 * 
	 * @param <T>
	 * @param i
	 */

	/**
	 * we are like tricking the compiler
	 * 
	 * @param <T>
	 * @param i
	 */
	private <T> void fooHelper(List<T> i) {
		i.set(0, i.get(0));
	}

	/**
	 * more complex example
	 * 
	 * @param l1
	 * @param l2
	 */
	void swapFirst(List<? extends Number> l1, List<? extends Number> l2) {
//		Number temp = l1.get(0);
//		l1.set(0, l2.get(0)); // expected a CAP#1 extends Number,
//								// got a CAP#2 extends Number;
//								// same bound, but different types
//		l2.set(0, temp); // expected a CAP#1 extends Number,
//							// got a Number

		// swapFirstHelper(l1, l2);
	}

	/**
	 * There is no helper method to work around the problem, because the code is
	 * fundamentally wrong: it is clearly incorrect to take an item from a list of
	 * some values of a type number and attempt to place it into a list of another
	 * value of type Number.
	 * 
	 * @param <T>
	 * @param l1
	 * @param l2
	 */
	private <T> void swapFirstHelper(List<T> l1, List<T> l2) {
		T temp = l1.get(0);
		l1.set(0, l2.get(0)); // expected a CAP#1 extends Number,
		// got a CAP#2 extends Number;
		// same bound, but different types
		l2.set(0, temp); // expected a CAP#1 extends Number,
		// got a Number
	}

	public static void reverse(List<?> list) {
//		List<Object> tmp = new ArrayList<Object>(list);
//		for (int i = 0; i < list.size(); i++) {
//			list.set(i, tmp.get(list.size() - i - 1));
//		}
		reverseHelper(list);
	}
	
	private static <T> void reverseHelper(List<T> list) {
		List<T> tmp = new ArrayList<T>(list);
		for (int i = 0; i < list.size(); i++) {
			list.set(i, tmp.get(list.size() - i - 1));
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
