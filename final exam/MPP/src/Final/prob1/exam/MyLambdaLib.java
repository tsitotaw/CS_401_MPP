package Final.prob1.exam;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MyLambdaLib {
	/**
	 * Optional<CheckoutRecordEntry> bools = record.getCheckoutEntries().stream()
	 * .filter(entry -> entry.getDueDate().isBefore(LocalDate.now()))
	 * .filter(entry-> !entry.getCopy().isAvailable()) .findAny()
	 */
	public static Predicate<CheckoutRecord> BOOK_OVERDUE = record -> record.getCheckoutEntries().stream()
			.filter(entry -> entry.getDueDate().isBefore(LocalDate.now()))
			.filter(entry -> !entry.getCopy().isAvailable()).count() > 0;

	public static BiPredicate<LibraryMember, BookCopy> EVER_CHECKOUT_BOOK = (mem, copy) -> mem.getRecord()
			.getCheckoutEntries().stream().filter(entry -> entry.getCopy().equals(copy)).count() > 0;

	public static Function<List<LibraryMember>, List<String>> NEVER_CHECK_OUT = list -> list.stream()
			.filter(m -> m.getRecord().getCheckoutEntries().size() < 1)
			.sorted(Comparator.comparing(LibraryMember::getFirstName, Comparator.reverseOrder()))
			.map(m -> m.getFirstName().concat(" ").concat(m.getLastName())).collect(Collectors.toList());
}
