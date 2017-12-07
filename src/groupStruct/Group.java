package groupStruct;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import users.User;

public class Group {
	private String groupName; //AOA Final
	private String fileName; //replace spaces with underscore and add ".txt", AOA_Final.txt
	private String majorName;
	private String className; //predefined?
	private String location; //make a location enum for predefined locations like NPB, or location class?
	private String locationNotes;
	private String time; //is there a time class? predefined times
	private String access; //Public or private
	private String seatLimit;
	private User groupOwner;
	private ArrayList<User> groupMembers;
	private int iSeatsTaken;
	
	public static Group newGroup(String groupName, String className, String majorName, String location, String locationNotes
			, String time, String access, String seatLimit) {
		Group group = new Group();
		group.groupName = groupName;
		group.fileName = stringToFileName(groupName);
		group.className = className;
		group.majorName = majorName;
		group.location = location;
		group.locationNotes = locationNotes;
		group.time = time;
		group.access = access;
		group.seatLimit = seatLimit;
		group.iSeatsTaken = Integer.parseInt(seatLimit);
		return group;
	}
	
	//MAIN MAIN!!!
	//join doesnt append to file
	public boolean joinGroup(User user) {
		/*if (this.groupMembers.size() == this.iSeatsTaken) //removed for final product 
			return false;*/
		/*if (this.access.equals("PRIVATE")) //removed for final product
			return false;*/
		//if (this.groupMembers.contains(user)) NEED TO ADD THIS BACK!!!!!!!!
		//	return false;
		//else { AND THIS!!!!!!!!!
			//this.groupMembers.add(user); NEED TO ADD THIS BACK!!!!!!!!!
			//this.iSeatsTaken++;
			//START NEW !!!
			try {
				//System.out.println("IN JOIN GROUP");
				File file = new File("Groups/" + this.getFileName());
				if (!file.exists()) {	
					System.out.println("FILE DOES NOT EXIST");
					return false;
				}
				FileWriter fw = new FileWriter(file, true);
				BufferedWriter bw = new BufferedWriter(fw);
				//PrintWriter out = new PrintWriter(bw);
				//out.println(user.getUserName());
				//out.close();
				bw.write(user.getUserName() + "\n");
				bw.close();
			} catch (IOException e) {
				System.out.println("IO EXCEPTION");
				e.printStackTrace();
			}
			//END NEW !!!!
			return true;
		//}
	}
	
	public boolean leaveGroup(User user) {
		System.out.println("IN LEAVE GROUP");
		//if (!this.groupMembers.contains(user))
		//	return false;
		//else {
			this.groupMembers.remove(user);
			//System.out.println(user.getUserName() + " user wants to leave!!!!\n");
			//this.iSeatsTaken--;
			Group newGroup = this;
			
			GroupFileEdit.deleteGroupFile(this, user);
			GroupFileEdit.createGroupFile(newGroup, newGroup.getGroupOwner());
			try {
				FileWriter fw = new FileWriter(this.getFileName(), true);
				BufferedWriter bw = new BufferedWriter(fw);
				//PrintWriter out = new PrintWriter(bw);
				for (User user1: newGroup.getGroupMembers()){
					bw.write(user1.getUserName() + "\n");
				}
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return true;
		//}
	}
	
	@Override 
	public String toString() {
		return this.groupName;
	}
	
	public static String stringToFileName(String string) {
		string = string.replaceAll(" ", "_");
		string = string + ".txt";
		return string;
	}
	
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getAccess() {
		return access;
	}
	public void setAccess(String access) {
		this.access = access;
	}
	public String getSeatLimit() {
		return seatLimit;
	}
	public void setSeatLimit(String seatLimit) {
		this.seatLimit = seatLimit;
	}
	public String getLocationNotes() {
		return locationNotes;
	}
	public void setLocationNotes(String locationNotes) {
		this.locationNotes = locationNotes;
	}

	public String getMajorName() {
		//TODO temp fix for demo video for returning proper major name
		if(className.length() == 7)
			return className.substring(0, 3);
		else
			return className.substring(0,2);
		//return majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	public User getGroupOwner() {
		return groupOwner;
	}

	public void setGroupOwner(User groupOwner) {
		this.groupOwner = groupOwner;
	}

	public ArrayList<User> getGroupMembers() {
		return groupMembers;
	}

	public void setGroupMembers(ArrayList<User> groupMembers) {
		this.groupMembers = groupMembers;
	}

	
}
//getters
//editGroupName, editClassName, etc, this will edit the group text file


