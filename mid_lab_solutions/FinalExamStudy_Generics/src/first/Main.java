package first;

public class Main {

	public static void main(String[] args) {
		SimplePair<Integer, String> myPairs = new SimplePair<>(1, "sample");
		System.out.println(myPairs.getValue());
		
		SimplePair<Integer, Integer> myPairs2 = new SimplePair<>(1, 2);
		System.out.println(myPairs2.getValue());
	}

}
