package collectors;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;


public class toMap {
	public static void main(String[] args) {
		System.out.println(mapStringString());
		System.out.println(mapStringPerson());
	}

	static Map<String, String> mapStringString(){
		List<Person> persons = Arrays.asList(new Person("Tamirat"), new Person("Tamirat"), new Person("Fisseha"));
		
		
		return persons.stream()
				.distinct()
				.collect(Collectors.toMap(Person::getName, Person::getName));
	}
	
	static Map<String, Person> mapStringPerson(){
		List<Person> persons = Arrays.asList(new Person("Tamirat"), new Person("Tamirat"), new Person("Fisseha"));
		
		
		return persons.stream()
				.distinct()
				.collect(Collectors.toMap(Person::getName, Function.identity()));
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

	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(name, other.name);
	}

	
}
