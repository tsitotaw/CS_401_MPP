package lesson7.exercise_1;

public interface StringList {
		
	String[] strArray();
	int size();
	void incrementSize();
	
	
	/** Gets the i_th string in the list */
	public String get(int i);
	
	default public void add(String s) {
		strArray()[size()] = s;
		incrementSize();
	}
	
}
