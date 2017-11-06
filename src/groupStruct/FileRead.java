package groupStruct;
import java.io.*;
import java.util.ArrayList;

//goes through Groups directory and creates Group objects and adds them to the groups list
public class FileRead {
	//loops through directory and returns 
	 public ArrayList<Group> constructList(String dirName) {
		 ArrayList<Group> groupList = new ArrayList<>();
		 return groupList;
	 }
	 //takes file as parameter, loops through line by line and creates a group
	 public Group constructGroup(File file) {
		 Group group = new Group();
		 //BufferedReader br = new BufferedReader(new FileReader(file)); //try catch, why needed, where does stuff go?
		 //group.setGroupName(br.readLine());
		 return group;
	 }
}