package main;
import java.util.ArrayList;
import groupStruct.FileRead;
import groupStruct.Group;

public class GoStudyMain {
	public static void main(String[] args) {
		ArrayList<Group> groupList = FileRead.constructList();
		Group group1 = groupList.get(0);
		Group group2 = groupList.get(1);
		System.out.println(group1.getGroupName());
		System.out.println(group2.getGroupName());
	}

}
