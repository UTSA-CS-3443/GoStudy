package groupStruct;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

//goes through Groups directory and creates Group objects and adds them to the groups list
public class FileRead {
	 //creates groupList, loops through files and calls constructGroup
	 public static ArrayList<Group> constructList() {
		 ArrayList<Group> groupList = new ArrayList<>();
		 File path = new File("./Groups");
		 File[] files = path.listFiles();
		 for (File file: files) {
			 Group group = constructGroup(file);
			 groupList.add(group);
		 }
		 return groupList;
	 }
	 //takes file as parameter, loops through line by line and creates a group
	 public static Group constructGroup(File file) {
		 Group group = new Group();
		 BufferedReader br = null;
		 try {
			br = new BufferedReader(new FileReader(file));
			group.setGroupName(br.readLine());
			group.setFileName(file.getName());
			group.setClassName(br.readLine());
			group.setLocation(br.readLine());
			group.setLocationNotes(br.readLine());
			group.setTime(br.readLine());
			group.setAccess(br.readLine());
			group.setSeatLimit(br.readLine());
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 return group;
	 }
}