package business;

import java.io.Serializable;
import java.time.LocalDate;

public class CheckOutEntry implements Serializable {

	private String itemNo;
	private Book book;
	private LocalDate checkOutDate;
	private LocalDate dueDate;
	
	public CheckOutEntry(Book book, LocalDate checkOutDate, LocalDate dueDate) {
		
		this.itemNo = itemNo;
		this.book = book;
		this.checkOutDate = checkOutDate;
		this.dueDate = dueDate;
	}
	
	public String getItemNo() {
		return itemNo;
	}
	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public LocalDate getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(LocalDate checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	
}
