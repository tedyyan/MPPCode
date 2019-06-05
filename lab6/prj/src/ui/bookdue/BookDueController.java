package ui.bookdue;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import business.Book;
import business.BookBizService;
import business.BookBizServiceInterface;
import business.BookCopy;
import business.CheckRecordEntry;
import business.LibraryMember;
import business.due.BookCopyDue;
import business.person.MemberBizService;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ui.Start;
import ui.book.AddBookDialogController;

public class BookDueController {

	private Stage dialogStage;
	private BookBizServiceInterface bookBizService = BookBizService.getBookBizServiceInstance();
	/**
	 * The data as an observable list of Persons.
	 */
	private ObservableList<BookCopyDue> bookCopyDues = FXCollections.observableArrayList();
	@FXML
	private TableView<BookCopyDue> bookCopyTableView;

	@FXML
	private TableColumn<BookCopyDue, String> isbnColumn;
	@FXML
	private TableColumn<BookCopyDue, String> titleColumn;

	@FXML
	private TableColumn<BookCopyDue, String> copyNumberColumn;

	@FXML
	private TableColumn<BookCopyDue, String> dueDataColumn;

	@FXML
	private Button searchButton;

	@FXML
	private TextField isbntextField;

	/**
	 * Initializes the controller class. This method is automatically called after
	 * the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {

		isbnColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIsbn()));
		titleColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTitle()));

		copyNumberColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCopyNumber()));
		dueDataColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDueDate()));

	}

	/**
	 * Sets the stage of this dialog.
	 * 
	 * @param dialogStage
	 */
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;

		// Set the dialog icon.
		this.dialogStage.getIcons().add(new Image("file:resources/images/edit.png"));
	}

	private void showAlert(String title, String content, Alert.AlertType type) {
		Alert information = new Alert(type,content);
		information.setTitle(title); //设置标题，不设置默认标题为本地语言的information
		information.setHeaderText(title);
		information.show();
	}
	
	public void back() {
		dialogStage.close();
	}
	
	public void search() {
		String textString = isbntextField.getText();
		if (textString.equals("")) {
			showAlert("Warning", "Search filed empty", Alert.AlertType.WARNING);
			
			return;
		}

		BookBizServiceInterface bizService = BookBizService.getBookBizServiceInstance();
		Book book = bizService.getBookByISBN(textString);
		if (null == book) {
			showAlert("Warning", "Don't have this book", Alert.AlertType.WARNING);
			return;
		}
		
		BookCopy[] bookCopy = book.getCopies();
		
		System.out.println(bookCopy.length);
//
		ArrayList<BookCopyDue> myBookCopyDues = new ArrayList<>();
//		
		for (BookCopy bCopy : bookCopy) {
			CheckRecordEntry chr = bCopy.getCheckoutRecordEntry();
			System.out.println("CheckRecordEntry");
			System.out.println(chr);
			if (null == chr) {
				continue;
			}
			System.out.println(chr.getDueDate().toString());
			System.out.println(new Date(999, 2, 12).toString());
			if (chr.overDue(new Date(999, 2, 12))) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				myBookCopyDues.add(new BookCopyDue(bCopy.getBook().getIsbn(),
						bCopy.getBook().getTitle(),
						String.valueOf(bCopy.getCopyNum()), dateFormat.format(chr.getDueDate())));
			}
		}
		
		if (myBookCopyDues.size() == 0) {
			showAlert("Information", "Don't have any book copys overdue", Alert.AlertType.INFORMATION);
			return;
		}
		bookCopyTableView.setItems(getBookCopyDuesData(myBookCopyDues));

	}

	private ObservableList<BookCopyDue> getBookCopyDuesData(ArrayList<BookCopyDue> myBookCopyDues) {

		bookCopyDues.addAll(myBookCopyDues);
		return bookCopyDues;
	}

	/**
	 * Called when the user clicks cancel.
	 */
	@FXML
	private void handleDone() {
		isOkClicked = true;
		dialogStage.close();
	}

	private boolean isOkClicked = false;

	private boolean isOkClicked() {
		return isOkClicked;
	}

	public static boolean showBookDueController() {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Start.class.getResource("bookdue/BookDueWinow.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(Start.primStage());
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			BookDueController controller = loader.getController();
			controller.setDialogStage(dialogStage);

			// Set the dialog icon.
			dialogStage.getIcons().add(new Image("file:resources/images/edit.png"));

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
}
