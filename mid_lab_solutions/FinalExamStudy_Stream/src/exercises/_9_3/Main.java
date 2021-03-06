package exercises._9_3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		System.out.println(listAccountSortByNameAndBalance());
	}
	
	static List<String> listAccountSortByNameAndBalance(){
		List<Account> accts = Arrays.asList(
					new Account("Tamirat", 1000, 1),
					new Account("Tom", 2000, 2),
					new Account("Samuel", 1000, 3),
					new Account("Tessema", 2000, 4),
					new Account("Peter", 1000, 5)
				);
		
		Comparator<Account> sortByBalance = Comparator.comparing(Account::getBalance, Comparator.reverseOrder());
		Comparator<Account> sortByName = Comparator.comparing(Account::getOwnerName, Comparator.reverseOrder());
		
		return accts.stream()
				.sorted(sortByBalance.thenComparing(sortByName))
				.map(a -> a.getOwnerName())
				.collect(Collectors.toList());
						
	}

}

class Account {
	private String ownerName;
	private int balance;
	private int acctId;
	
	public Account(String ownerName, int balance, int acctId) {
		super();
		this.ownerName = ownerName;
		this.balance = balance;
		this.acctId = acctId;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getAcctId() {
		return acctId;
	}

	public void setAcctId(int acctId) {
		this.acctId = acctId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(balance, ownerName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return balance == other.balance && Objects.equals(ownerName, other.ownerName);
	}

	@Override
	public String toString() {
		return " [ownerName=" + ownerName + ", balance=" + balance + ", acctId=" + acctId + "]";
	}
	
	
	
}
