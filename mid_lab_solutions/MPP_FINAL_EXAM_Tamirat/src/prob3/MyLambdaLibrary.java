package prob3;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import helperclasses.Book;
import helperclasses.LibraryMember;

/**
 * A lambda library
 * my helper lambda library which will call our predicate exception function to catch and throw an exception
 * @author tfisseha
 */
public class MyLambdaLibrary {

	public static LibraryMember getWinnnerMember(List<LibraryMember> mems, Iterator<Book> specialBooks) {

		return mems.stream()
				.filter(MyGenericPredicateWithException.wrapper(mem -> mem
						.checkout(specialBooks.next().getNextAvailableCopy(), LocalDate.now(), LocalDate.of(2015, 9, 1))
						.getCheckoutRecordEntries().size() == 10))
				.findFirst().orElse(null);
	}
}
