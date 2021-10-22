package exercise4;

import java.util.Arrays;
import java.util.List;

public class CountWordsGood {

	public static void main(String[] args) {
		CountWordsGood cwg = new CountWordsGood();
		System.out.println("The result of Count Words is " + cwg.countWords(Arrays.asList("car", "cdt", "dog", "cod", "cat2"), 'c', 'd', 3));
	}
	
	public int countWords(List<String> words, char c, char d, int len) {
		
		return (int) words.stream()
			.filter(x -> x.length() == len)
			.filter(x -> x.contains(""+c))
			.filter(x -> !x.contains(""+d))
			.count();
		
		//return 1;
	}

}
