package prob2.partC;

import java.util.Comparator;
import java.util.function.ToLongBiFunction;


//The lambda:   (Long a, Long b) -> a.compareTo(b)
//NOTE: You may NOT type this as a BiFunction
public class PartC {
	
	//provide a functional interface type for the lambda - do NOT use BiFunction
	Comparator<Long> compare = (a, b) -> a.compareTo(b);
	//provide a method reference and the type of method reference
	//TYPE: Class::instanceMethod
	Comparator<Long> compare2 = Long::compareTo;
	// provide an inner class that behaves the same way as the labmda
	//class My--- implements --- { }
	class MyComparator implements Comparator<Long>{

		@Override
		public int compare(Long o1, Long o2) {
			return o1.compareTo(o2);
		}
		
	}
		
	
	public void evaluator() {
		System.out.println(compare.compare(1L,2L));
		
		System.out.println(compare2.compare(134L,23L));
//		
		System.out.println((new MyComparator()).compare(464L,464L));
	}
	
	public static void main(String[] args) {
		PartC pa = new PartC();
		pa.evaluator();
	}
}
