package lesson9.labsolns.prob12;
import java.util.Optional;
public class MySingletonOfNullable {
	private static int count = 0;
	private static MySingletonOfNullable instance = null;
	private MySingletonOfNullable() {
		count++;
	}
	//Uses ofNullable in place of null checks
	public static MySingletonOfNullable getInstance() {
		return Optional.ofNullable(instance).orElseGet(() -> setAndGet());
		//return Optional.ofNullable(instance).orElseGet(MySingletonOfNullable::setAndGet);
	}
	
	private static MySingletonOfNullable setAndGet() {
		instance = new MySingletonOfNullable();
		return instance;
	}
	
	public static void main(String[] args) {
		for(int i = 0; i < 10; ++i) {
			getInstance();
		}
		System.out.println(count);
	}
}
