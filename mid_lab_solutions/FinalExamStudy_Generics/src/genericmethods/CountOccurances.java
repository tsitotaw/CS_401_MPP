package genericmethods;

import java.util.stream.Stream;

public class CountOccurances {
	public static void main(String[] args) {
		System.out.println(countOccurances(new String[] {"sample", "data", "is", "sample"}, "sample"));
		System.out.println(countOccurancesGeneric(new String[] {"sample", "data", "is", "sample"}, "sample"));
		System.out.println(countOccurancesGeneric(new Integer[] {1, 2, 3, 4}, 4));
		System.out.println(countOccurancesGenericStream(new Integer[] {1, 4, 3, 4}, 5));
	}
	
	private static int countOccurances(String[] arr, String target) {
		int count = 0;
		if(target == null) {
			for(String item : arr) {
				if(item == null) {
					count++;
				}
			}
		}
		else {
			for(String item : arr) {
				if(item.equals(target)) {
					count++;
				}
			}
		}
		
		return count;
	}
	
	private static <T extends Comparable> int countOccurancesGeneric(T[] arr, T target) {
		int count=0;
		
		if(target == null) {
			for(T item : arr) {
				if(item == null) {
					count++;
				}
			}
		}
		else {
			for(T item : arr) {
				if(item.compareTo(target) == 0) {
					count++;
				}
			}
		}
		
		return count;
	}
	
	private static <T extends Comparable> int countOccurancesGenericStream(T[] arr, T target) {
		return (int)Stream.of(arr)
				.filter(ele -> ele.compareTo(target) == 0)
				.count();
		
	}
}
