package prob1;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MyLambdaLibrary {
	
	public static final Predicate<CheckoutRecord> BOOK_OVERDUE = (record) -> record.getCheckoutEntries().stream()
			.anyMatch(p -> !p.getCopy().isAvailable() && p.getDueDate().isBefore(LocalDate.now()));

	public static final BiPredicate<LibraryMember, BookCopy> EVER_CHECK_OUT = (mem, copy) -> mem.getRecord()
			.getCheckoutEntries().stream()
			.anyMatch(e -> e.getCopy().getBook().getIsbn().equals(copy.getBook().getIsbn())
					&& e.getCopy().getCopyNumber() == copy.getCopyNumber());

	public static final Function<List<LibraryMember>, List<String>> NEVER_CHECK_OUT_LIBRARY_MEMBERS = (list) -> list
			.stream().filter(m -> m.getRecord().getCheckoutEntries().size() < 1)
			.sorted(Comparator.comparing(LibraryMember::getFirstName, Comparator.reverseOrder()))
			.map(m -> m.getFirstName().concat(" ").concat(m.getLastName())).collect(Collectors.toList());
	
}
