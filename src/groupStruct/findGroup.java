package groupStruct;

import java.util.ArrayList;

public class findGroup {
			// hey sam!
			// BC matched groups is a new array every time, it will not get the previous results from current
			// groups... so if user searches by nothing, NOTHING will be passed for the next search to look
			// into. searches needs to be changed somehow so that the current groups will be added to matched
			// groups if the name is "".
			// my recommendation is have it so the check for "" is inside the for loop,
			// and add groups that match name or "".
			// you could also have matchedGroups.addAll(currentGroups) and remove those that dont match or are "".
			// either one works.
			// -Annie
			// P.S. i added a check in findAGroup so that if the user presses search when all text fields are
			// empty it will not search, so you dont need to worry about accidentally returning all groups
			// if nothing is searched for.
	public static ArrayList<Group> findGroupByName(String name, ArrayList<Group> currentGroups) {
		ArrayList<Group> matchedGroups = new ArrayList<>();
		// if (!name.equals("")) {
		for (Group group : currentGroups) {
			if (group.getGroupName().toLowerCase().contains(name.toLowerCase())) {
				matchedGroups.add(group);
			}
		}
		// }
		return matchedGroups;
	}

	public static ArrayList<Group> findGroupByMajor(String name, ArrayList<Group> currentGroups) {
		ArrayList<Group> matchedGroups = new ArrayList<>();
		// if (!name.equals("")) {
		for (Group group : currentGroups) {
			if (group.getMajorName().toLowerCase().contains(name.toLowerCase())) {
				matchedGroups.add(group);
			}
		}
		return matchedGroups;
	}

	public static ArrayList<Group> findGroupByClass(String name, ArrayList<Group> currentGroups) {
		ArrayList<Group> matchedGroups = new ArrayList<>();
		// if (!name.equals("")) {
		for (Group group : currentGroups) {
			if (group.getClassName().toLowerCase().contains(name.toLowerCase())) {
				matchedGroups.add(group);
			}
		}
		// }
		return matchedGroups;
	}

	public static ArrayList<Group> findGroupByBuilding(String name, ArrayList<Group> currentGroups) {
		ArrayList<Group> matchedGroups = new ArrayList<>();
		// if (!name.equals("")) {
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