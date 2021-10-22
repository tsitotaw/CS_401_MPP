package business;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dataaccess.Auth;

 public class CheckOutRecord implements Serializable {
	
	private static final long serialVersionUID = 5147265048973262104L;

	private LibraryMember member;
	private List<CheckOutEntry> checkOutEntrylist = new ArrayList<>();
	
	public CheckOutRecord(LibraryMember member,Book book,LocalDate checkOutDate, LocalDate dueDate) {
		CheckOutEntry checkoutentry = new CheckOutEntry(book, checkOutDate, dueDate);
		this.member = member;
		this.checkOutEntrylist.add(checkoutentry);
	}
	
	public void addCheckoutEntry(List<CheckOutEntry> checkoutentry )
	{
		this.checkOutEntrylist.addAll(checkoutentry);
	}
	public LibraryMember getMember() {
		return member;
	}
	public void setMember(LibraryMember member) {
		this.member = member;
	}
	public List<CheckOutEntry> getCheckOutEntryList() {
		return checkOutEntrylist;
	}
	public void setCheckOutEntry(List<CheckOutEntry> checkOutEntry) {
		this.checkOutEntrylist = checkOutEntry;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
