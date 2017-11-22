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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateUserController extends CommonController{
	
	@FXML private TextField txtUsernametoo;
    @FXML private PasswordField txtPasswordtoo;
    @FXML private Label LblMainWindow;
    
    @FXML
    public void create(ActionEvent event3) {
	
	// prints to consol the username and the password
	String username = txtUsernametoo.getText();
	String password = txtPasswordtoo.getText();
	System.out.println(username);
	System.out.println(password);

	// below we will create a textfile for our user name and file
	/*
	 * TODO : append to the file TODO : check to make sure the username and password
	 * a person creates does not match a username already in the users.txt TODO :
	 * make sure the password they create is
	 */
	String adjusted = username.replaceAll("\\s+$", "");
	String user = adjusted + "," + password;

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
		if (!(stringBuffer.toString()).contains(user)) {

			if (password.matches("^.*(?=.{8,})(?=..*[0-9])(?=.*[A-Z])(?=.*[@!#$%^&+=]).*$")) {

				//String name = "\n" + username + "," + password;
				//Scanner scanner = new Scanner("users.txt");

				// now read the file line by line..
				/**while (scanner.hasNextLine()) {
					String linee = scanner.nextLine();
					if (line == adjusted) {
						System.out.println("User already exists!");
						return;
					}
				}**/
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

					LblMainWindow.setText("New user created");
					// PrintWriter out = new PrintWriter("users.txt", "UTF-8");

					// out.println(username + "," + password);
					// more code
					// out.println(password);
					// out.close();
					// more code
				} catch (IOException e) {
					// exception handling left as an exercise for the reader
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

    @FXML
    public void byefelica(ActionEvent event3) {
    		GoStudyMain.new_child("Login");
    }
	@Override
	void on_load() {
		// TODO Auto-generated method stub
		
	}
}
