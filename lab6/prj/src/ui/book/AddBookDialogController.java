package ui.book;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import business.Address;
import business.Author;
import business.Book;
import business.BookBizService;
import business.BookBizServiceInterface;
import business.BookCopy;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;
import ui.Start;

public class AddBookDialogController {

	@FXML
	private Text resultField;

	@FXML
	private TextField authorsField;
	@FXML
	private TextField isbnField;
	@FXML
	private TextField titleField;
	@FXML
	private TextField maxCheckoutLengthField;
	@FXML
	private TextField copiesNumField;

	private Stage dialogStage;

	private BookBizServiceInterface bookBizService = BookBizService.getBookBizServiceInstance();

	/**
	 * Initializes the controller class. This method is automatically called after
	 * the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
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
		String authorString = authorsField.getText();
		List<Author> authorList = new ArrayList<Author>();
		if (authorString != null) {
			String[] authors = authorString.split(";");
			for (String s : authors) {				
				Author author = new Author(s, s, s, null, s);
				authorList.add(author);
			}
		}
		String maxS = maxCheckoutLengthField.getText();
		int maxCheckoutLength = 0;
		try {
			maxCheckoutLength = Integer.parseInt(maxS);
		} catch (NumberFormatException e) {
			resultField.setText("wrong maxCheckoutLength");
			return;
		}
		
		String copyNumString = copiesNumField.getText();
		int copyNum = 0;
		try {
			copyNum = Integer.parseInt(copyNumString);
		} catch (NumberFormatException e) {
			resultField.setText("wrong copy Number");
			return;
		}
		if(bookBizService.getBookByISBN(isbnField.getText()) != null) {
			resultField.setText("thie book alreay exit!");
			return ;
		}
		
		Book book = new Book(isbnField.getText(), titleField.getText(),
				maxCheckoutLength, authorList);
		for (int i = 0; i < copyNum; i++) {
			book.addCopy();
		}
		bookBizService.saveBook(book);
		resultField.setText("book save success!");

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
			loader.setLocation(Start.class.getResource("book/AddBook.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			page.setId("test");

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(Start.primStage());
			Scene scene = new Scene(page);
		    scene.getStylesheets().add(Start.getCSSTheme());
			dialogStage.setScene(scene);

			// Set the person into the controller.
			AddBookDialogController controller = loader.getController();
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
