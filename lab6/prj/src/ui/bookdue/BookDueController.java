package ui.bookdue;

import java.io.IOException;

import business.BookBizService;
import business.BookBizServiceInterface;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
	
	public void search() {
		System.out.println("sds");
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
