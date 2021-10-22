package group13;

public class ComposedCylinder {
	private Circle circle;
	private double height;
	private double volume;
	public ComposedCylinder() {
		
		circle = new Circle(1.0);
		height = 1.0;
		volume = circle.getArea() * height;
	}

	public ComposedCylinder(double radius) {
		circle = new Circle(radius);
		
		this.height = 1.0;
		volume = circle.getArea() * height;
	}
	public ComposedCylinder(double radius, double height)
	{
		circle = new Circle(radius);
		this.height = height;
		volume = circle.getArea() * height;
		
	}
	public double getHeight()
	{
		return height;
	}
	public double getVolume()
	{
		//As setVolume is not defined, volume calculation
		//is done in constructors for performance
		return volume;
	}

}
