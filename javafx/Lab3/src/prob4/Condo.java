package prob4;

public class Condo {
	private int numFloors;	
	
	public Condo(int numFloors) {
		this.numFloors = numFloors;
	}
	
	public double computeRent() {
		return 400 * this.numFloors;
	}
	
	public int getNumFloors() {
		return numFloors;
	}
	public void setNumFloors(int numFloors) {
		this.numFloors = numFloors;
	}

	@Override
	public String toString() {
		return "Condo [numFloors=" + numFloors + "]";
	}
}
