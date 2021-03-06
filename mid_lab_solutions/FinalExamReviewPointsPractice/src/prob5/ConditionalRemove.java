package prob5;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

// java.util.ConcurrentModificationException
public class ConditionalRemove {

	static class StrLengthCondition implements Predicate<String> {
		public boolean test(String s) {
			return s.length() == 5;
		}
	}

	public static List<String> conditionalRemove(ArrayList<String> list) {
		StrLengthCondition cond = new StrLengthCondition();
		for (String s : list) {
			if (cond.test(s)) {
				list.remove(s);
			}
		}
		return list;
	}

	public static List<String> conditionalRemove1(ArrayList<String> list, Predicate<String> fn) {
		List<String> itemsToAdd = new ArrayList<>();
		for (String s : list) {
			if (!fn.test(s)) {
				itemsToAdd.add(s);
			}
		}
		return itemsToAdd;
	}

	public static <T> List<T> conditionalRemove2(ArrayList<T> list, Predicate<T> fn) {
		List<T> itemsToAdd = new ArrayList<>();
		for (T s : list) {
			if (!fn.test(s)) {
				itemsToAdd.add(s);
			}
		}

		return itemsToAdd;
	}

	public static <T> List<? extends T> conditionalRemove3(ArrayList<? extends T> list, Predicate<? super T> fn) {
		for (int i = 0; i < list.size(); i++) {
			if (fn.test(list.get(i))) {
				list.remove(i);
			}
		}

		return list;
	}

}

//Employee("Bob", 55000, LocalDate.of(2014,  1, 1))
class Employee {
	private String name;
	private int salary;
	private LocalDate hireDate;

	public Employee(String name, int salary, LocalDate hireDate) {
		super();
		this.name = name;
		this.salary = salary;
		this.hireDate = hireDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public LocalDate getHireDate() {
		return hireDate;
	}

	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(hireDate, name, salary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(hireDate, other.hireDate) && Objects.equals(name, other.name)
				&& Objects.equals(salary, other.salary);
	}

	@Override
	public String toString() {
		return "[name=" + name + ", salary=" + salary + "]";
	}

}
