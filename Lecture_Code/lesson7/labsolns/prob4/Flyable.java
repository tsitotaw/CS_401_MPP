package lesson7.labsolns.prob4;

public interface Flyable {
	default void fly() {
		System.out.println("  flying");
	}
}
