package main;
import java.util.ArrayList;
import groupStruct.FileRead;
import groupStruct.Group;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class GoStudyMain extends Application{
	
	public static Stage stage;
	
	@Override
	public void start(Stage primaryStage) {
		try {
				Parent root = FXMLLoader.load(getClass().getResource("CreateGroup.fxml"));
				primaryStage.setScene(new Scene(root,950,700));
				primaryStage.show();
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		
			this.stage = primaryStage;
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
