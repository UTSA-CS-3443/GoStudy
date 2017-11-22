package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController extends CommonController{

	private Parent root;
	private static ArrayList<Node> nodes;
	@FXML private Label lblLabel;
	@FXML private Label LblMainWindow;
	@FXML private TextField txtUsername;
	@FXML private TextField txtPassword;

	// for the new user button
	@FXML private TextField txtUsernametoo;
	@FXML private TextField txtPasswordtoo;

	// for the login to enter the map fxml
	@FXML private Label lblUTSAMap;

	/**
	 * public void Login(ActionEvent event)
	 * 
	 * 
	 * TODO: need to let a user login succesfully
	 * 
	 * 
	 * @param event
	 * @throws Exception
	 */
	public void Login(ActionEvent event) throws Exception {
		// if these two fields match
		// will read from user.txt line by line the user name and password and see if
		// they both match
		String username = txtUsername.getText();
		String adjusted = username.replaceAll("\\s+$", "");
		String pass = txtPassword.getText();
		String user = adjusted + "," + pass;

		try {
			File file = new File("users.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				stringBuffer.append(line);
				stringBuffer.append("\n");
			}
			fileReader.close();
			System.out.println("Contents of file:");
			System.out.println(stringBuffer.toString());
			if ((stringBuffer.toString()).contains(user)) {
				//goes to MyGroups if login is successful -- annie
				GoStudyMain.new_child("MyGroups");
			} else {
				lblLabel.setText("\t  User not found");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		//TODO: make sure the textfileds aren't null
	}//end login function

	public void NewUser(ActionEvent event2) throws Exception {
		// if we want to create a new user
		
		//goes to CreateUser's controller and displays CreateUser.fxml --annie
		GoStudyMain.new_child("CreateUser");
		
		
		// will have to error check and make sure the username and password entered is
		// valid
		// and doesn't match a user name or password
	}//end new user function

	@Override
	void on_load() {
		
		// TODO Auto-generated method stub
		
	}

	/**
	 * public void create(ActionEvent event3)
	 * 
	 * @parem event3
	 * @param event3\
	 * 
	 */
	
}
