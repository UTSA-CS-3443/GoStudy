package groupStruct;

import java.util.ArrayList;

public class findGroup {
	public static ArrayList<Group> findGroupByName(String name, ArrayList<Group> currentGroups) {
		ArrayList<Group> matchedGroups = new ArrayList<>();
		if (!name.equals("")) {
			for (Group group: currentGroups) {
				if (group.getGroupName().toLowerCase().contains(name.toLowerCase())) {
					matchedGroups.add(group);
				}
			}
		}
		return matchedGroups;
	}
	
	/*public static ArrayList<Group> findGroupByMajor(String name, ArrayList<Group> currentGroups) {
		ArrayList<Group> matchedGroups = new ArrayList<>();
		if (!name.equals("")) {
			for (Group group: currentGroups) {
				if (group.get().toLowerCase().contains(name.toLowerCase())) {
					matchedGroups.add(group);
				}
			}
		}
		return matchedGroups;
	}*/
	
	public static ArrayList<Group> findGroupByClass(String name, ArrayList<Group> currentGroups) {
		ArrayList<Group> matchedGroups = new ArrayList<>();
		if (!name.equals("")) {
			for (Group group: currentGroups) {
				if (group.getClassName().toLowerCase().contains(name.toLowerCase())) {
					matchedGroups.add(group);
				}
			}
		}
		return matchedGroups;
	}
	
	public static ArrayList<Group> findGroupByBuilding(String name, ArrayList<Group> currentGroups) {
		ArrayList<Group> matchedGroups = new ArrayList<>();
		if (!name.equals("")) {
			for (Group group: currentGroups) {
				if (group.getLocation().toLowerCase().contains(name.toLowerCase())) {
					matchedGroups.add(group);
				}
			}
		}
		return matchedGroups;
	}
}