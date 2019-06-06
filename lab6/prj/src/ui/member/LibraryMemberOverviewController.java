package ui.member;

import java.io.IOException;

import business.CheckRecord;
import business.LibraryMember;
import business.person.MemberBizService;
import business.person.MemberBizServiceInterface;
import dataaccess.DataAccessFacade;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ui.Start;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class LibraryMemberOverviewController {
    @FXML
    private TableView<LibraryMember> LibraryMemberTable;
    @FXML
    private TableColumn<LibraryMember, String> firstNameColumn;
    @FXML
    private TableColumn<LibraryMember, String> lastNameColumn;

    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label streetLabel;
    @FXML
    private Label postalCodeLabel;
    @FXML
    private Label cityLabel;
    @FXML
    private Label birthdayLabel;
    @FXML
    private Label memeberIDLabel;

    @FXML
    private TextField searchTextFeild;
    @FXML
    private Button searchButton;
    

	private MemberBizServiceInterface memberBizService = MemberBizService.getInstance();
    // Reference to the main application.
    //private MainApp mainApp;
    
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
    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public LibraryMemberOverviewController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the LibraryMember table with the two columns.
        firstNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFirstName()));
        lastNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLastName()));
        
        // Clear LibraryMember details.
        showLibraryMemberDetails(null);

        // Listen for selection changes and show the LibraryMember details when changed.
        LibraryMemberTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showLibraryMemberDetails(newValue));
    }

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    //public void setMainApp(MainApp mainApp) {
        //this.mainApp = mainApp;

        // Add observable list data to the table
        //LibraryMemberTable.setItems(mainApp.getLibraryMemberData());
    //}
    
    /**
     * Fills all text fields to show details about the LibraryMember.
     * If the specified LibraryMember is null, all text fields are cleared.
     * 
     * @param LibraryMember the LibraryMember or null
     */
    private void showLibraryMemberDetails(LibraryMember LibraryMember) {
        if (LibraryMember != null) {
            // Fill the labels with info from the LibraryMember object.
            this.memeberIDLabel.setText(LibraryMember.getMemberId());
            firstNameLabel.setText(LibraryMember.getFirstName());
            lastNameLabel.setText(LibraryMember.getLastName());
            streetLabel.setText(LibraryMember.getAddress().getStreet());
            postalCodeLabel.setText(LibraryMember.getAddress().getZip());
            cityLabel.setText(LibraryMember.getAddress().getCity());
            birthdayLabel.setText(LibraryMember.getTelephone());
        } else {
            // LibraryMember is null, remove all the text.
        	this.memeberIDLabel.setText("");
            firstNameLabel.setText("");
            lastNameLabel.setText("");
            streetLabel.setText("");
            postalCodeLabel.setText("");
            cityLabel.setText("");
            birthdayLabel.setText("");
        }
    }
    
    /**
     * Called when the user clicks on the search button.
     */
    @FXML
    private void handleSearchLibraryMember() {
    	String id = searchTextFeild.getText();
    	 for ( int i = 0; i<LibraryMemberTable.getItems().size(); i++) {
    		 LibraryMemberTable.getItems().clear(); 
    	    } 
		LibraryMemberTable.setItems(getLibraryMemberData(id));
		//LibraryMemberTable.refresh();
    }
    
    /**
     * Called when the user clicks on the delete button.
     */
    @FXML
    private void handleDeleteLibraryMember() {
    	
        int selectedIndex = LibraryMemberTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
        	memberBizService.removeMember(LibraryMemberTable.getItems().get(selectedIndex).getMemberId());
            LibraryMemberTable.getItems().remove(selectedIndex);
            
        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            //alert.initOwner(mainApp.getPrimaryStage());
            alert.initOwner(this.dialogStage);
            alert.setTitle("No Selection");
            alert.setHeaderText("No LibraryMember Selected");
            alert.setContentText("Please select a LibraryMember in the table.");
            
            alert.showAndWait();
        }
    }
    

    /**
     * Called when the user clicks the new button. Opens a dialog to edit
     * details for a new LibraryMember.
     */
    @FXML
    private void handleCheckRecordLibraryMember() {
//        LibraryMember tempLibraryMember = new LibraryMember();
//        boolean okClicked = mainApp.showLibraryMemberEditDialog(tempLibraryMember);
//        if (okClicked) {
//            mainApp.getLibraryMemberData().add(tempLibraryMember);
//        }
    	int selectedIndex = LibraryMemberTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
        	LibraryMember checkrecord = LibraryMemberTable.getItems().get(selectedIndex);
			CheckRecordOfOneMemberController.showCheckoutListDialog(checkrecord.getCheckrecord());
            
        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            //alert.initOwner(mainApp.getPrimaryStage());
//            alert.initOwner(this.dialogStage);
            alert.setTitle("No Selection");
            alert.setHeaderText("No LibraryMember Selected");
            alert.setContentText("Please select a LibraryMember in the table.");
            
            alert.showAndWait();
        }
    	
    	
    }

    /**
     * Called when the user clicks the edit button. Opens a dialog to edit
     * details for the selected LibraryMember.
     */
    @FXML
    private void handleEditLibraryMember() {
        LibraryMember selectedLibraryMember = LibraryMemberTable.getSelectionModel().getSelectedItem();
        if (selectedLibraryMember != null) {
            boolean okClicked = PersonEditDialogController.showPersonEditDialog(selectedLibraryMember);
            if (okClicked) {
                showLibraryMemberDetails(selectedLibraryMember);
            }

        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
//            alert.initOwner(this.dialogStage);
            alert.setTitle("No Selection");
            alert.setHeaderText("No LibraryMember Selected");
            alert.setContentText("Please select a LibraryMember in the table.");
            
            alert.showAndWait();
        }
    }
    @FXML
    public static void showMemberOverview() {
    	// Load the fxml file and create a new stage for the popup dialog.
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Start.class.getResource("member/PersonOverview.fxml"));
        AnchorPane page = null;
		try {
			page = (AnchorPane) loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
        
	 	// Create the dialog Stage.
	    Stage dialogStage = new Stage();
	    dialogStage.setTitle("Overview Person");
	    dialogStage.initModality(Modality.WINDOW_MODAL);
	    dialogStage.initOwner(Start.primStage());
	    Scene scene = new Scene(page);
	    dialogStage.setScene(scene);
	    scene.getStylesheets().add(Start.getCSSTheme());
	    
	    // Set the person into the controller.
	    LibraryMemberOverviewController controller = loader.getController();
	    controller.setDialogStage(dialogStage);
	    //controller.setPerson(person);
	    
	    // Set the dialog icon.
	    dialogStage.getIcons().add(new Image("file:resources/images/edit.png"));
	    // Add observable list data to the table
	    controller.LibraryMemberTable.setItems(controller.getLibraryMemberData());
	    // Show the dialog and wait until the user closes it
	    dialogStage.showAndWait();
	
	    //return controller.isOkClicked();
	    return;
    }
	private ObservableList<LibraryMember> getLibraryMemberData() {
		personData.addAll(MemberBizService.getInstance().getAllPersons());
		return personData;
	}
	private ObservableList<LibraryMember> getLibraryMemberData(String id) {
		
		personData.addAll(MemberBizService.getInstance().FindPersonLikeByMemberID(id));
		return personData;
	}

    /**
     * The data as an observable list of Persons.
     */
    private ObservableList<LibraryMember> personData = FXCollections.observableArrayList();
}