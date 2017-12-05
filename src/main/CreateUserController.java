package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

/**
 * 
 * @author Victoria Huerta
 * @author Gloria Trevino
 * 
 * main controller for create user screen
 *
 */
public class CreateUserController extends CommonController {

	@FXML
	private TextField txtUsernametoo;
	@FXML
	private PasswordField txtPasswordtoo;
	@FXML
	private Label LblMainWindow;

	/**
	 * Creates a new user, and adds their info to the user.txt
	 * 
	 * @param event3
	 */
	@FXML
	public void create(ActionEvent event3) {

		String username = txtUsernametoo.getText();
		String password = txtPasswordtoo.getText();
		System.out.println(username);
		System.out.println(password);

		String adjusted = username.replaceAll("\\s+$", ""); // delete extra whitespace
		String user = adjusted + "," + password;

		try {
			// opens file
			File file = new File("users.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer(); // a temp holder for users.txt file
			String line;
			// reads each line and adds each to the temp string
			while ((line = bufferedReader.readLine()) != null) {
				stringBuffer.append(line);
				stringBuffer.append("\n");
			}
			fileReader.close();
			System.out.println("Contents of file:");
			System.out.println(stringBuffer.toString());
			// user doesn't already exist
			if (!(stringBuffer.toString()).contains(user)) {

				// checks that the password matches the required characters
				if (password.matches("^.*(?=.{8,})(?=..*[0-9])(?=.*[A-Z])(?=.*[@!#$%^&+=]).*$")) {

					try {

						String name = "\n" + username + "," + password;
						File f1 = new File("users.txt");
						// checks if exist
						if (f1.exists()) {
							f1.createNewFile();
						}

						// opens file and establishes that we're writing to it
						FileWriter fileWritter = new FileWriter(f1.getName(), true);
						BufferedWriter bw = new BufferedWriter(fileWritter);
						bw.write(name);
						bw.close(); // closes file

						// alert for new user created and goes to login screen
						LblMainWindow.setText("New user created");
						Alert confirm = new Alert(AlertType.CONFIRMATION);
						confirm.setHeaderText("You now exist. Congratulations.");
						confirm.setTitle("User Confirmation");
						confirm.showAndWait();
						GoStudyMain.new_child("Login");

					} catch (IOException e) {
						e.printStackTrace();
					}
				} else {
					LblMainWindow.setText("Password not suffcient");
				}

			} else {
				LblMainWindow.setText("Usermame already exists");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * To go back to login page, if new user was accidently clicked
	 * 
	 * @param event3
	 */
	@FXML
	public void byefelica(ActionEvent event3) {
		GoStudyMain.new_child("Login");
	}

	@Override
	void on_load() {
		// TODO Auto-generated method stub

	}
}
