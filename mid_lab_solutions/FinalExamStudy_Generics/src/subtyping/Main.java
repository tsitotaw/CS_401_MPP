package subtyping;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		Integer[] numsI = { 2, 3, 4 };

		Number[] nums2 = {2,3,4};//numsI;
		nums2[2] = 1.8;
		
		System.out.println(Arrays.toString(numsI));
		System.out.println(Arrays.toString(nums2));
		
		List<Manager> manager = Arrays.asList(new Manager());
		//List<Employee> emp = manager;
	}

}
