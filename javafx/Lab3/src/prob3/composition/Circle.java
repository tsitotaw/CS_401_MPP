package prob3.composition;

public class Circle{

	/**
	 * we have to pass 1 as a height for the cylinder, as circles don't have heights
	 * @param radius
	 */
	private static final double DEFAULT_Height = 1;
	private Cylinder cylinder;
	public Circle(double radius) {
		cylinder = new Cylinder(DEFAULT_Height, radius);
	}
	
	public double getRadius() {
		return cylinder.getRadius();
	}
	
	/**
	 * just call the superclass compute volume and all will be good
	 * note that we have set the height to 1 during our constructor instantiation
	 * @return
	 */
	public double computeArea() {
		return cylinder.computeVolume();
	}

}
