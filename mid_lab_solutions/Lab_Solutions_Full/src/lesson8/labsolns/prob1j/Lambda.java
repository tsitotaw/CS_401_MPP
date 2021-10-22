package lesson8.labsolns.prob1j;
import java.util.function.Supplier;
public class Lambda {

	public static void main(String[] args) {
		Supplier<Double> rand = () -> Math.random();
		System.out.println(rand.get());

	}

}
