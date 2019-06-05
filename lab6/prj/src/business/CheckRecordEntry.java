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
		int compareTo = dueDate.compareTo(currenDate);
			if (compareTo == -1) {
				return true;
			}
		return false;
	}
}
