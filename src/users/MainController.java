package users;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javafx.collections.ObservableList;
//import java.awt.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainController {

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
				Stage primaryStage = new Stage();
				this.root = FXMLLoader.load(getClass().getResource("/application/Map.fxml"));
				// BorderPane root = new BorderPane();
				Scene scene = new Scene(root, 400, 400);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();

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
		Stage primaryStage = new Stage();
		this.root = FXMLLoader.load(getClass().getResource("/application/Main.fxml"));
		for (int i = 0; i < this.root.getChildrenUnmodifiable().size(); i++) {
			System.out.println(this.root.getChildrenUnmodifiable().get(i));
		}
		System.out.println("end for");
		this.nodes = new ArrayList<>();
		this.nodes.addAll(this.root.getChildrenUnmodifiable());
		// System.out.println(root.getChildrenUnmodifiable().get(2).getId());
		// BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 400, 400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
		// will have to error check and make sure the username and password entered is
		// valid
		// and doesn't match a user name or password
	}//end new user function

	/**
	 * public void create(ActionEvent event3)
	 * 
	 * @parem event3
	 * @param event3\
	 * 
	 */
	public void create(ActionEvent event3) {

		String password = "";
		String username = "";

		for (int i = 0; i < this.nodes.size(); i++) {
			// checks if it's a textfield
			if (this.nodes.get(i).getClass() == TextField.class) {
				
				// if this is the username textfield
				if (this.nodes.get(i).getId().equals("txtUsernametoo")) {
					// get text from the username textfield
					TextField test = (TextField) this.nodes.get(i);
					username = test.getText();
				}
			}
			// check it is a password textfield
			if (this.nodes.get(i).getClass() == PasswordField.class) {
				
				// if it is the password textfield we want
				if (this.nodes.get(i).getId().equals("txtPasswordtoo")) {
					// get text in password text field
					PasswordField test = (PasswordField) this.nodes.get(i);
					password = test.getText();
				}
			}
		} //end for loop
		
		// prints to consol the username and the password
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
	}//end create
}
