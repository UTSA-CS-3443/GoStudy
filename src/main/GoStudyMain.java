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


public class GoStudyMain extends Application{

	static Map<String, ScreenInfo> screens = new HashMap<String, ScreenInfo>();		//this keeps track of all the .fxml and their associated controllers
	private static Stage main_stage;
	static Pane root;
	
	public static ArrayList<Group> groupList = FileRead.constructList();
	public static Group selectedGroup = groupList.get(0);
	//public static Group group1 = groupList.get(0);
	//public static Group group2 = groupList.get(1);
	
	//switches to the screen given from name. name should NOT include ".fxml" at the end
	public static void new_child(String name) {
		root.getChildren().clear();
		
		Pane child = screens.get(name).getPane();
		root.getChildren().add(child);
		screens.get(name).getController().on_load();
	}
	
	private void init_screen(String name) throws Exception{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(name + ".fxml"));
		Pane screen = (Pane) fxmlLoader.load();
		Object controller = fxmlLoader.getController();
		screens.put(name, new ScreenInfo(screen, (CommonController) controller));
	}
	
	//place all .fxmls here so it can be put into screens
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
	
	@Override
	public void start(Stage primaryStage) {
		try {
				main_stage = primaryStage;
				root = FXMLLoader.load(getClass().getResource("Map.fxml"));
				Scene scene = new Scene(root);
				
				init_screens();
				new_child("Map");
				
				primaryStage.setTitle("GoStudy");
				primaryStage.setScene(scene);
				primaryStage.centerOnScreen();
				primaryStage.show();
				
			} catch(Exception e) {
				e.printStackTrace();
			}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
