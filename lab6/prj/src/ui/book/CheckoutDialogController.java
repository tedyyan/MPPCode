package ui.book;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import business.Author;
import business.Book;
import business.BookBizService;
import business.BookBizServiceInterface;
import business.BookCopy;
import business.CheckRecordEntry;
import business.LibraryMember;
import business.person.MemberBizService;
import business.person.MemberBizServiceInterface;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;
import dataaccess.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;
import ui.Start;

public class CheckoutDialogController {

	@FXML
	private Text resultField;

	@FXML
	private TextField isbnField;
	
	@FXML
	private TextField memberIdField;
	
	@FXML
	private TableView<CheckRecordEntry> checkoutRecordTableView;
 
	private Stage dialogStage;

	private BookBizServiceInterface bookBizService = BookBizService.getBookBizServiceInstance();
	private MemberBizServiceInterface memberBizService = MemberBizService.getInstance();

	/**
	 * Initializes the controller class. This method is automatically called after
	 * the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
//		memberIDColumn.setCellValueFactory(cellData -> new SimpleStringProperty(memberIdField.getText()));
//		isbnColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getBookCopy().getBook().getIsbn()));
//		dueDateColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDueDate().toString()));
//		checkoutDateColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCheckOutDate().toString()));
        
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

	/**
	 * Called when the user clicks add.
	 */
	@FXML
	private void handleAdd() {
		
		Book book = bookBizService.getBookByISBN(isbnField.getText());
		LibraryMember member = memberBizService.FindPersonByMemberID(memberIdField.getText()); 
		if(book == null || member == null) {
			resultField.setText("book or member not exit!");
			return ;
		}
		BookCopy bookCopy = book.getNextAvailableCopy();
		
		CheckRecordEntry recordEntry = new CheckRecordEntry(new Date(), bookCopy);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DATE, book.getMaxCheckoutLength());
		recordEntry.setDueDate(calendar.getTime());
		
		member.getCheckrecord().addReorceEntry(recordEntry);
		
		bookCopy.setCheckoutRecordEntry(recordEntry);
		bookCopy.changeAvailability();
		checkoutRecordTableView.getItems().add(recordEntry);

		resultField.setText("book checkout success!");
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

	public static boolean showAddBookDialog() {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Start.class.getResource("book/checkout.fxml"));
			TitledPane page = (TitledPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(Start.primStage());
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			CheckoutDialogController controller = loader.getController();
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
