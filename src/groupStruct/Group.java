package groupStruct;

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
	
	
	//check if seat limit has not been met, otherwise join and add one to members
	public boolean joinGroup(User user) {
		if (this.groupMembers.size() == this.iSeatsTaken)
			return false;
		if (this.access.equals("PRIVATE")) //this not needed
			return false;
		if (this.groupMembers.contains(user))
			return false;
		else {
			this.groupMembers.add(user);
			this.iSeatsTaken++;
			return true;
		}
	}
	
	public boolean leaveGroup(User user) {
		if (!this.groupMembers.contains(user))
			return false;
		else {
			this.groupMembers.remove(user);
			this.iSeatsTaken--;
			return true;
		}
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


