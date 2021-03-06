package foreach;

import java.util.ArrayList;
import java.util.List;

import lesson7_excercise1.StringList;

public class ListInfo {
	List<String> list = new ArrayList<>();
	MyStringList strList = new MyStringList();
	public static void main(String[] args) {
		ListInfo li = new ListInfo();
		li.process();
		
	}
	
	public void process() {
		list.add("A");
		list.add("W");
		list.add("K");
		list.add("C");
		
		//use java8 foreach to copy all list elements into the array
		list.forEach(l -> { strList.add(l); });
		
		strList.forEach(System.out::println);
	}
}
