package prob4.refactored;

public class Property {
	private double multiplier;
	private double rentValue;
	
	public Property(double multiplier, double rentValue) {
		this.multiplier = multiplier;
		this.rentValue = rentValue;
	}	


	public double getMultiplier() {
		return multiplier;
	}


	public void setMultiplier(double multiplier) {
		this.multiplier = multiplier;
	}


	public double getRentValue() {
		return rentValue;
	}


	public void setRentValue(double rentValue) {
		this.rentValue = rentValue;
	}


	public double computeRent() {
		return this.multiplier * this.rentValue;
	}
}
