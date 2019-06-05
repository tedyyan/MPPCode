package business;

import java.util.Date;

public class CheckRecordEntry {

	private String ISBN;
	private String memberID;
	private Date dueDate;
	private Date checkOutDate;
	
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	public String getMemberID() {
		return memberID;
	}

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
