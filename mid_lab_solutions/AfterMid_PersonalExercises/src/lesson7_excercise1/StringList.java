package lesson7_excercise1;

public interface StringList {
		
	String[] strArray();
	int size();
	void incrementSize();
	
	
	/** Gets the i_th string in the list */
	//public String get(int i);
	
	default public void add(String s) {
		strArray()[size()] = s;
		incrementSize();
	}
	
	default public String get(int i) {
		if (i < 0 || i >= size()) {
			return null;
		}
		return strArray()[i];
	}
	
}
