package dataaccess;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import business.Book;
import business.BookCopy;
import business.LibraryMember;
import dataaccess.DataAccessFacade.StorageType;
import utility.OSinfo;

public class DataAccessFacade implements DataAccess {
	
	public static void initializeApp() {
		DataAccessFacade tmp = new DataAccessFacade();
		StorageType type = StorageType.USERS;
		Path path = FileSystems.getDefault().getPath(OUTPUT_DIR1, type.toString());
		File f = path.toFile();
		if(!f.exists()) {
			TestData td = new TestData();
			td.bookData();
			td.libraryMemberData();
			td.userData();
			td.checkoutAbook(tmp.readBooksMap().get("23-11451"),tmp.readMemberMap().get("1002"),new Date(0));
			td.checkoutAbook(tmp.readBooksMap().get("28-12331"),tmp.readMemberMap().get("1003"),new Date(0));
		}
	}
	enum StorageType {
		BOOKS, MEMBERS, USERS;
	}
/*
	public static final String OUTPUT_DIR = System.getProperty("user.dir") + "\\src\\dataaccess\\storage";
	public static final String OUTPUT_DIR1 = System.getProperty("user.dir")
			+ (OSinfo.isMacOSX() ? "/src/dataaccess/storage" : "\\src\\dataaccess\\storage");
*/
	public static final String OUTPUT_DIR = System.getProperty("user.dir");
	public static final String OUTPUT_DIR1 = System.getProperty("user.dir");
	
	public static final String DATE_PATTERN = "MM/dd/yyyy";

	// implement: other save operations
	public void saveNewMember(LibraryMember member) {
		HashMap<String, LibraryMember> mems = readMemberMap();
		String memberId = member.getMemberId();
		if (mems!=null)
			mems.put(memberId, member);
		else
			mems = new HashMap<String, LibraryMember>();
		saveToStorage(StorageType.MEMBERS, mems);
	}

	public void saveNewBook(Book book) {
		HashMap<String, Book> books = readBooksMap();

		books.put(book.getIsbn(), book);
		saveToStorage(StorageType.BOOKS, books);
	}

	@SuppressWarnings("unchecked")
	public HashMap<String, Book> readBooksMap() {
		// Returns a Map with name/value pairs being
		// isbn -> Book

		return (HashMap<String, Book>) readFromStorage(StorageType.BOOKS);
	}

	@SuppressWarnings("unchecked")
	public HashMap<String, LibraryMember> readMemberMap() {
		// Returns a Map with name/value pairs being
		// memberId -> LibraryMember
		return (HashMap<String, LibraryMember>) readFromStorage(StorageType.MEMBERS);
	}
	
	@SuppressWarnings("unchecked")
	public void removeMemberMap(String id) {
		HashMap<String, LibraryMember> a = (HashMap<String, LibraryMember>) readFromStorage(StorageType.MEMBERS);
		a.remove(id);
		saveToStorage(StorageType.MEMBERS, a);
		return ;
	}

	@SuppressWarnings("unchecked")
	public HashMap<String, User> readUserMap() {
		// Returns a Map with name/value pairs being
		// userId -> User
		return (HashMap<String, User>) readFromStorage(StorageType.USERS);
	}

	///// load methods - these place test data into the storage area
	///// - used just once at startup
	// static void loadMemberMap(List<LibraryMember> memberList) {

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

	static void loadMemberMap(List<LibraryMember> memberList) {
		HashMap<String, LibraryMember> members = new HashMap<String, LibraryMember>();
		memberList.forEach(member -> members.put(member.getMemberId(), member));
		saveToStorage(StorageType.MEMBERS, members);
	}

	static void saveToStorage(StorageType type, Object ob) {
		ObjectOutputStream out = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR1, type.toString());
			out = new ObjectOutputStream(Files.newOutputStream(path));
			out.writeObject(ob);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (Exception e) {
				}
			}
		}
	}

	static Object readFromStorage(StorageType type) {
		ObjectInputStream in = null;
		Object retVal = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR1, type.toString());
			in = new ObjectInputStream(Files.newInputStream(path));
			retVal = in.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (Exception e) {
				}
			}
		}
		return retVal;
	}

	final static class Pair<S, T> implements Serializable {

		S first;
		T second;

		Pair(S s, T t) {
			first = s;
			second = t;
		}

		@Override
		public boolean equals(Object ob) {
			if (ob == null)
				return false;
			if (this == ob)
				return true;
			if (ob.getClass() != getClass())
				return false;
			@SuppressWarnings("unchecked")
			Pair<S, T> p = (Pair<S, T>) ob;
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
