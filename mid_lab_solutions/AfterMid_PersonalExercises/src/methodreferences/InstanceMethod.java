package methodreferences;

import java.util.function.Supplier;

public class InstanceMethod {

	public static void main(String[] args) {
		Employee2 emp = new Employee2();
		Runnable r = emp::getGreeting;
		//Runnable r = () -> new Employee2().getGreeting(); 
		r.run();
		
		Runnable r2 = new Employee2()::getGreeting;
		r2.run();
		
		Employee2 emp2 = new Employee2();
		Supplier<String> sup = emp2::getGreetingString;
		System.out.println(sup.get());
		
		//Stream<String> strm = Stream.generate(r2);
	}

}

class Employee2 {
	
	void getGreeting() {
		System.out.println(this.getGreetingString());
	}
	
	String getGreetingString() {
		return "Welcome Employee";
	}

}
