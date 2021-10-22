package prob4.refactored;

public class Trailer extends Property{
	

	private static final double DEFAULT_MULTIPLIER = 1;
	private static final double DEFAULT_RENTVALUE = 500;
	
	public Trailer() {
		super(DEFAULT_MULTIPLIER, DEFAULT_RENTVALUE);
	}	

	@Override
	public String toString() {
		return "Trailer [rent=" + computeRent() + "]";
	}
}
