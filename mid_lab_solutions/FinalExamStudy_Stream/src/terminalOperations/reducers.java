package terminalOperations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class reducers {
//	public static void main(String[] args) {
//
//		List<String> firstArray = Arrays.asList("Hello", "there");
//		List<String> secondArray = Arrays.asList("how", "are", "you");
//
//		System.out.println(Stream.of(firstArray, secondArray).reduce(new ArrayList<String>(), (result, next) -> {
//			List<String> newList = new ArrayList<String>(result);
//			newList.addAll(next);
//			return newList;
//		}));
//
//		Stream.of(firstArray, secondArray).reduce(new ArrayList<String>(), (result, next) -> {
//			List<String> newList = new ArrayList<String>(result);
//			newList.addAll(next);
//			return newList;
//		});
//
//	}
	public static <T> ArrayList<T> combine(Stream<ArrayList<T>> stream) {		
		return stream.reduce(new ArrayList<T>(), (result, next) -> {
			result.addAll(next);
			return result;
		});
	}
	
	public static void testCombine() {
		ArrayList<ArrayList<String>> mainList = new ArrayList<>();
		ArrayList<String> list1 = new ArrayList<String>() {
			{
				add("hello");add("there");
			}
		};
		ArrayList<String> list2 = new ArrayList<String>() {
			{
				add("goodbye");add("there");
			}
		};
		mainList.add(list1);
		mainList.add(list2);
		System.out.println(combine(mainList.stream()));
	}
	public static void main(String[] args) {
		testCombine();
	}
}
