package genericmethods;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Contains {

	public static void main(String[] args) {
		List<Integer> ints = Arrays.asList(1,2, 3);
		List<Long> longs = Arrays.asList(1L,2L, 3L);
		List<String> list = Arrays.asList("Bob", "Joe", "Tom");
		List<Object> olist = Arrays.asList("Bob", 1, "true");
		List<Person> plist = Arrays.asList(new Person("Tamirat"), new Person("Fisseha"), new Person("Soli"));
		
		System.out.println(contains1(ints, 22, Comparator.comparing(Integer::valueOf)));				
		System.out.println(contains2(longs, 2L, Comparator.comparing(Long::longValue)));				
		System.out.println(contains1(list, "Joe", Comparator.comparing(String::toString)));				
		System.out.println(contains1(olist, 1, Comparator.comparing(Object::toString)));				
	    System.out.println(contains1(plist, new Person("Fissehaa"), Comparator.comparing(Person::getName)));				

	}
	
	public static <T extends Serializable> boolean contains2(List<T> list,T s, Comparator<T> t) {
	
		for(T x : list) {
			if(x == null && s == null) return true;
			if(s == null || x == null) continue;
			
			if((t.compare(x, s) == 0)) return true;
		}
		
		return false;
	}
	public static <T> boolean contains1(List<T> list, T s, Comparator<T> t) {
		
		for(T x : list) {
			if(x == null && s == null) return true;
			if(s == null || x == null) continue;
			
			if((t.compare(x, s)) == 0) return true;
		}
		
		return false;
	}

}

class Person {
	private String name;
	
	public Person(String name) {
	  this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
