package ui.book;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import business.Author;
import business.Book;
import business.BookBizService;
import business.BookBizServiceInterface;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ui.Start;

public class AddBookDialogController {

	@FXML
	private TextField resultField;

	@FXML
	private TextField authorsField;
	@FXML
	private TextField isbnField;
	@FXML
	private TextField titleField;
	@FXML
	private TextField maxCheckoutLengthField;

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
		}
		Book book = new Book(isbnField.getText(), titleField.getText(),
				Integer.valueOf(maxCheckoutLengthField.getText()), authorList);
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

	public static boolean showAddBookCopyDialog() {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Start.class.getResource("book/AddBook.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(Start.primStage());
			Scene scene = new Scene(page);
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
