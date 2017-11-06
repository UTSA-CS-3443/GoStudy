package groupStruct;

public class Group {
	private String groupName; //AOA Final
	private String fileName; //replace spaces with underscore and add ".txt", AOA_Final.txt
	private String className; //predefined?
	private String location; //make a location enum for predefined locations like NPB, or location class?
	private String locationNotes;
	private String time; //is there a time class? predefined times
	private String access; //Public or private
	private int seatLimit;
	
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
	public int getSeatLimit() {
		return seatLimit;
	}
	public void setSeatLimit(int seatLimit) {
		this.seatLimit = seatLimit;
	}
	public String getLocationNotes() {
		return locationNotes;
	}
	public void setLocationNotes(String locationNotes) {
		this.locationNotes = locationNotes;
	}	
}
//getters
//editGroupName, editClassName, etc, this will edit the group text file


