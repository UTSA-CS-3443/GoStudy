package groupStruct;

import java.io.BufferedWriter;
import java.io.File;
import java.nio.file.*;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import users.User;

/**
 * Edit/Create/Delete group files
 * @author Sam/Carlos
 *
 */
public class GroupFileEdit {
	
	//validate user information
	/**
	 * creates a new group file
	 * @param group
	 * @param user
	 * @return boolean
	 */
	public static boolean createGroupFile(Group group, User user) {
			try {
				File f = new File("Groups/" + group.getFileName());
				if (!validateAll(group)) {
					System.out.println("Invalid Input: createGroupFile");
					return false;
				}
				else if(f.exists()) {
					System.out.println("Group name already exists: createGroupFile");
					return false;
				}
				else {
					BufferedWriter writer = new BufferedWriter(new FileWriter("Groups/" + group.getFileName()));
					writer.write(group.getGroupName() + "\n");
					writer.write(group.getClassName() + "\n");
					writer.write(group.getMajorName() + "\n");
					writer.write(group.getLocation() + "\n");
					writer.write(group.getLocationNotes() + "\n");
					writer.write(group.getTime() + "\n");
					writer.write(group.getAccess() + "\n");
					writer.write(group.getSeatLimit() + "\n");
					writer.write(user.getUserName() + "\n");
					writer.close();
					return true;
				}
 			}catch (IOException e) {
				e.printStackTrace();
				return false;
			}
	}
	/**
	 * delete old group file and creates new one
	 * @param oldGroup
	 * @param editGroup
	 * @param user
	 * @return boolean
	 */
	public static boolean editGroup(Group oldGroup, Group editGroup, User user){
		 boolean success = deleteGroupFile(oldGroup, user);
		 if (!success) {
			 System.out.println("Edit failed because delete failed: editGroup");
		 	 return false;
		 }
		 success = createGroupFile(editGroup, user);
		 return success;
	}
	
	/**
	 * deletes group file 
	 * @param group
	 * @param user
	 * @return boolean
	 */
	public static boolean deleteGroupFile(Group group, User user) {
		String path = "Groups/" + group.getFileName();
		File file = new File(path);
		if (!file.exists()) {
			System.out.println(path + " does not exist: deleteGroupFile");
			return false;
		}
		boolean success = file.delete();
		if (!success) {
			System.out.println(path + " could not be deleted: deleteGroupFile");
		}
		return success;
	}
	
	//returns true if all user input is correct
	/**
	 * sadly does not validate anything :(
	 * @param group
	 * @return boolean
	 */
	public static boolean validateAll(Group group) {
		return true;
	}

}
