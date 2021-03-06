package wildcardhelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reverse {

	
	public static void reverse(List<?> items) {		
		reverseHelper(items);
	}
	
	public static void copy(List<?> items) {		
		copyHelper(items);
	}
	
	public static <T> void copyHelper(List<T> items) {		
		T item  = items.get(0);
		items.add(item);
	}

	private static <T> void reverseHelper(List<T> list) {
		List<T> tmp = new ArrayList<T>(list);   
		for (int i = 0; i < list.size(); i++) { 
	        list.set(i, tmp.get(list.size() - i - 1));
		}
	}
	
	public static void main(String[] args) {
		List<Person> persons = Arrays.asList(new Person("Joe"), new Person("Jim"), 
				new Person("Tom"), new Person("Anne"));
		System.out.println("Before reversing: " + persons);
		Reverse.reverse(persons);
		System.out.println("After reversing: " + persons);
		
	}
}
