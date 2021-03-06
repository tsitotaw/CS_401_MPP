package interfaceimp;

public class DataAccess<T, C> implements IDataAccess<T, C> {

	private T tVal;
	private C cVal;
	
	public DataAccess(T tVal, C cVal) {
		super();
		this.tVal = tVal;
		this.cVal = cVal;
	}

	@Override
	public T getConnection(C c) {
		return tVal;
	}

	public T gettVal() {
		return tVal;
	}

	public void settVal(T tVal) {
		this.tVal = tVal;
	}

	public C getcVal() {
		return cVal;
	}

	public void setcVal(C cVal) {
		this.cVal = cVal;
	}

	@Override
	public String toString() {
		return "DataAccess [tVal=" + tVal + ", cVal=" + cVal + "]";
	}
	
	

}
