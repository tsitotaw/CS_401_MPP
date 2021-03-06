package exceptions_practice;

import java.util.function.Function;

public interface FunctionWithException<T, R> {
	R apply(T t) throws Exception;
	
	public static <T,R> Function<T, R> wrapper(FunctionWithException<T, R> f){
		return x -> {
			try {
				return f.apply(x);
			}catch(Exception e) {
				throw new RuntimeException("Exception thrown");
			}
		};
	}
}
