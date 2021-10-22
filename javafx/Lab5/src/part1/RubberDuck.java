package part1;

public class RubberDuck extends Duck {
	public RubberDuck() {
		quackBehavior = new Quack();
		ﬂyBehavior = new CannotFly();
	}

	public void display() {
		System.out.println("displaying");
	}
}
