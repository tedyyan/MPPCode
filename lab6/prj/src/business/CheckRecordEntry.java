package business;

import java.util.Date;

public class CheckRecordEntry {

	private Date dueDate;
	private Date checkOutDate;
	
	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
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
}
