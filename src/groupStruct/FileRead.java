package groupStruct;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import users.User;
//MAIN !!!!!!!!!
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
		 User user = new User();
		 User user1 = new User();
		 ArrayList<User> users = new ArrayList<User>();
		 String line;
		 BufferedReader br = null;
		 try {
			br = new BufferedReader(new FileReader(file));
			group.setGroupName(br.readLine());
			group.setFileName(file.getName());
			group.setClassName(br.readLine());
			group.setMajorName(br.readLine());
			group.setLocation(br.readLine());
			group.setLocationNotes(br.readLine());
			group.setTime(br.readLine());
			group.setAccess(br.readLine());
			group.setSeatLimit(br.readLine());
			user.setUserName(br.readLine());
			group.setGroupOwner(user);
			while((line = br.readLine()) != null) { //START NEW
				user1.setUserName(line);
				//System.out.printf("CONSTRUCT GROUP, user:%s in group: %s\n", user1.getUserName(), group.getGroupName());
				users.add(user1);
			}
			group.setGroupMembers(users); //END NEW
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 return group;
	 }
}