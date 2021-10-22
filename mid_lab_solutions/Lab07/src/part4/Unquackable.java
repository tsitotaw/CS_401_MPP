package part4;

public interface Unquackable extends Quackable {
	default void quack() {
		System.out.println("  cannot quack");
	}
}
