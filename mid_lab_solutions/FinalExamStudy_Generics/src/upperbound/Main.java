package upperbound;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Main {

	public static void main(String[] args) {
		List<Manager> man = Arrays.asList(new Manager("sample"), new Manager("sample"), new Manager("sample"));
		List<Employee> emp = Arrays.asList(new Employee("sample"), new Employee("sample"), new Employee("sample"));	
		List<Person> per = Arrays.asList(new Person("sample"), new Person("sample"), new Person("sample"));	
		//Person per = new Person("Sew");
		LocalDate d = LocalDate.now();
		
		//System.out.println(countOccurancesGeneric(emp, "sample"));
	}
	
	private static <T extends Manager> int countOccurancesGeneric(List<T> arr, String target) {
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
				if(item.getName() == target) {
					count++;
				}
			}
		}
		
		return count;
	}

}
