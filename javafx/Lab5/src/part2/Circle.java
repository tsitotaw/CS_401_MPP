package part2;

public final class Circle implements Shape{
	
	private final double radius;	
	
	
	public Circle(double radius) {
		this.radius = radius;
	}


	public double getRadius() {
		return radius;
	}


	public double computeArea() {
		
		return Math.PI*Math.pow(radius, 2);
	}	
}
