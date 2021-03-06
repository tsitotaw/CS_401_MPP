package exercise_7_2;

public class Constants {
	public static final String COMPANY = "Microsoft";
	public static final int SALES_TARGET = 20000000;
}

enum Constants_Enum {
	COMPANY("Microsoft"),
	SALES_TARGET(20000000);
	
	double val;
	String str;
	private Constants_Enum(String str) {
		this.str = str;
	}
	
	private Constants_Enum(double val) {
		this.val = val;
	}
	
	public double getVal() {
		return this.val;
	}
	
	public String getStr() {
		return this.str;
	}
	
}
