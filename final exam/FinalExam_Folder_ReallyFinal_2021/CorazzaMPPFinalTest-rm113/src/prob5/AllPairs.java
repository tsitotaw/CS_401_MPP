package prob5;
import java.util.*;

public class AllPairs {
	public static List<Pair<Integer, Integer>> allIncreasingPairs(List<Integer> list) {
		List<Pair<Integer, Integer>> returnVal = new ArrayList<>();
		for(int x: list) {
			for(int y: list) {
				if(x < y) {
					Pair<Integer, Integer> p = new Pair<>(x,y);
					returnVal.add(p);
				}
			}
		}
		return returnVal;
	}
	
	//should work for string, Employees, LocalDates
}
