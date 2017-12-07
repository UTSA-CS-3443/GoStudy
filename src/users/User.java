package users;
//MAIN MAIN!!!
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
import java.util.ArrayList;

import groupStruct.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * User object, join/leaves group change passwords 
 * @author Sam Burnett, Gloria Trevino, Carlos Martinez, Victoria Huearta 
 *
 */
public class User {

	private String userName;
	private String password;
	
	/**
	 * creates User object, sets name and pass
	 * @param userName
	 * @param password
	 * @return User
	 */
	public static User newUser(String userName, String password) {
		User user = new User();
		user.userName = userName;
		user.setPassword(password);
		return user;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// creates a array list of groups that are owned by the user
	/**
	 * Returns array list of groups you own
	 * @param groupList
	 * @return ArrayList<Group>
	 */
	public ArrayList<Group> ownedGroups(ArrayList<Group> groupList) {
		ArrayList<Group> ownedGroups = new ArrayList<>();
		for (Group group : groupList) {
			if (group.getGroupOwner().getUserName().equals(this.userName)) {
				ownedGroups.add(group);
			}
		}
		return ownedGroups;
	}

	// creates a array list of groups that the user is apart of
	/**
	 * Returns array list of groups you are apart of 
	 * @param groupList
	 * @return ArrayList<Group>
	 */
	public ArrayList<Group> memberedGroups(ArrayList<Group> groupList) {
		ArrayList<Group> memberedGroups = new ArrayList<>();
		for (Group group : groupList) {
			for (User user : group.getGroupMembers()) {
				if (user.getUserName().equals(this.userName)) {
					memberedGroups.add(group);
				}
			}
		}
		return memberedGroups;
	}

	/**
	 * changePassword takes in a new password to change the password of the user
	 * that is currently logged into the system, by opening the file, users.txt and
	 * rewriting the line containing the user's information.
	 * 
	 * @param newPassword
	 * @param UserName
	 * @return
	 */
	public int changePassword(String newPassword, String UserName) {

		System.out.println(newPassword);
		System.out.println(UserName);
		// checks that the new password still matches the required characters for a
		// password
		if (newPassword.matches("^.*(?=.{8,})(?=..*[0-9])(?=.*[A-Z])(?=.*[@!#$%^&+=]).*$")) {

			try {
				// opens file
				File file = new File("users.txt");
				FileReader fileReader = new FileReader(file);

				// reads file line by line
				try (BufferedReader br = new BufferedReader(new FileReader("users.txt"))) {
					for (String line; (line = br.readLine()) != null;) {
						// finds the user whose password will be changed
						if (line.contains(UserName)) {
							System.out.println("Previous password:" + line);
							String user = UserName + "," + newPassword; // rewrites the whole line
							change(line, user);

							return 1; // successfully changed password
						} else {
							return 0; // Unsuccessfully changed password
						} // end if
					} // end for
				} // end try

			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			// if password doesn't match required characters: pop up alert
			Alert confirm = new Alert(AlertType.CONFIRMATION);
			confirm.setHeaderText("Password doesn't match required characters: a digit, lowercase letter, "
					+ "uppercase letter, a special character, and at least 8 chearacters. There must be no whitespace.");
			confirm.setTitle("User Confirmation");
			confirm.show();
		} // end if: password regex
		return 0;

	}// ends changePassword

	/**
	 * 
	 * change Changes the password
	 * 
	 * @param toReplace
	 * @param replaceTo
	 */
	public void change(String toReplace, String replaceTo) {
		try {
			// input the file content to the StringBuffer "input"
			BufferedReader file = new BufferedReader(new FileReader("users.txt"));
			String line;
			StringBuffer inputBuffer = new StringBuffer();

			while ((line = file.readLine()) != null) {
				inputBuffer.append(line);
				inputBuffer.append('\n');
			}
			String inputStr = inputBuffer.toString();

			file.close();

			System.out.println(inputStr); // check that it's inputted right

			inputStr = inputStr.replace(toReplace, replaceTo);

			// check if the new input is right
			System.out.println("----------------------------------\n" + inputStr);

			// write the new String with the replaced line OVER the same file
			FileOutputStream fileOut = new FileOutputStream("users.txt");
			fileOut.write(inputStr.getBytes());
			fileOut.close();

		} catch (Exception e) {
			System.out.println("Problem reading file.");
		}
	}// end change

}