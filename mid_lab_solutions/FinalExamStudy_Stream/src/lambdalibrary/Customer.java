package lambdalibrary;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class Customer {
	private String name;
	private int age;

	public Customer(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return age == other.age && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", age=" + age + "]";
	}
	
	
	public static void main(String[] args) {

		/**
		 * You have a List of Customers. Output to a list, in sorted order, the names of
		 * those Customers whose age is between 100 - 250
		 */

		List<Customer> customers = Arrays.asList(new Customer("Tamirat", 30), new Customer("Fisseha", 60),
				new Customer("Sitotaw", 100), new Customer("Yimer", 180), new Customer("Mengesha", 240),
				new Customer("Goshu", 300));

		System.out.println(lamdbaLibrary.customerQuery.apply(customers, 190));//.forEach(System.out::println);
	}

}

interface ICustomerInterface {
	
}

















