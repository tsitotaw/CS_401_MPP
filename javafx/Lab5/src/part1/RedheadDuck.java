package part1;

public class RedheadDuck extends Duck {
	public RedheadDuck() {
		quackBehavior = new Quack();
		ﬂyBehavior = new FlyWithWings();
	}

	public void display() {
		System.out.println("displaying");
	}
}
