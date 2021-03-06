package Final.prob1.exam;
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
//		  List<CheckoutRecordEntry> entries = record.getCheckoutEntries();
//		  for(CheckoutRecordEntry entry: entries) {
//			  if(entry.getCopy() == null && entry.getDueDate().isBefore(LocalDate.now())) {
//				  return true;
//			  }
//		  }
//		  return false;
		  
//		  Optional<CheckoutRecordEntry> bools = record.getCheckoutEntries().stream()
//		  	.filter(entry -> entry.getDueDate().isBefore(LocalDate.now()))
//		  	.filter(entry-> !entry.getCopy().isAvailable())
//		  	.findAny();
//		  return (bools.isPresent()) ? true : false;
		
		  
		 return record.getCheckoutEntries().stream()
		  	.anyMatch(entry -> entry.getDueDate().isBefore(LocalDate.now()) && !entry.getCopy().isAvailable());
		  	//.filter(entry-> !entry.getCopy().isAvailable())
		  	//.findAny();
		//return MyLambdaLib.BOOK_OVERDUE.test(record);
		  
		  
          //return LambdaLibrary.OVERDUEBOOK.test(record); //implement
	}
	
	//Query B (for Problem 1B) Given a BookCopy copy and a LibraryMember mem,
	//return true if mem has ever checked out this copy
	//
	public static boolean everCheckedOutBy(LibraryMember mem, BookCopy copy) {
		
		return MyLambdaLib.EVER_CHECKOUT_BOOK.test(mem, copy);
		//return LambdaLibrary.EVERCHECKEDOUT.test(mem, copy); //implement
          
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
		
		return MyLambdaLib.NEVER_CHECK_OUT.apply(list);
	}
	
	
	

}
