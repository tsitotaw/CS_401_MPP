package part2;

public class Main {

	public static void main(String[] args) {
		
		Shape[] shapes = {
			new Circle(12),
			new Rectangle(12,34),
			new Triangle(23,45)
		};
		
		Double sumOfTotalComputedAreas = 0.0;
		for(Shape s : shapes) {
			sumOfTotalComputedAreas += s.computeArea();
		}
		
		System.out.println("Sum of Areas = " + Math.round(sumOfTotalComputedAreas));

	}

}
