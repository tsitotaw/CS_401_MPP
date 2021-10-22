package Final.prob1.sample;
import java.util.*;
import java.util.function.Function;
public class LambdaLibrary {
	public static final Function<List<String>, String> SHORTEST =
		list ->	list.stream().min(Comparator.comparing(str -> str.length())).get();
}
