package enumcheck;
/**
 * If you expect your enums to have parameters, 
 * you need to declare a constructor and fields for those parameters.
 * @author tfisseha
 *
 */
public enum MyEnumConstants {
	LENGTH(1.0),
	WIDTH(2.0);
	
	private double val;
	private MyEnumConstants(double val) {
		this.val = val;
	}
	
	public double getVal() {
		return this.val;
	}
}
