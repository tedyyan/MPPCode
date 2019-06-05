package business;

public interface BookBizServiceInterface {

	public Book getBookByISBN(String isbn);
	public void saveBook(Book book);

	public void addCheckout(CheckRecordEntry record);
}
