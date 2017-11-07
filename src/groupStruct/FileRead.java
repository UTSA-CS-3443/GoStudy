package groupStruct;
import java.io.*;
import java.util.ArrayList;

//goes through Groups directory and creates Group objects and adds them to the groups list
public class FileRead {
	//loops through directory and returns 
	 public ArrayList<Group> constructList(String dirName) {
		 ArrayList<Group> groupList = new ArrayList<>();
		 //open directory
		 //loop through files
		 return groupList;
	 }
	 //takes file as parameter, loops through line by line and creates a group
	 public Group constructGroup(File file) {
		 Group group = new Group();
		 BufferedReader br = null;
		 try {
			br = new BufferedReader(new FileReader(file));
			group.setGroupName(br.readLine());
			group.setClassName(br.readLine());
			group.setLocation(br.readLine());
			group.setLocationNotes(br.readLine());
			group.setTime(br.readLine());
			group.setAccess(br.readLine());
			group.setSeatLimit(br.readLine());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 return group;
	 }
}