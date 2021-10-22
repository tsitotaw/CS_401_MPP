package group13;

public class InheritedCylinder extends Circle {
	private double height;
	private double volume;
	public InheritedCylinder() {
		
		super(1.0);
		height = 1.0;
		volume = getArea() * height;
	}

	public InheritedCylinder(double radius) {
		super(radius);
		
		this.height = 1.0;
		volume = getArea() * height;
	}
	public InheritedCylinder(double radius, double height)
	{
		super(radius);
		this.height = height;
		volume = getArea() * height;
		
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
