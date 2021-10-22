package part2;

public final class Rectangle implements Shape{
	private final double width;
	private final double height;
	
		
	public Rectangle(double width, double height) {
		super();
		this.width = width;
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

	public double computeArea() {
		
		return this.width * this.height;
	}	
}
