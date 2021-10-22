package enums;

public enum AnEnum {
	INST1(3) {public void modify() {val++;}}, 
	INST2(3) {public void modify() {val = val*2;}},
	INST3("Home Away") {
		public void modify() {
			str += " Hospital";
		}
	};
	
	int val = 0;
	String str = "";
	AnEnum(int x) {
		val = x;
	}
	AnEnum(String x) {
		str = x;
	}
	public int val()  {
		return val;
	}
	
	public String str()  {
		return str;
	}
	abstract public void modify();
	
}
