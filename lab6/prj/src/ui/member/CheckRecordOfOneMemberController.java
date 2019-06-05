package ui.member;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import business.CheckRecord;
import business.CheckRecordEntry;
import business.LibraryMember;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
	    private TableView<WholeRecord> CheckoutTable;
	CheckRecord checkrecord;
	@FXML
    private TableColumn<WholeRecord, String> bookTitleColumn;
    @FXML
    private TableColumn<WholeRecord, String> ISBNColumn;
	@FXML
    private TableColumn<WholeRecord, String> outDateColumn;
    @FXML
    private TableColumn<WholeRecord, String> dueDateColumn;
    /**
     * The data as an observable list of Persons.
     */
    private ObservableList<WholeRecord> wholeData = FXCollections.observableArrayList();
    
    class WholeRecord{
    	String bookTitle;
    	public String getBookTitle() {
			return bookTitle;
		}
		public String getISBN() {
			return ISBN;
		}
		public String getOutDate() {
			return outDate;
		}
		public String getDueDate() {
			return dueDate;
		}
		String ISBN;
    	String outDate;
    	String dueDate;
    	WholeRecord(String bookTitle,String ISBN,String outDate,String dueDate){
    		this.bookTitle = bookTitle;
    		this.ISBN = ISBN;
    		this.outDate = outDate;
    		this.dueDate = dueDate;
    	}
    }
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
    	bookTitleColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getBookTitle()));
    	ISBNColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getISBN()));
    	outDateColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getOutDate()));
    	dueDateColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDueDate()));
        
        
        
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
			controller.fillTableView(checkrecord);
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

	private void fillTableView(CheckRecord checkrecord2) {
		wholeData.addAll(this.recordToWhole(checkrecord2));
		this.CheckoutTable.setItems(wholeData);
		
	}

	private boolean isOkClicked() {
		return false;
	}
	
	private List<WholeRecord> recordToWhole(CheckRecord cr) {
		List<CheckRecordEntry> a = cr.getCheckRecordEntrys();
		List<WholeRecord> result = new ArrayList<WholeRecord>();
		for(CheckRecordEntry ele:a) {
			result.add(new WholeRecord(ele.getBookCopy().getBook().getTitle(),ele.getBookCopy().getBook().getIsbn(),
					ele.getCheckOutDate().toString(),ele.getCheckOutDate().toString()));
		}
		return result;
	}
}
