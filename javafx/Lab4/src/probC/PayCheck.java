package probC;

public final class PayCheck {
	private double grossPay;
	private double fica;
	private String state;
	private String local;
	private boolean medicare;
	private String socialSecurity;
	
	
	public PayCheck(double grossPay, double fica, String state, String local, boolean medicare, String socialSecurity) {
		this.grossPay = grossPay;
		this.fica = fica;
		this.state = state;
		this.local = local;
		this.medicare = medicare;
		this.socialSecurity = socialSecurity;
	}

	void print() {
		
	}
	
	public Double getNetPay() {
		return null;
	}
	
	public double getGrossPay() {
		return grossPay;
	}
	public double getFica() {
		return fica;
	}
	public String getState() {
		return state;
	}
	public String getLocal() {
		return local;
	}
	public boolean isMedicare() {
		return medicare;
	}
	public String getSocialSecurity() {
		return socialSecurity;
	}
	
	
}
