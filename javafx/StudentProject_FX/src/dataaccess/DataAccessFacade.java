package dataaccess;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import business.Address;
import business.Book;
import business.BookCopy;
import business.CheckOutRecord;
import business.LibraryMember;
import dataaccess.DataAccessFacade.StorageType;


public class DataAccessFacade implements DataAccess {
	
	enum StorageType {
		BOOKS, MEMBERS, USERS,CHECKOUTRECORD
	}
	
	public static final String OUTPUT_DIR = System.getProperty("user.dir") 
			+ "/src/dataaccess/storage";
	public static final String DATE_PATTERN = "MM/dd/yyyy";
	
	//implement: other save operations for members
	public void saveNewMember(LibraryMember member) {
		HashMap<String, LibraryMember> mems = readMemberMap();
		String memberId = member.getMemberId();
		mems.put(memberId, member);
		saveToStorage(StorageType.MEMBERS, mems);	
	}
	//implement: other save operations for book
	public void saveNewBook(Book book) {
		HashMap<String, Book> bo = readBooksMap();
		String bookId = book.getIsbn();
		bo.put(bookId, book);
		saveToStorage(StorageType.BOOKS, bo);	
	}
	
	public void updateBookRecord(Book book) {
		
		HashMap<String, Book> bo = readBooksMap();
		
		Book orginaltbook = bo.get(book.getIsbn());
		
		BookCopy bookcopy = book.getNextAvailableCopy();
		bookcopy.changeAvailability(false);
		
		orginaltbook.updateCopies(bookcopy);
		
		bo.put(book.getIsbn(), orginaltbook);
		saveToStorage(StorageType.BOOKS, bo);	
	}
		
	public void saveNewCheckOutRecord(CheckOutRecord checkoutrecord) {
		HashMap<String, CheckOutRecord> co = readCheckOutRecordMap();
		CheckOutRecord checkout = co.get(checkoutrecord.getMember().getMemberId());
		checkout.addCheckoutEntry(checkoutrecord.getCheckOutEntryList());
		
		String memberId = checkoutrecord.getMember().getMemberId();
		
		co.put(memberId, checkout);
		saveToStorage(StorageType.CHECKOUTRECORD, co);	
		
		
		
	}
	
	@SuppressWarnings("unchecked")
	public  HashMap<String,Book> readBooksMap() {
		return (HashMap<String,Book>) readFromStorage(StorageType.BOOKS);
	}
	
	@SuppressWarnings("unchecked")
	public HashMap<String, LibraryMember> readMemberMap() {
		return (HashMap<String, LibraryMember>) readFromStorage(
				StorageType.MEMBERS);
	}
	
	
	@SuppressWarnings("unchecked")
	public HashMap<String, User> readUserMap() {
		return (HashMap<String, User>)readFromStorage(StorageType.USERS);
	}

	@SuppressWarnings("unchecked")
	public HashMap<String, CheckOutRecord> readCheckOutRecordMap() {
		return (HashMap<String, CheckOutRecord>)readFromStorage(StorageType.CHECKOUTRECORD);
	}
	
	/////load methods - these place test data into the storage area
	///// - used just once at startup  
	
		
	static void loadBookMap(List<Book> bookList) {
		HashMap<String, Book> books = new HashMap<String, Book>();
		bookList.forEach(book -> books.put(book.getIsbn(), book));
		saveToStorage(StorageType.BOOKS, books);
	}
	
	static void loadUserMap(List<User> userList) {
		HashMap<String, User> users = new HashMap<String, User>();
		userList.forEach(user -> users.put(user.getId(), user));
		saveToStorage(StorageType.USERS, users);
	}
	
	static void loadCheckOutRecordMap(List<CheckOutRecord> checkOutRecordList) {
		HashMap<String, CheckOutRecord> checkOutRecords = new HashMap<String, CheckOutRecord>();
		checkOutRecordList.forEach(checkOutRecord -> checkOutRecords.put(checkOutRecord.getMember().getMemberId() , checkOutRecord));
		saveToStorage(StorageType.CHECKOUTRECORD, checkOutRecords);
	}
	
	 static  void loadMemberMap(List<LibraryMember> memberList) {
		HashMap<String, LibraryMember> members = new HashMap<String, LibraryMember>();
		memberList.forEach(member -> members.put(member.getMemberId(), member));
		saveToStorage(StorageType.MEMBERS, members);
	}
	
	static void saveToStorage(StorageType type, Object ob) {
		ObjectOutputStream out = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, type.toString());
			out = new ObjectOutputStream(Files.newOutputStream(path));
			out.writeObject(ob);
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			if(out != null) {
				try {
					out.close();
				} catch(Exception e) {}
			}
		}
	}
	
	static Object readFromStorage(StorageType type) {
		ObjectInputStream in = null;
		Object retVal = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, type.toString());
			in = new ObjectInputStream(Files.newInputStream(path));
			retVal = in.readObject();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(in != null) {
				try {
					in.close();
				} catch(Exception e) {}
			}
		}
		return retVal;
	}
	
	
	
	final static class Pair<S,T> implements Serializable{
		
		S first;
		T second;
		Pair(S s, T t) {
			first = s;
			second = t;
		}
		@Override 
		public boolean equals(Object ob) {
			if(ob == null) return false;
			if(this == ob) return true;
			if(ob.getClass() != getClass()) return false;
			@SuppressWarnings("unchecked")
			Pair<S,T> p = (Pair<S,T>)ob;
			return p.first.equals(first) && p.second.equals(second);
		}
		
		@Override 
		public int hashCode() {
			return first.hashCode() + 5 * second.hashCode();
		}
		@Override
		public String toString() {
			return "(" + first.toString() + ", " + second.toString() + ")";
		}
		private static final long serialVersionUID = 5399827794066637059L;
	}
	
}
