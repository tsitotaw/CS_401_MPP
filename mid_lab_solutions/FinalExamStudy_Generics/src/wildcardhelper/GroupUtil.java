package wildcardhelper;

import java.util.*;

public class GroupUtil {
	
	
	public static Group<?> copyMe(Group<?> group){
//		List<?> element = group.getElements();
//		
//		Group<?> grp = new Group<?>(group.getSpecialElement(), element);
//		
//		return grp;
		return copyHelperM(group);
	}
	
	public static <T> Group<T> copyHelperM(Group<T> group){
		List<T> element = group.getElements();
		
		Group<T> grp = new Group<T>(group.getSpecialElement(), element);
		
		return grp;
	}
		
	//Fix this code
	public static Group<?> copy(Group<?> group) {
		return copyHelper(group);
	}
	
	public static <T> Group<T> copyHelper(Group<T> group) {
		List<T> elements = group.getElements();
		Group<T> grp = new Group<T>(group.getSpecialElement(), elements);
		return grp;
	}
	
	//Test using this main method
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(0,1,2,3,4);
		Group<Integer> group = new Group<>(0, list);
		System.out.println(group);
		System.out.println(GroupUtil.copy(group));
	}
}

