package main;

import java.util.ArrayList;

import groupStruct.Group;
import groupStruct.findGroup;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
/**
 * The controller for the FindAGroup FXML/screen
 * Allows the user to search for groups by group name,
 * class, major, and building
 * @author StephensonA
 *
 */
public class FindAGroupController extends CommonController {

	//instance variables which refer to GUI components
	@FXML private AnchorPane groupDisplayPane;
    @FXML private Label visibilityLabel;
    @FXML private Label ownerLabel;
    @FXML private Label classLabel;
    @FXML private Label openSpotsLabel;
    @FXML private Label meetingTimeLabel;
    @FXML private Label meetingNotesLabel;
    @FXML private Label majorLabel;
    @FXML private Label buildingLabel;
    @FXML private Label totalSpotsLabel;
    @FXML private TextField buildingTextField;
    @FXML private TextField nameTextField;
    @FXML private Label groupNameLabel;
    @FXML private TextField majorTextField;
    @FXML private ListView<Group> foundGroupsListView;
    @FXML private TextField classTextField;  
    
	private ArrayList<Group> matchedGroups;
    
    //findAGroupController ObservableLists
    private final ObservableList<Group> foundGroups = FXCollections.observableArrayList();
	@FXML private Labeled userIdLabel;
    
    /**
     * When EditGroup is displayed...
     * refresh the GroupsListView
     */
    public void on_load(){
    	foundGroupsListView.refresh();
    	userIdLabel.setText(GoStudyMain.user.getUserName());
    };
    
    /**
     * initialize()
     * when FindAGroup is initialized, create a ListView which stores foundGroups.
     * Whenever a change is made, called changed() to set the group information
     * to the selected group
     */
    public void initialize() {
	foundGroupsListView.setItems(foundGroups);
	
	foundGroupsListView.getSelectionModel().selectedItemProperty().addListener(
			new ChangeListener<Group>() {
				@Override
				public void changed(ObservableValue<? extends Group> ov, Group oldValue, Group newValue) {
					groupNameLabel.setText(newValue.getGroupName());
					buildingLabel.setText(newValue.getLocation());
					meetingNotesLabel.setText(newValue.getLocationNotes());
					openSpotsLabel.setText(newValue.getSeatLimit());
					totalSpotsLabel.setText(newValue.getSeatLimit());
					meetingTimeLabel.setText(newValue.getTime());
					classLabel.setText(newValue.getClassName());
					visibilityLabel.setText(newValue.getAccess());
					majorLabel.setText(newValue.getClassName().substring(0,2));
					groupDisplayPane.setVisible(true);
					ownerLabel.setText("Shrek");
				}
			} );
    } 
    
    /*
     *	These Action events are specific to the Find a Group 
     *	Controller.
     */
    
    /**
     * gets the text from the search fields and uses methods in findGroup
     * to search for each of the terms. The final array of groups which is returned
     * is set to foundGroups and findGroupsListView is refreshed. If no groups are found,
     * alert the user.
     * @param event
     */
    @FXML
	void searchButtonPressed(ActionEvent event) {
		// clears the last search
		foundGroups.clear();

		// gets text to search by
		String groupName = nameTextField.getText();
		String className = classTextField.getText();
		String majorName = majorTextField.getText();
		String buildingName = buildingTextField.getText();

		matchedGroups = findGroup.findGroupByName(groupName, GoStudyMain.groupList);
		matchedGroups = findGroup.findGroupByMajor(majorName, matchedGroups);
		matchedGroups = findGroup.findGroupByClass(className, matchedGroups);
		matchedGroups = findGroup.findGroupByBuilding(buildingName, matchedGroups);

		// adds the matched groups, refreshes ListView
		foundGroups.addAll(matchedGroups);
		foundGroupsListView.refresh();
		// }

		Alert noMatches = new Alert(AlertType.INFORMATION);
		noMatches.setHeaderText("No matches were found :(");
		noMatches.setTitle("Sorry");

		// alerts the user no matches were found.
		if (foundGroups.isEmpty())
			noMatches.showAndWait();
	}

    /**
     * clears the text in the search fields and clears foundGroups
     * @param event
     */
    @FXML
    void resetButtonPressed(ActionEvent event) {
    	//clear list of found groups
    	//remove search terms from their respected text fields
    	nameTextField.setText("");
    	majorTextField.setText("");
    	classTextField.setText("");
    	buildingTextField.setText("");
    	foundGroups.clear();
    	foundGroupsListView.refresh();
    	groupDisplayPane.setVisible(false);
    }
    
    /**
     * join the currently selected group, if not already in it
     * @param event
     */
    @FXML
    void joinGroupButtonPressed(ActionEvent event) {
    	//should check to see if they are apart of the group before adding them
    	//System.out.println(GoStudyMain.selectedGroup.getGroupName());
    	System.out.println(groupNameLabel.getText());
    	Group group = new Group();
    	group.setFileName(Group.stringToFileName(groupNameLabel.getText()));
    	boolean b = group.joinGroup(GoStudyMain.user);
    	if (b == false)
    		System.out.println("JOIN FAILURE!!");
    	Alert joinSuccess = new Alert(AlertType.INFORMATION);
    	joinSuccess.setHeaderText("Successfully joined group!");
    	joinSuccess.setTitle("Success");
    	joinSuccess.show();
    	
    	Alert joinFailure = new Alert(AlertType.ERROR);
    	joinFailure.setHeaderText("You are already in this group.");
    	joinFailure.setTitle("Failure");
    	//joinFailure.show();
    }
    
    
    /*
     *	These Action events all deal with the Menu bar buttons, and should
     *	be the same across all Controllers, except the login page and account
     *	creation controllers.
     */
    
    /**
     * changes to the MyGroups screen
     */
    @FXML
    void myGroupButtonPressed(ActionEvent event) {
    	GoStudyMain.new_child("MyGroups");
    }
    
    /**
     * changes to the FindAGroup screen
     */
    @FXML
    void findAGroupButtonPressed(ActionEvent event) {
    	GoStudyMain.new_child("FindAGroup");
    }
    
    /**
     * changes screen to CreateGroup
     */
    @FXML
    void createAGroupButtonPressed(ActionEvent event) {
    	GoStudyMain.new_child("CreateGroup");
    }


    /**
     * changes screen to Map
     */
    @FXML
    void mapButtonPressed(ActionEvent event) {
    	GoStudyMain.new_child("Map");
    }


    /**
     * changes screen to Settings
     */
    @FXML
    void settingsButtonPressed(ActionEvent event) {
    	GoStudyMain.new_child("Settings");
    }
    
    /**
     * changes screen to Login
     * @param event
     */
    @FXML 
    void signOutButtonPressed(ActionEvent event) {
    	GoStudyMain.new_child("Login");
    }
}
