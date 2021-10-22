package helperclasses;

public class CheckingAccount extends Account {
	private double penalty;
	public CheckingAccount(int id, double startBal, double penalty) {
		super(id, startBal);
		this.penalty = penalty;
	}
	@Override
	public double getBalance() {
		return super.getBalance() - penalty;
	}
}
