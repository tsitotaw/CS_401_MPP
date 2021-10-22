package lesson7_excercise2;

public class Constants {
	public static final String COMPANY = "Microsoft";
	public static final int SALES_TARGET = 20000000;
}

enum Constants_Enum {
	COMPANY("Microsoft"),
	SALES_TARGET(20000000);
	
	Object val;
	Constants_Enum(Object val) {
		val = val;
	}
}
