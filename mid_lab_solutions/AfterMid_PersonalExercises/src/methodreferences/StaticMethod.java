package methodreferences;

import java.util.function.Consumer;

public class StaticMethod {

	public static void main(String[] args) {
		Runnable myLambda = () -> Employee.getGreeting();
		myLambda.run();
		
		Runnable myReference = Employee::getGreeting;
		myReference.run();
	}

}

class Employee {
	
	static void getGreeting() {
		System.out.println("Welcome Employee");
	}
}
