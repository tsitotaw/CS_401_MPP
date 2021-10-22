package enums;

public class MyLabel {

	public static void main(String[] args) {
		display(Size.LARGE);
	}
	
	public static void display(Size size) {
		switch(size) {
		case LARGE:
			System.out.println("Large");
			System.out.println(Size.values());
			break;
		case MEDIUM:
			System.out.println("Medium");
			break;
		default:
			System.out.println("Small");
			break;
		}
	}

}
