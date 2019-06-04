package ui.main;

import java.io.IOException;

import business.SystemController;
import dataaccess.Auth;
import dataaccess.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ui.LibWindow;
import ui.LoginWindow;

public class MainWindow extends Stage implements LibWindow{
	public static final MainWindow INSTANCE = new MainWindow();

	private User user;
	
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private boolean isInitialized = false;
	private MainWindow () {}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub

		setUser(SystemController.currentUser);
		
		VBox topContainer = new VBox();
		topContainer.setId("top-container");
		MenuBar mainMenu = new MenuBar();
		
		if (this.user.getAuthorization() == Auth.LIBRARIAN) {
			checkoutBook(mainMenu);
		} else if (this.user.getAuthorization() == Auth.ADMIN){
			addMemberMenu(mainMenu);
			addBoosMenu(mainMenu);
		} else if (this.user.getAuthorization() == Auth.BOTH) {
			checkoutBook(mainMenu);
		}
		
	
		topContainer.getChildren().add(mainMenu);
		Scene scene = new Scene(topContainer, 420, 375);
	
		setScene(scene);
		
	}
	
	private void checkoutBook(MenuBar mainMenu) {
		Menu memberMenu = new Menu("CheckOut");
		
		
		mainMenu.getMenus().add( memberMenu);
	}
	
	private void addMemberMenu(MenuBar mainMenu) {
		Menu memberMenu = new Menu("Member");
		
		
		mainMenu.getMenus().add( memberMenu);
	}
	
	private void addBoosMenu(MenuBar mainMenu) {
		Menu booksMenu = new Menu("Books");
		
		MenuItem addBook = new MenuItem("addBook");
		addBook.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	
            }
        });
		
		booksMenu.getItems().add(addBook);
		mainMenu.getMenus().add(booksMenu);
	}

	@Override
	public boolean isInitialized() {
		// TODO Auto-generated method stub
		return isInitialized;
	}

	@Override
	public void isInitialized(boolean val) {
		// TODO Auto-generated method stub
		isInitialized = val;
	}
	

}
