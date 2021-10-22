package part2;

public final class Triangle implements Shape{
	
	private final double base;
	private final double height;	
		
	public Triangle(double base, double height) {
		super();
		this.base = base;
		this.height = height;
	}

	public double getBase() {
		return base;
	}

	public double getHeight() {
		return height;
	}

	public double computeArea() {
		
		return 0.5 * base * height;
	}	
}
