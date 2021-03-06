package genericmethods;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class FindMax {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,3,2,34,32,45,22,43,2);
		List<LocalDate> localDate = Arrays.asList(LocalDate.of(2012, 10,10), LocalDate.of(2014, 10,10),  LocalDate.of(2011, 10,10));
		System.out.println(max(list));
		System.out.println(maxUsingGenerics(list));
		System.out.println(maxUsingGenerics(localDate));
		System.out.println(maxUsingStream(list));
	}
	
	public static Integer max(List<Integer> list) {
		Integer max = list.get(0);
		
		for(Integer i: list) {
			if(i.compareTo(max) > 0) {
				max = i;
			}
		}
		
		return max;
	}
	
	/**
	 * if we use the non-generic, we could risk on allowing not compatible types - and the compiler will not check
	 * we could do like this Object c new Object(); then if we do i.compareTo(c); // this will cause runtime exception
	 * 
	 * upper bound method implementation
	 * @param <T>
	 * @param list
	 * @return
	 */
	public static <T extends Comparable<T>> T maxUsingGenerics(List<? extends T> list) {
		//list.add(null);
		T max = list.get(0);
		for(T i: list) {
			if(i.compareTo(max) > 0) {
				max = i;
			}
		}
		
		return max;
	}
	
	public static Integer maxUsingStream(List<Integer> list) {
		
		IntSummaryStatistics stat =  list.stream()
		.collect(Collectors.summarizingInt(Integer::intValue));
		
		return stat.getMax();
	}

}
