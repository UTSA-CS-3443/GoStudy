package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import groupStruct.FileRead;
import groupStruct.Group;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

/**
 * Main is set to modularize screen views to allow new screens to be easily implemented
 * Extends Application for JavaFX
 * @author gitSchwifty
 */
public class GoStudyMain extends Application{

	/**
	 * static map which stores the name of the screen as a string, and the screen info
	 */
	static Map<String, ScreenInfo> screens = new HashMap<String, ScreenInfo>();		//this keeps track of all the .fxml and their associated controllers
	private static Stage main_stage;
	static Pane root;
	
	/**
	 * ArrayList of Groups which is gathered from the Groups Folder via constructList();
	 */
	public static ArrayList<Group> groupList = FileRead.constructList();
	public static Group selectedGroup = groupList.get(0);
	
	/**
	 * new_child switches to the screen given from name. name should NOT include ".fxml" at the end
	 * @param name
	 */
	public static void new_child(String name) {
		root.getChildren().clear();
		
		Pane child = screens.get(name).getPane();
		root.getChildren().add(child);
		screens.get(name).getController().on_load();
	}

	
	/**
	 * init_screen() uses the fxml of the screen's name passed to it and the controller associated with said screen and creates
	 * a screenInfo for it.
	 * It then populates screens with a newly created screenInfo.
	 */

	private void init_screen(String name) throws Exception{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(name + ".fxml"));
		Pane screen = (Pane) fxmlLoader.load();
		Object controller = fxmlLoader.getController();
		screens.put(name, new ScreenInfo(screen, (CommonController) controller));
	}
	
	/**
	 * init_screen()
	 * a method to initialize all screens used by GoStudy
		*/
	public void init_screens() {
		try {
			
			init_screen("MyGroups");
			init_screen("CreateGroup");
			init_screen("FindAGroup");
			init_screen("Map");
			init_screen("EditGroup");
			init_screen("Settings");
			init_screen("Login");
			init_screen("CreateUser");
			init_screen("Group");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Start application by primaryStage
	 * Login screen
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
				main_stage = primaryStage;
				root = FXMLLoader.load(getClass().getResource("Login.fxml"));
				Scene scene = new Scene(root);
				
				init_screens();
				new_child("Login");
				
				primaryStage.setTitle("GoStudy");
				primaryStage.setScene(scene);
				primaryStage.centerOnScreen();
				primaryStage.show();
				
			} catch(Exception e) {
				e.printStackTrace();
			}
	}
	/**
	 * Launch in main
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
