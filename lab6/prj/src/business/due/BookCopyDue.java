package business.due;

public class BookCopyDue {
	private String isbn;
	private String title;
	private String copyNumber;
	private String dueDate;
	private String currentDate;

	public BookCopyDue(String isbn, String title, String copyNumber, String dueDate, String currentDate) {
		this.isbn = isbn;
		this.title = title;
		this.copyNumber = copyNumber;
		this.dueDate = dueDate;
		this.currentDate = currentDate;
	}
	

	public String getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}


	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCopyNumber() {
		return copyNumber;
	}

	public void setCopyNumber(String copyNumber) {
		this.copyNumber = copyNumber;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
}
