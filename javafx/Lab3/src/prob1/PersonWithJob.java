package prob1;

/**
 * honestly I am not sure why that was failing --- couldn't figure it out
 * even comparing same instance is returning false;
 * need to explore more
 * @author tfisseha
 *
 */
public class PersonWithJob {
	
	private double salary;
	private Person person;
	
	public double getSalary() {
		return salary;
	}
	
	public String getName() {
		return person.getName();
	}
	public Person getPerson() {
		return this.person;
	}
	
	PersonWithJob(String n, double s) {
		person = new Person(n);
		salary = s;
	}
	
	@Override
	public boolean equals(Object aPerson) {
		if(aPerson == null) return false; 
		if(!(aPerson instanceof PersonWithJob)) return false;
		PersonWithJob p = (PersonWithJob)aPerson;
		boolean isEqual = this.getName().equals(p.getName()) &&
				this.getSalary()==p.getSalary();
		return isEqual;
	}
	public static void main(String[] args) {
		Person p1 = new PersonWithJob("Joe", 30000).getPerson();
		Person p2 = new Person("Joe");
		//As PersonsWithJobs, p1 should be equal to p2
		System.out.println("p1.equals(p2)? " + p1.equals(p2));
		System.out.println("p2.equals(p1)? " + p2.equals(p1));
	}


}
