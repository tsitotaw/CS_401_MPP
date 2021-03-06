package prob1;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
public class Main {

	
	//Query A (for Problem 1A) given a member's checkout record, determine whether some
	//bookcopy in the record is overdue (a bookcopy is overdue if it is not available
	//and its due date is before now.
	public static boolean someBookOverdue(CheckoutRecord record) {
//		return record.getCheckoutEntries().stream()
//				.anyMatch(p -> !p.getCopy().isAvailable() && p.getDueDate().isBefore(LocalDate.now()));
		
		return MyLambdaLibrary.BOOK_OVERDUE.test(record);
	}
	
	//Query B (for Problem 1B) Given a BookCopy copy and a LibraryMember mem,
	//return true if mem has ever checked out this copy
	//
	public static boolean everCheckedOutBy(LibraryMember mem, BookCopy copy) {
//		return mem.getRecord().getCheckoutEntries().stream()
//				.anyMatch(e -> 
//							e.getCopy().getBook().getIsbn().equals(copy.getBook().getIsbn()) &&  e.getCopy().getCopyNumber() == copy.getCopyNumber()
//						);
		return MyLambdaLibrary.EVER_CHECK_OUT.test(mem, copy);
	}
	
	//Query C (for Problem 1C) given a list of all library members, return a list, in
	//reverse sorted order (by first name), of the
	//full names of those library members who have never checked out a book
	public static List<String> nonActiveMembers(List<LibraryMember> list) {
//		return list.stream()
//		.filter(m -> m.getRecord().getCheckoutEntries().size() < 1)
//		.sorted(Comparator.comparing(LibraryMember::getFirstName, Comparator.reverseOrder()))
//		.map(m -> m.getFirstName().concat(" ").concat(m.getLastName()))
//		.collect(Collectors.toList());
		
		return MyLambdaLibrary.NEVER_CHECK_OUT_LIBRARY_MEMBERS.apply(list);
	}
	
	
	

}
