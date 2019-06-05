package business;

import java.util.HashMap;

import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;

public class BookBizService implements BookBizServiceInterface{

	DataAccess dataAccess = new DataAccessFacade();
	
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
		
		HashMap<String,Book> booksMap = dataAccess.readBooksMap();
		if(booksMap == null) {
			System.out.println("dataAccess.readBooksMap() is null");
			return null;
		}
		Book book = booksMap.get(isbn);
		return book;
	}

	@Override
	public void saveBook(Book book) {
		// DataAccess dataAccess = new DataAccessFacade();
		dataAccess.saveNewBook(book);
	}

	@Override
	public void addCheckout(CheckRecordEntry record) {
		// TODO Auto-generated method stub
//		dataAccess.addCheckRecord(record);
	}

}
