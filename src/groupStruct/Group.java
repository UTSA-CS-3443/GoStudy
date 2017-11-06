package groupStruct;

public class Group {
	private String groupName; //AOA Final
	private String fileName; //replace spaces with underscore and add ".txt", AOA_Final.txt
	private String className; //predefined?
	private String location; //make a location enum for predefined locations like NPB, or location class?
	private String time; //is there a time class? predefined times
	private String access; //Public or private
	private int seatLimit;


	public Group(String name) {
		this.groupName = name;
	}
}
//getters
//editGroupName, editClassName, etc, this will edit the group text file


