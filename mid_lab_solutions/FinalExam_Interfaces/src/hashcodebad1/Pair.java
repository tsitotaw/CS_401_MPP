package hashcodebad1;

import java.util.Objects;

public class Pair {
	String first;
	String second;
	public Pair(String f, String s) {
		first = f;
		second = s;
	}
	@Override
	public int hashCode() {
		return Objects.hash(first, second);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pair other = (Pair) obj;
		return Objects.equals(first, other.first) && Objects.equals(second, other.second);
	}
	
	
	

}
