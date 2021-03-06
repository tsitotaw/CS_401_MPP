package subtyping;

import java.util.Arrays;
import java.util.List;

public class CovarianceTest {

	public static void main(String[] args) {
		// primitive check
		int num1 = 1;		
		Number num2 = num1; // this will work as Number is a supertype of int
		
		Manager man1 = new Manager();
		Employee emp1 = man1; // this is just fine
				
		//arrays
		Integer[] numsI = {2,3,4};
		
		Number[] nums2 = numsI; // wrapper class of built in variable arrays works as well
		
		Manager[] mana = {new Manager()};
		Employee[] empa = mana; // this is also just fine - array subclass assignment works great
		
		List<Manager> manager1 = Arrays.asList(new Manager(), new Manager());		
		//List<Employee> employee1 = manager1; // this is not possible - type mismatch
		
		/**
		 * but we can make it work by extending the type argument - using the wildcard operator
		 */
		List<? extends Employee> employee1 = manager1; // we call this upper bound
		
		/**
		 * The following will not work because Employee is the lowest level (bound) possible - Manager is one level down
		 */
		//List<? super Employee> employee2 = manager1; // we call this lower bound
		
		/**
		 * but we can assign Employee to a Manager using the super expression
		 */
		List<Employee> empList = Arrays.asList(new Employee(), new Employee());	
		List<? super Manager> manager = empList; // we call this lower bound
		
	}

}


