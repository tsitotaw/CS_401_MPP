package lesson7.labsolns.prob4;

public interface Squeakable extends Quackable {
	default void quack() {
		System.out.println("   squeaking");
	}
}
