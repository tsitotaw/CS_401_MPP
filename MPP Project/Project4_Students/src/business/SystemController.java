package business;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dataaccess.Auth;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;
import dataaccess.User;

public class SystemController implements ControllerInterface {
	public static Auth currentAuth = null;
	
	public void login(String id, String password) throws LoginException {
		DataAccess da = new DataAccessFacade();
		HashMap<String, User> map = da.readUserMap();
		if(!map.containsKey(id)) {
			throw new LoginException("ID " + id + " not found");
		}
		String passwordFound = map.get(id).getPassword();
		if(!passwordFound.equals(password)) {
			throw new LoginException("Password incorrect");
		}
		currentAuth = map.get(id).getAuthorization();
		
	}
	@Override
	public List<String> allMemberIds() {
		DataAccess da = new DataAccessFacade();
		List<String> retval = new ArrayList<>();
		retval.addAll(da.readMemberMap().keySet());
		return retval;
	}
	
	@Override
	public List<String> allBookIds() {
		DataAccess da = new DataAccessFacade();
		List<String> retval = new ArrayList<>();
		retval.addAll(da.readBooksMap().keySet());
		return retval;
	}
	
	@Override
	public List<Book> allBooks() {
		DataAccess da = new DataAccessFacade();
		List<Book> retval = new ArrayList<>();
		retval.addAll(da.readBooksMap().values());
		return retval;
	}
	
	@Override
	public HashMap<String,Book> allBooksHashmap() {
		DataAccess da = new DataAccessFacade();
		return da.readBooksMap();
	}
	
	@Override
	public HashMap<String,LibraryMember> allLibraryMembersHashmap() {
		DataAccess da = new DataAccessFacade();
		return da.readMemberMap();
	}
	
	@Override
	public HashMap<String,CheckOutRecord> allCheckOutRecordsHashmap() {
		DataAccess da = new DataAccessFacade();
		return da.readCheckOutRecordMap();
	}
	

	@Override
	public List<LibraryMember> allLibraryMembers() {
		DataAccess da = new DataAccessFacade();
		List<LibraryMember> retval = new ArrayList<>();
		retval.addAll(da.readMemberMap().values());
		return retval;
	}
	@Override
	public void saveNewMembercontroller(LibraryMember member) {
		DataAccess da = new DataAccessFacade();
		da.saveNewMember(member);
	}
	
	@Override
	public void saveNewBookcontroller(Book book) {
		DataAccess da = new DataAccessFacade();
		da.saveNewBook(book);
	}
	
	@Override
	public void saveNewCheckOutRecordcontroller(CheckOutRecord checkoutrecord) {
		DataAccess da = new DataAccessFacade();
		da.saveNewCheckOutRecord(checkoutrecord);
	}
	
	@Override
	public void updateBookcontroller(Book book) {
		DataAccess da = new DataAccessFacade();
		da.updateBookRecord(book);
	}
}

