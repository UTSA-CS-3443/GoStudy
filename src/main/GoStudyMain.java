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

	static Map<String, Pane> screens = new HashMap<String, Pane>();		//this keeps track of all the .fxml and their associated controllers
	private static Stage main_stage;
	static Pane root;
	
	//switches to the screen given from name. name should NOT include ".fxml" at the end
	public static void new_child(String name) {
		root.getChildren().clear();
		
		Pane child = screens.get(name);
		root.getChildren().add(child);
	}
	
	private void init_screen(String name) throws Exception{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(name + ".fxml"));
		
		Pane screen = (Pane) fxmlLoader.load();
		screens.put(name, screen);
	}
	
	//place all .fxmls here so it can be put into screens
	public void init_screens() {
		try {
			
			init_screen("MyGroups");
			init_screen("CreateGroup");
			init_screen("FindAGroup");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
				main_stage = primaryStage;
				root = FXMLLoader.load(getClass().getResource("MyGroups.fxml"));
				Scene scene = new Scene(root);
				
				init_screens();
				new_child("MyGroups");
				
				primaryStage.setTitle("GoStudy");
				primaryStage.setScene(scene);
				primaryStage.centerOnScreen();
				primaryStage.setResizable(false);
				primaryStage.show();
				
			} catch(Exception e) {
				e.printStackTrace();
			}
	}
	
	public static void main(String[] args) {
		ArrayList<Group> groupList = FileRead.constructList();
		Group group1 = groupList.get(0);
		Group group2 = groupList.get(1);
		System.out.println(group1.getGroupName());
		System.out.println(group2.getGroupName());
		
		launch(args);
	}
}
