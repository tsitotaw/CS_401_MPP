package part1;

public class DecoyDuck extends Duck {
	public DecoyDuck() {
		quackBehavior = new MuteQuack();
		ﬂyBehavior = new CannotFly();
	}

	public void display() {
		System.out.println("I’m a Decoy Duck");
	}
}
