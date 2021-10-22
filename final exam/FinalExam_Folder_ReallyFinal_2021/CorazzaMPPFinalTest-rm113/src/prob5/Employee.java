package prob5;

public class Employee {
	private String name;
	private int salary;
	public Employee(String n, int s) {
		this.name = n;
		this.salary = s;
	}
	public int getSalary() {
		return salary;
	}
	public String getName() {
		return name;
	}
	
	@Override 
	public String toString() {
		return "(" + name + ":" + salary + ")";
	}
	
}

