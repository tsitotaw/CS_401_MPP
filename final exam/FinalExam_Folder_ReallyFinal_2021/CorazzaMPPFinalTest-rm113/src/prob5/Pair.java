package prob5;

public class Pair<S,T> {
	public S first;
	public T second;
	public Pair(S s, T t) {
		first = s;
		second = t;
	}
	
	@Override
	public String toString() {
		return "(" + first.toString() + ", " + second.toString() + ")";
	}
	
	@Override
	public boolean equals(Object ob) {
		if(ob == null) return false;
		if(ob.getClass() != getClass()) return false;
		Pair p = (Pair)ob;
		return p.first.equals(first) && p.second.equals(second);
	}
}
