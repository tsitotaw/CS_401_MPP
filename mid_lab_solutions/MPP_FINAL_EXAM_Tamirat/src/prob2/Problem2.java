package prob2;

import helperclasses.CheckoutRecordEntry;
import helperclasses.TestData;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Print to the console the list of book titles � in sorted order -- 
 * for which the book was checked out on June 27, 2015. 
 * The ordering of the book titles is as follows: First sort by the length 
 * of the title (number of characters), then by alphabetical order.  
 */
public class Problem2 {

	public static void main(String[] args) {
		List<CheckoutRecordEntry> list = TestData.INSTANCE.getAllEntries();
		
		System.out.println(
				list.stream()
					.filter(e -> e.getCheckoutDate().isEqual(LocalDate.of(2015, 6, 27)))
					.map(e -> e.getCopy().getBook().getTitle())
					.sorted(Comparator.comparing(String::length).thenComparing(Comparator.comparing(String::toString)))
					.collect(Collectors.toList())
				);
	}

}
