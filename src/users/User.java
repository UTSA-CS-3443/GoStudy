package users;

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
}