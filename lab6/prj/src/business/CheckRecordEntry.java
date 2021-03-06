package business;

import java.io.Serializable;
import java.util.Date;

public class CheckRecordEntry implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7254997453769859689L;
	private Date dueDate;
	private Date checkOutDate;
	private BookCopy bookCopy;
	
	public CheckRecordEntry(Date checkOutDate, BookCopy bookCopy) {
		this.bookCopy = bookCopy;
		this.checkOutDate = checkOutDate;
	}
	public CheckRecordEntry(Date checkOutDate, BookCopy bookCopy, Date dueDate) {
		this.checkOutDate = checkOutDate;
		this.bookCopy = bookCopy;
		this.dueDate = dueDate;
	}
	
	public Date getCheckOutDate() {
		return checkOutDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public BookCopy getBookCopy() {
		return bookCopy;
	}
	
	public boolean overDue(Date currenDate) {
		System.out.println("currenDate");
		System.out.println(currenDate);
		System.out.println("dueDate");
		System.out.println(dueDate);
		
//		System.out.println( dueDate.getTime());
//		
//		System.out.println( currenDate.getTime());
		
		if ( dueDate.getTime() < currenDate.getTime()) {
			return true;
		}
		
		return false;
	}
}
