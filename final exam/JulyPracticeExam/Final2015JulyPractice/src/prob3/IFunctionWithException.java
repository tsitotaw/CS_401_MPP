package prob3;

import java.util.function.Function;

public interface IFunctionWithException<T,R> {

	R apply(T t) throws IllegalWordException;
	
	public static <T, R> Function<T,R> wrapper(IFunctionWithException<T,R> f){
		return x -> {
			try{
				return f.apply(x);
			}catch(IllegalWordException ex) {
				throw new RuntimeException(ex.getMessage());
			}
		};
	}
}
