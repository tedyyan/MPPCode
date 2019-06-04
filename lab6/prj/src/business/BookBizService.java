package business;

import java.util.Arrays;
import java.util.HashMap;

import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;

public class BookBizService implements BookBizServiceInterface{

	private BookBizService() {
		// TODO Auto-generated constructor stub
	}
	
	private final static BookBizService BOOK_BIZ_SERVICE = new BookBizService();
	public static BookBizServiceInterface getBookBizServiceInstance() {
		return BOOK_BIZ_SERVICE;
	}
	
	@Override
	public Book getBookByISBN(String isbn) {
		// TODO Auto-generated method stub
		DataAccess dataAccess = new DataAccessFacade();
		HashMap<String,Book> booksMap = dataAccess.readBooksMap();
		if(booksMap == null) {
			System.out.println("dataAccess.readBooksMap() is null");
			return null;
		}
		Book book = booksMap.get(isbn);
		return book;
	}

}
