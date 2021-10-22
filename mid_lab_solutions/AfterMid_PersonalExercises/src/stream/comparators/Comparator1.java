package stream.comparators;

public class Comparator1 {

	public static void main(String[] args) {
		// Implementing Comparators with More Functional Style
		
		
	}

}

class Employee {
	private String name;
	
	public Employee(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	

	@Override
	public String toString() {
		return "Employee [name=" + name + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		return super.equals(obj);
	}
	
	
	
}
