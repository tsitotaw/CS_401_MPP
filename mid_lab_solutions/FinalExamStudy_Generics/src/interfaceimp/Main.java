package interfaceimp;

public class Main {

	public static void main(String[] args) {
		IDataAccess<String, Integer> da = new DataAccess<String, Integer>("Hello", 43); 
		System.out.println(da);
	}

}
