package users;

import java.util.ArrayList;

import groupStruct.Group;

public class User {
	private String userName;
	private String password;
	
	public String getUserName() {
		return userName;
	}
	
	//creates a array list of groups that are owned by the user
	public ArrayList<Group> ownedGroups(ArrayList<Group> groupList) {
		ArrayList<Group> ownedGroups = new ArrayList<>();
		for (Group group: groupList) {
			if (group.getGroupOwner().getUserName().equals(this.userName)) {
				ownedGroups.add(group);
			}
		}
		return ownedGroups;
	}
	
	//creates a array list of groups that the user is apart of 
	public ArrayList<Group> memberedGroups(ArrayList<Group> groupList) {
		ArrayList<Group> memberedGroups = new ArrayList<>();
		for (Group group: groupList) {
			for (User user: group.getGroupMembers()) {
				if (user.getUserName().equals(this.userName)) {
					memberedGroups.add(group);
				}
			}
		}
		return memberedGroups;
	}
	
	  

}