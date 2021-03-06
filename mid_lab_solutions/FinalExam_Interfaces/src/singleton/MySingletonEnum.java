package singleton;

/** Threadsafe singleton implementation; eager initialization */
public enum MySingletonEnum {
	INSTANCE;
	
	private int val;
	
	private MySingletonEnum() {
	}
	
	public int getVal() {
		return val;
	}
	
	public void setVal(int val) {
		this.val = val;
	}
	
}
