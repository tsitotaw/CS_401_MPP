package intermediateoperations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * usage of flatMap
 * just like map, but it will need to flatten the stream after mapping
 * @author tfisseha
 *
 */
public class flatMap {

	public static void main(String[] args) {
		//System.out.println(flatten2DIntegerArray());
		System.out.println(flatten3DIntegerArray());
	}
	
	static List<Integer> flatten2DIntegerArray() {
		Integer[][] numbers = {{1,2,34,12}, {3,4, 23,34,56}, {5,6,7,4545,567}, {78,23,56,676,34,12}};
		
		List<Integer> list= Stream.of(numbers)
			.flatMap(n -> Stream.of(n))
			.collect(Collectors.toList());
		
		return list;
	}
	
	static List<Integer> flatten3DIntegerArray() {
		Integer[][][] numbers = {{{1},{2}, {34,12}}, {{3,4}, {23,34,56}}, {{5,6,7}, {4545,567}}, {{78,23,56}, {676,34,12}}};
		
		List<Integer> list= Stream.of(numbers)
			.flatMap(n -> Stream.of(n))
			.flatMap(n -> Stream.of(n))
			.map(n -> n*56)
			.collect(Collectors.toList());
		
		return list;
	}
	static List<String> flatten3DStringArray() {
		String[][][] numbers = {{{"1"},{"2"}, {"34","12"}}, {{"3","4"}, {"23","34","56"}}, {{"5","6","7"}, {"4545","567"}}, {{"78","23","56"}, {"676","34","12"}}};
		
		List<String> list= Stream.of(numbers)
				.flatMap(n -> Stream.of(n))
				.flatMap(n -> Stream.of(n))
				//.flatMap(n -> n.stream())
				//.map(n -> n*56)
				.collect(Collectors.toList());
		
		return list;
	}

}
