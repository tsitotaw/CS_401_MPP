package prob4.refactored;

public class Condo extends Property{
	private double numFloors;	
	private static final double DEFAULT_MULTIPLIER = 400;
	
	public Condo(double numFloors) {
		super(DEFAULT_MULTIPLIER, numFloors);
	}
	
	public double computeRent() {
		return 400 * this.numFloors;
	}
	
	public double getNumFloors() {
		return numFloors;
	}
	public void setNumFloors(double numFloors) {
		this.numFloors = numFloors;
	}

	@Override
	public String toString() {
		return "Condo [numFloors=" + numFloors + "]";
	}
}
