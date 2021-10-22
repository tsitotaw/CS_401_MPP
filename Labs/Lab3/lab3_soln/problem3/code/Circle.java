package group13;
/**
 * 
 */

/**
 * @author Group13
 *
 */
public class Circle {
	//Attributes
	private double radius;
	private String color;
	private double area;
	//Constructors
	//Default Constructor
	Circle()
	{
		radius = 1.0;
		color = "red";
		area = Math.PI;
	}
	
	Circle(double radius)
	{
		this.radius = radius;
		color = "red";
		area = Math.PI * radius * radius;
	}
	public double getRadius()
	{
		return radius;
	}
	public double getArea()
	{
		//As setArea is not there, 
		//for performance, area is calculated in 
		//constructors itself.
		return area;
	}
	
	public String toString()
	{
		return "Circle:Radius=" + radius + " Area=" + area + " color=" + color;
		
	}
	

}
