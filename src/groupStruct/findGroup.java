package groupStruct;

import java.util.ArrayList;
/**
 * All the different tools for search
 * @author Sam/Carlos
 *
 */
public class findGroup {
	//finds group by name
	/**
	 * finds group by group name
	 * @param name
	 * @param currentGroups
	 * @return ArrayList<Group>
	 */
	public static ArrayList<Group> findGroupByName(String name, ArrayList<Group> currentGroups) {
		ArrayList<Group> matchedGroups = new ArrayList<>();
		for (Group group : currentGroups) {
			if (group.getGroupName().toLowerCase().contains(name.toLowerCase())) {
				matchedGroups.add(group);
			}
		}
		return matchedGroups;
	}

	//finds groups by major
	/**
	 * finds group by major 
	 * @param name
	 * @param currentGroups
	 * @return ArrayList<Group>
	 */
	public static ArrayList<Group> findGroupByMajor(String name, ArrayList<Group> currentGroups) {
		ArrayList<Group> matchedGroups = new ArrayList<>();
		for (Group group : currentGroups) {
			if (group.getMajorName().toLowerCase().contains(name.toLowerCase())) {
				matchedGroups.add(group);
			}
		}
		return matchedGroups;
	}

	//finds groups by class
	/**
	 * find groups by class 
	 * @param name
	 * @param currentGroups
	 * @return ArrayList<Group>
	 */
	public static ArrayList<Group> findGroupByClass(String name, ArrayList<Group> currentGroups) {
		ArrayList<Group> matchedGroups = new ArrayList<>();
		for (Group group : currentGroups) {
			if (group.getClassName().toLowerCase().contains(name.toLowerCase())) {
				matchedGroups.add(group);
			}
		}
		return matchedGroups;
	}

	//finds groups by building
	/**
	 * find groups by building name 
	 * @param name
	 * @param currentGroups
	 * @return ArrayList<Group>
	 */
	public static ArrayList<Group> findGroupByBuilding(String name, ArrayList<Group> currentGroups) {
		ArrayList<Group> matchedGroups = new ArrayList<>();
		for (Group group : currentGroups) {
			if (group.getLocation().toLowerCase().contains(name.toLowerCase())) {
				matchedGroups.add(group);
			}
		}
		// }
		return matchedGroups;
	}

	/*
	 * public static ArrayList<Group> findGroupComplete(String groupName, String
	 * className, String majorName, String buildingName, ArrayList<Group>
	 * currentGroups) { ArrayList<Group> matchedGroups = new ArrayList<>(); for
	 * (Group group: currentGroups) { if
	 * (group.getLocation().toLowerCase().contains(groupName.toLowerCase())) {
	 * matchedGroups.add(group); return matchedGroups; }
	 */
}