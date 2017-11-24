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

/**
 * 
 * @author Gloria Trevino
 * @author Victoria Huerta
 * 
 *         The main contoller for the login screen.
 *
 */
public class LoginController extends CommonController {

	private Parent root;
	private static ArrayList<Node> nodes;
	@FXML
	private Label lblLabel;
	@FXML
	private Label LblMainWindow;
	@FXML
	private TextField txtUsername;
	@FXML
	private TextField txtPassword;

	// for the new user button
	@FXML
	private TextField txtUsernametoo;
	@FXML
	private TextField txtPasswordtoo;

	// for the login to enter the map fxml
	@FXML
	private Label lblUTSAMap;

	/**
	 * public void Login(ActionEvent event)
	 * 
	 * Controls the buttons on the login page.
	 * 
	 * @param event
	 * @throws Exception
	 */
	public void Login(ActionEvent event) throws Exception {

		String username = txtUsername.getText(); // grabs username from textfield
		String adjusted = username.replaceAll("\\s+$", ""); // removes extra space added at the end of the username
															// string
		String pass = txtPassword.getText(); // grabs password from password field
		String user = adjusted + "," + pass; // combines username and passoword

		// checks if textfields were null
		if (username.trim().isEmpty() || pass.isEmpty()) {
			lblLabel.setText("   Hey, you didn't put anything!");
		} else {

			try {
				// opens file for reading
				File file = new File("users.txt");
				FileReader fileReader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				StringBuffer stringBuffer = new StringBuffer(); // empty "string"
				String line;
				// adds each line in the file into the stringbuffer
				while ((line = bufferedReader.readLine()) != null) {
					stringBuffer.append(line);
					stringBuffer.append("\n");
				}
				fileReader.close(); // close file
				System.out.println("Contents of file:");
				System.out.println(stringBuffer.toString());
				// looks for user in the stringBuffer
				if ((stringBuffer.toString()).contains(user)) {
					// goes to MyGroups if login is successful -- annie
					GoStudyMain.new_child("MyGroups");
				} else {
					// If user doesn't exist
					lblLabel.setText("\t  User not found");
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}// end login function

	public void NewUser(ActionEvent event2) throws Exception {
		// if we want to create a new user

		// goes to CreateUser's controller and displays CreateUser.fxml --annie
		GoStudyMain.new_child("CreateUser");

		// TODO: and doesn't match a user name or password
	}// end new user function

	@Override
	void on_load() {

		// TODO Auto-generated method stub

	}

}
