package ui.main;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import business.ControllerInterface;
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
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ui.AllBooksWindow;
import ui.LibWindow;
import ui.LoginWindow;
import ui.book.AddBookCopysDialogController;
import ui.book.AddBookDialogController;
import ui.book.CheckoutDialogController;
import ui.bookdue.BookDueController;
import ui.member.LibraryMemberOverviewController;
import ui.member.PersonEditDialogController;

public class MainWindow extends Stage implements LibWindow {
	public static final MainWindow INSTANCE = new MainWindow();

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private boolean isInitialized = false;

	private MainWindow() {
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		setUser(SystemController.getCurrentUser());
		AnchorPane root = new AnchorPane();

//		root.setPadding(new Insets(25, 25, 25, 25));

		initMenu(root);
		initComponent(root);
		Scene scene = new Scene(root, 420, 375);

		setScene(scene);
		
		

	}
	
	
	
	private void initComponent(AnchorPane root) {
		  
	        Label userName = new Label("User Name: " + user.getId());
//	        userName.setPadding(new Insets(40,10,10,10));	 
	        userName.setLayoutY(40);
	        userName.setLayoutX(15);
	        String userTypeString = user.getAuthorization().toString();
	        userTypeString = userTypeString.equals("BOTH") ? "SUPER ADMIN" : userTypeString;
	        Label userType = new Label("User Type: " + userTypeString);
//	        userType.setMinSize(200, 100);
	        userType.setLayoutY(60);
	        userType.setLayoutX(15);
	        root.getChildren().add(userName);
	        root.getChildren().add(userType);
		
	}

	private void initMenu(AnchorPane root) {
		

		

		VBox topContainer = new VBox();

		topContainer.setId("top-container");
		MenuBar mainMenu = new MenuBar();

		if (this.user.getAuthorization() == Auth.LIBRARIAN) {
			checkoutBook(mainMenu);
		} else if (this.user.getAuthorization() == Auth.ADMIN) {
			addMemberMenu(mainMenu);
			addBoosMenu(mainMenu);
		} else if (this.user.getAuthorization() == Auth.BOTH) {
			checkoutBook(mainMenu);
			addMemberMenu(mainMenu);
			addBoosMenu(mainMenu);
		}
		otherMenu(mainMenu);

		mainMenu.setMinHeight(30);
		mainMenu.setMinWidth(420);
		
		mainMenu.setMaxWidth(9999);
		topContainer.getChildren().add(mainMenu);

		root.getChildren().add(topContainer);

	}

	private void otherMenu(MenuBar mainMenu) {

		Menu memberMenu = new Menu("Other");

		MenuItem exit = new MenuItem("Exit");
		exit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {

				if (!LoginWindow.INSTANCE.isInitialized()) {
					LoginWindow.INSTANCE.init();
				}
				LoginWindow.INSTANCE.clear();
				LoginWindow.INSTANCE.show();
				INSTANCE.close();
			}
		});

		memberMenu.getItems().addAll(exit);
		mainMenu.getMenus().add(memberMenu);
	}

	private void checkoutBook(MenuBar mainMenu) {
		Menu memberMenu = new Menu("CheckOut");

		MenuItem checkOut = new MenuItem("Check Out");
		checkOut.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				CheckoutDialogController.showCheckoutDialog();
			}
		});



		MenuItem checkBookDue = new MenuItem("Check Book Due");
		checkBookDue.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				BookDueController.showBookDueController();
			}
		});

		
		memberMenu.getItems().addAll(checkOut);
		memberMenu.getItems().addAll(checkBookDue);
		
		mainMenu.getMenus().add(memberMenu);
	}

	private void addMemberMenu(MenuBar mainMenu) {
		Menu memberMenu = new Menu("Member");

		MenuItem listMember = new MenuItem("List All Member");
		listMember.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				LibraryMemberOverviewController.showMemberOverview();
			}
		});

		MenuItem addNewMember = new MenuItem("Add New Member");
		addNewMember.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				PersonEditDialogController.showMe();
			}
		});

		

		memberMenu.getItems().addAll(listMember, addNewMember);

		mainMenu.getMenus().add(memberMenu);
	}

	private void addBoosMenu(MenuBar mainMenu) {
		Menu booksMenu = new Menu("Books");

		MenuItem addBook = new MenuItem("Add Book");
		addBook.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				AddBookDialogController.showAddBookDialog();
			}
		});

		MenuItem addBookCopy = new MenuItem("Add Book Copy");
		addBookCopy.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
					AddBookCopysDialogController.showAddBookCopyDialog();
			}
		});

		MenuItem allBooks = new MenuItem("Lisr All Books");
		allBooks.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				
				if(!AllBooksWindow.INSTANCE.isInitialized()) {
					AllBooksWindow.INSTANCE.init();
				}
				ControllerInterface ci = new SystemController();
				List<String> ids = ci.allBookIds();
				Collections.sort(ids);
				StringBuilder sb = new StringBuilder();
				for(String s: ids) {
					sb.append(s + "\n");
				}
				AllBooksWindow.INSTANCE.setData(sb.toString());
				AllBooksWindow.INSTANCE.show();
			}
		});

		booksMenu.getItems().add(allBooks);
		booksMenu.getItems().add(addBook);
		booksMenu.getItems().add(addBookCopy);
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
