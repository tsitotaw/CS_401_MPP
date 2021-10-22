package helperclasses;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** 
 * Immutable
 * Cannot replace CheckoutRecord with a simple List of CheckoutRecordEntries
 * because doing so would make it impossible to guarantee immutability.
 */
final public class CheckoutRecord implements Serializable {
	private static final long serialVersionUID = -3119855589946373695L;
	public CheckoutRecord() {}
	private ArrayList<CheckoutRecordEntry> entries = new ArrayList<>();
	
	public void addEntry(CheckoutRecordEntry c) {
		entries.add(c);
		
	}
	public CheckoutRecord(ArrayList<CheckoutRecordEntry> entries) {
		this.entries = entries;
	}
	
	public String toString() {
		return entries.toString();
	}
	public List<CheckoutRecordEntry> getCheckoutRecordEntries() {
		return Collections.unmodifiableList(entries);
	}
}
