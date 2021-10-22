package dataaccess;

import java.time.LocalDate;
import java.util.HashMap;

import business.Address;
import business.Book;
import business.CheckOutRecord;
import business.LibraryMember;
import dataaccess.DataAccessFacade.StorageType;

public interface DataAccess { 
	public HashMap<String,Book> readBooksMap();
	public HashMap<String,User> readUserMap();
	public HashMap<String, LibraryMember> readMemberMap();
	public HashMap<String,CheckOutRecord> readCheckOutRecordMap();
	public void saveNewMember(LibraryMember member); 
	public void saveNewBook(Book book); 
	public void updateBookRecord(Book book); 
	public void saveNewCheckOutRecord(CheckOutRecord checkoutrecord);
}
