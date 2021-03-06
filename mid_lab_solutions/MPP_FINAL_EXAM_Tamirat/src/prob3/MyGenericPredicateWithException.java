package prob3;

import java.util.function.Predicate;

import helperclasses.LibrarySystemException;

/**
 * an generic interface that will help us catch a potential exception from one of our streams
 * @author tfisseha
 *
 * @param <T>
 */
public interface MyGenericPredicateWithException<T> {
	boolean test(T t) throws LibrarySystemException;
	
	public static <T> Predicate<T> wrapper(MyGenericPredicateWithException<T> fn){
		return x -> {
			try {
				return fn.test(x);
			}catch(LibrarySystemException ex) {
				throw new RuntimeException(ex.getMessage());
			}
		};
	}
}
