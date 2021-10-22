package lesson7.labsolns.prob4;

public interface Unflyable extends Flyable {
	default void fly() {
		System.out.println("  cannot fly");
	}
}
