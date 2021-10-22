package exercise2.partc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;

public class EmployeeInfo {
	static enum SortMethod {
		BYNAME, BYSALARY
	};

	private SortMethod method;

	public EmployeeInfo(SortMethod method) {
		this.method = method;
	}

	// Comparators are unaware of the value in method
	public void sort(List<Employee> emps, final SortMethod method) {
		Collections.sort(emps, (e1,e2) ->
		{
			if(method == SortMethod.BYNAME) {
				return e1.name.compareTo(e2.name);
			} else {
				if(e1.salary == e2.salary) return 0;
				else if(e1.salary < e2.salary) return -1;
				else return 1;
			}
		});	
	}

	public static void main(String[] args) {
		List<Employee> emps = new ArrayList<>();
		emps.add(new Employee("Joe", 100000));
		emps.add(new Employee("Joe", 50000));
		emps.add(new Employee("Andy", 60000));
		
		

		Employee joe = new Employee("Joe", 100000);
		Employee joe2 = new Employee("Joe", 200000);
//		List<Employee> list = Arrays.asList(joe, joe2);
//		Collections.sort(list, new EmployeeNameComparator());
//		System.out.println(list);
//
//		System.out.println("joe equals joe2? " + joe.equals(joe2));
		EmployeeNameComparator c = new EmployeeNameComparator();
		System.out.println("joe equals joe2? " + (c.compare(joe, joe2) == 0));

//		EmployeeInfo ei = new EmployeeInfo(EmployeeInfo.SortMethod.BYNAME);
//		ei.sort(emps);
//		System.out.println(emps);
//		ei = new EmployeeInfo(EmployeeInfo.SortMethod.BYSALARY);
//		ei.sort(emps);
//		System.out.println(emps);

	}
}
