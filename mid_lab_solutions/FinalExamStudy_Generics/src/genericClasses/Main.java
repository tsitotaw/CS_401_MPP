package genericClasses;

public class Main {

	public static void main(String[] args) {
		
		MyDictionary<Integer, String> dict = new MyDictionary<Integer, String>(1, "Tamirat");
		MySpecialDictionary dict2 = new MySpecialDictionary("2", "Fisseha");
		
		System.out.println(dict.getKey());
		System.out.println(dict.getValue(dict.getKey()));
		
		System.out.println(dict2.getKey());
		System.out.println(dict2.getValue(dict2.getKey()));
	}

}
