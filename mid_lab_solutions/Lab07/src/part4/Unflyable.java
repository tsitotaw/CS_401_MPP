package part4;

public interface Unflyable extends Flyable {
	default void fly() {
		System.out.println("  cannot fly");
	}
}
