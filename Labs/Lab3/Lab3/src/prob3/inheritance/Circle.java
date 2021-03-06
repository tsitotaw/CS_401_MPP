package prob3.inheritance;

/**
 * it doesn't really make sense to make a circle inherit from the cylinder
 * as, first of all, a circle is not a cylinder, so we are breaking a LSP principle
 * then we have to pass a default value for an external variable so that we may use the superclass code
 * we should have used composition here
 * @author tfisseha
 *
 */
public class Circle extends Cylinder{

	/**
	 * we have to pass 1 as a height for the cylinder, as circles don't have heights
	 * @param radius
	 */
	public Circle(double radius) {
		super(1, radius);
	}
	
	/**
	 * just call the superclass compute volume and all will be good
	 * note that we have set the height to 1 during our constructor instanttiation
	 * @return
	 */
	public double computeArea() {
		return this.computeVolume();
	}

}
