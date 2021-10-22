package functional.interfaces;

/**
 * this is another type of functional interface called Consumer
 * it will have no return type but have one parameter
 * 
 * whenever we want to implement a lambda function that do not return any type but recieve one argument,
 * we can use this interface as its type
 * 
 * @author tfisseha
 *
 * @param <T>
 */
@FunctionalInterface
public interface MyConsumer<T> {
	void accept(T t);
}
