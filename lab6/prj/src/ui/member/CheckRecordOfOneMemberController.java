package ui.member;

import java.io.IOException;

import business.CheckRecord;
import business.LibraryMember;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ui.Start;

public class CheckRecordOfOneMemberController {
	 @FXML
	    private TableView<LibraryMember> CheckoutTable;
	CheckRecord checkrecord;
	@FXML
    private TableColumn<LibraryMember, String> bookTitleColumn;
    @FXML
    private TableColumn<LibraryMember, String> ISBNColumn;
	@FXML
    private TableColumn<LibraryMember, String> outDateColumn;
    @FXML
    private TableColumn<LibraryMember, String> dueDateColumn;
    
	public CheckRecord getCheckrecord() {
		return checkrecord;
	}

	public void setCheckrecord(CheckRecord checkrecord) {
		this.checkrecord = checkrecord;
	}

	private Stage dialogStage;


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

	@FXML
	private void handleOk() {
		dialogStage.close();
	}

	/**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the LibraryMember table with the two columns.
        //firstNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFirstName()));
        //lastNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLastName()));
        
        
        
    }
	public static boolean showCheckoutListDialog(CheckRecord checkrecord) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Start.class.getResource("member/CheckRecordOfOneMember.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Checkout List");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(Start.primStage());
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			CheckRecordOfOneMemberController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setCheckrecord(checkrecord);

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

	private boolean isOkClicked() {
		return false;
	}
}
