package users;

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

public class User {
	private String userName;
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	// creates a array list of groups that are owned by the user
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static User newUser(String userName, String password) {
		User user = new User();
		user.userName = userName;
		user.setPassword(password);
		return user;
	}

	public int changePassword(String newPassword, String UserName) {

		System.out.println(newPassword);
		System.out.println(UserName);
		if (newPassword.matches("^.*(?=.{8,})(?=..*[0-9])(?=.*[A-Z])(?=.*[@!#$%^&+=]).*$")) {

			try {

				File file = new File("users.txt");
				FileReader fileReader = new FileReader(file);

				try (BufferedReader br = new BufferedReader(new FileReader("users.txt"))) {
					for (String line; (line = br.readLine()) != null;) {

						if (line.contains(UserName)) {
							System.out.println("Previous password:" + line);
							String user = UserName + "," + newPassword;
							change(line, user);

							return 1;
						} else {
							return 0;
						}
					}
				}

			} catch (IOException e) {
				// exception handling left as an exercise for the reader
			}
		} else {
			// password not sufficient
		}
		return 0;

	}// ends changePassword

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