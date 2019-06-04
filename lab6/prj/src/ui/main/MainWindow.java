package ui.main;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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

	private boolean isInitialized = false;
	private MainWindow () {}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
		    GridPane grid = new GridPane();
	        grid.setId("top-container");
	        grid.setAlignment(Pos.CENTER);
	        grid.setHgap(10);
	        grid.setVgap(10);
	        grid.setPadding(new Insets(25, 25, 25, 25));
		
		VBox topContainer = new VBox();
		topContainer.setId("top-container");
		MenuBar mainMenu = new MenuBar();
		
		Menu optionsMenu = new Menu("Options");
		MenuItem login = new MenuItem("Login");
		
		login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	//hideAllWindows();
    			if(!LoginWindow.INSTANCE.isInitialized()) {
    				LoginWindow.INSTANCE.init();
    			}
    			LoginWindow.INSTANCE.clear();
    			LoginWindow.INSTANCE.show();
            }
        });			
		
		optionsMenu.getItems().addAll(login);
		mainMenu.getMenus().addAll(optionsMenu);
		
		Scene scene = new Scene(topContainer, 420, 375);
		
		setScene(scene);
		
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
