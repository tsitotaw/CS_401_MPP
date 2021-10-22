package functional.interfaces;

/**
 * This simply is a basic java interface having only one method
 * we agreed to call such interfaces as functional interfaces
 * 
 * first-class citizens?
 * Can we use this as a Parameter? 
 * 	since it is a type, this interface can be a parameter as well as a return type
 * 
 * I guess this is the way of java bringing in functional programming into its language --- 
 * this means functional interfaces are really a tool - not the functions
 * Here in our case, the real deal must be the compare method
 * 
 * Previously, if we want to use a method, we need to instantiate a class or a class name if the method is static
 * Now, we would like to avoid this? instead call the methods without the need for object instantiation?
 * 
 * how do I do that? its default behavior will be as follows:
 * 	1 - a class will implement this interface
 *  2 - a class will override / implement the method
 *  3 - a class instance will be created
 *  4 - the function will be called from the instance
 *  
 *  or shortened by a little bit using anonymouss functions
 *  do like 
 *  	new IMyComparator<Employee, Integer>() {
 *  		@Override
 *  		public Integer compare(Employee a, Employee b) {
 *  			// implementation goes here
 *  			return 1;
 *  		}
 *  	};
 *  Can we avoid all this process now?
 *  Java is saying that lambda expression is here to help us solve the above problem - to provide an inline implementation of 
 *  the interface
 *  
 * @author tfisseha
 *
 * @param <T>
 */
@FunctionalInterface
public interface IMyComparator<T, R> {	
	R compare(T a, T b);
}
