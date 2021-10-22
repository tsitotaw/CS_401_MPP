package prob4.refactored;

public class House  extends Property{
	private double lotSize;	
	private static final double DEFAULT_MULTIPLIER = 0.1;
	
	public House(double lotSize) {
		super(DEFAULT_MULTIPLIER, lotSize);
	}
	
	public double getLotSize() {
		return lotSize;
	}
	public void setLotSize(double lotSize) {
		this.lotSize = lotSize;
	}
	
	@Override
	public String toString() {
		return "House [lotSize=" + lotSize + "]";
	}
}
