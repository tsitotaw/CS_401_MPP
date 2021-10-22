package lesson7.labsolns.prob4;

public interface Quackable {
	default void quack() {
		System.out.println("  quacking");
	}
}
