package enums;

public enum Size {
	SMALL("small"),
	MEDIUM("medium"),
	LARGE("large");
	
	String val;
	Size(String val) {
		this.val = val;
	}
	
	public String getVal() {
		return this.val;
	}
}
