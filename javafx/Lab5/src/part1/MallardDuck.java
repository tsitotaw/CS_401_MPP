package part1;

public class MallardDuck extends Duck {
	public MallardDuck() {
		quackBehavior = new Quack();
		ﬂyBehavior = new FlyWithWings();
	}

	public void display() {
		System.out.println("displaying");
	}
}
