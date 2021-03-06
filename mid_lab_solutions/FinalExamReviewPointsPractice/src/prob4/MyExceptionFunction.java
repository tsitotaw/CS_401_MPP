package prob4;

import java.util.function.Function;
@FunctionalInterface
public interface MyExceptionFunction<T,R> {
	
	R apply(T t) throws Exception;
	
	public static <T,R> Function<T, R> helper(MyExceptionFunction<T, R> f){
		return x -> {
			try {
				return f.apply(x);
			}catch(Exception e) {
				throw new RuntimeException("Exception thrown from my block");
			}
		};
	}
}
