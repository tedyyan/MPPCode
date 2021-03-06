package ui.main;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import business.BookCopy;
import business.ControllerInterface;
import business.SystemController;
import dataaccess.Auth;
import dataaccess.DataAccessFacade;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ui.AllBooksWindow;
import ui.LibWindow;
import ui.LoginWindow;
import ui.Start;
import ui.book.AddBookCopysDialogController;
import ui.book.AddBookDialogController;
import ui.book.CheckoutDialogController;
import ui.bookdue.BookDueController;
import ui.member.LibraryMemberOverviewController;
import ui.member.PersonEditDialogController;

public class MainWindow extends Stage implements LibWindow {
	public static final MainWindow INSTANCE = new MainWindow();

	//private User user;

//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}

	private boolean isInitialized = false;

	private MainWindow() {
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
		Pane root = new Pane();
		root.setId("test");

		
		root.setMinHeight(396);
		root.setMinWidth(800);
//		root.setPadding(new Insets(0, 0, 0, 0));
		VBox imageHolder = new VBox();
		imageHolder.setId("my-image");
		imageHolder.setLayoutY(20);
		Image image = new Image("ui/main.png", 800, 396, false, false);
		
//		imageHolder
        // simply displays in ImageView the image as is
        ImageView iv = new ImageView();
       
//        iv.setLayoutX(0);
//        iv.setLayoutY(80);
//        iv.setY(800);
        iv.setImage(image);
        imageHolder.getChildren().add(iv);
        imageHolder.setAlignment(Pos.CENTER);
        
        root.getChildren().add(imageHolder);
		initMenu(root);
		initComponent(root);
		
	
		
		Scene scene = new Scene(root, 800, 396);
		scene.getStylesheets().add(Start.getCSSTheme());
//		scene.getStylesheets();
		setScene(scene);
		
		

	}
	
	
	
	private void initComponent(Pane root) {
		  
			User user = SystemController.getCurrentUser();
	        Label userName = new Label("User Name: " + user.getId());
	        userName.setTextFill(Color.BLACK);
//	        userName.setPadding(new Insets(40,10,10,10));	 
	        userName.setLayoutY(40);
	        userName.setLayoutX(15);
	        String userTypeString = user.getAuthorization().toString();
	        userTypeString = userTypeString.equals("BOTH") ? "SUPER ADMIN" : userTypeString;
	        Label userType = new Label("User Type: " + userTypeString);
	        userType.setTextFill(Color.BLACK);
//	        userType.setMinSize(200, 100);
	        userType.setLayoutY(60);
	        userType.setLayoutX(15);
	        root.getChildren().add(userName);
	        root.getChildren().add(userType);
		
	}

	private void initMenu(Pane root) {
		

		Auth auth = SystemController.getCurrentUser().getAuthorization();

		VBox topContainer = new VBox();

		topContainer.setId("top-container");
		MenuBar mainMenu = new MenuBar();

		if (auth == Auth.LIBRARIAN) {
			checkoutBook(mainMenu);
		} else if (auth == Auth.ADMIN) {
			addMemberMenu(mainMenu);
			addBoosMenu(mainMenu);
		} else if (auth == Auth.BOTH) {
			checkoutBook(mainMenu);
			addMemberMenu(mainMenu);
			addBoosMenu(mainMenu);
		}
		otherMenu(mainMenu);

		mainMenu.setMinHeight(30);
		mainMenu.setMinWidth(800);
		
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

		MenuItem allBooks = new MenuItem("List All Books");
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
				int cntaa = 0;
				for(String s: ids) {
					BookCopy[] tmp = (new DataAccessFacade()).readBooksMap().get(s).getCopies();
					cntaa = 0;
					for(BookCopy bookcopy:tmp) {
						if(bookcopy.isAvailable() == true) {
							cntaa++;
						}
					}
					sb.append("ISBN: "+s +"\t\t\t available copy: "+ cntaa + "\n");
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
