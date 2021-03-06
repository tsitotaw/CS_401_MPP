package Final.prob2.exam.partC;

import java.util.Comparator;
import java.util.function.ToLongBiFunction;


//The lambda:   (Long a, Long b) -> a.compareTo(b)
//NOTE: You may NOT type this as a BiFunction
public class PartC {
	
	//provide a functional interface type for the lambda - do NOT use BiFunction
	ToLongBiFunction<Long,Long> getComparision1 = (x,y) -> x.compareTo(y);
	
	Comparator<Long> comp1 = (x,y) -> x.compareTo(y);
	Comparator<Long> comp2 = Long::compare;
	
	//provide a method reference and the type of method reference
	//TYPE: Class::staticMethod
	ToLongBiFunction<Long,Long> getComparision2 = Long::compare;
	// provide an inner class that behaves the same way as the labmda
	//class My--- implements --- { }
	class MyComparator implements Comparator<Long>{

		@Override
		public int compare(Long o1, Long o2) {
			return o1.compareTo(o2);
		}
		
	}
	
	class MyLongBiFunction implements ToLongBiFunction<Long, Long>{

		@Override
		public long applyAsLong(Long t, Long u) {
			return t.compareTo(u);
		}
		
	}
		
	
	public void evaluator() {
		System.out.println(getComparision1.applyAsLong(1L,2L));
		System.out.println(comp1.compare(1L,2L));
		
		System.out.println(getComparision2.applyAsLong(134L,23L));
		System.out.println(comp2.compare(134L,23L));
//		
		System.out.println((new MyLongBiFunction()).applyAsLong(464L,464L));
		System.out.println((new MyComparator()).compare(464L,464L));
	}
	
	public static void main(String[] args) {
		PartC pa = new PartC();
		pa.evaluator();
	}
}
