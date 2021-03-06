package intermediateoperations;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class distinct {

	public static void main(String[] args) {
		System.out.println(distinctIntegerList());
		System.out.println(distinctPersonList());
	}

	static List<Integer> distinctIntegerList() {
		List<Integer> nums = Arrays.asList(1, 3, 4, 2, 3, 5, 6, 3, 2, 1, 2, 3, 4, 6);

		return nums.stream().distinct().collect(Collectors.toList());
	}

	static List<Person> distinctPersonList() {

		List<Person> persons = Arrays.asList(new Person("Tamirat"), new Person("Tamirat"), new Person("Fisseha"));
		return persons.stream()
				.distinct()
				.collect(
						Collectors.toList()
				);
		
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
