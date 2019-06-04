package ui.book;

import business.Book;
import business.BookBizService;
import business.BookBizServiceInterface;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ui.Start;

public class AddBookCopysDialogController {

    @FXML
    private TextField isbnField;
    @FXML
    private TextField resultField;

    private Stage dialogStage;
  
    private BookBizServiceInterface bookBizService = BookBizService.getBookBizServiceInstance();

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
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
            Book book = bookBizService.getBookByISBN(isbnField.getText());
            if(book == null) {
            	resultField.setText("book is not found!");
            	return;
            }
            book.addCopy();
            resultField.setText("book copy add success!");

    }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleDone() {
        dialogStage.close();
    }

}
