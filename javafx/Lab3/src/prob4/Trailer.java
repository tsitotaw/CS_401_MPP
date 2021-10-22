package prob4;

public class Trailer {
	
	public Trailer() {
	}
	
	public double computeRent() {
		return 500;
	}	

	@Override
	public String toString() {
		return "Trailer [rent=" + computeRent() + "]";
	}
}
