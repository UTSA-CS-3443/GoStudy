package main;
//MAIN!!!!!!
import java.util.Optional;

import groupStruct.FileRead;
import groupStruct.Group;
import groupStruct.GroupFileEdit;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import users.User;

/**
 * controller for the MyGroups controller. handles the display of all the groups
 * the user owns and is apart of.
 * @author StephensonA
 *
 */
public class MyGroupsController extends CommonController{

	public static Group selectedGroup;		//the currently selected group.
	
	@FXML private HBox ownerHBox;
    @FXML private HBox apartOfHBox;
    @FXML private Label visibilityLabel;
    @FXML private Label ownerLabel;
    @FXML private Label classLabel;
    @FXML private Label buildingLabel;
    @FXML private Label majorLabel;
    @FXML private Label meetingNotesLabel;
    @FXML private Label totalSpotsLabel;
    @FXML private Label openSpotsLabel;
    @FXML private Label meetingTimeLabel;
    @FXML private Label groupNameLabel;
    @FXML private ListView<Group> apartOfGroupListView;
    @FXML private ListView<Group> ownGroupListView;
    @FXML private AnchorPane groupInfoAnchorPane;
    @FXML private Labeled userIdLabel;

    //myGroupController ObservableLists
    private final ObservableList<Group> myGroups = FXCollections.observableArrayList();
    private final ObservableList<Group> otherGroups = FXCollections.observableArrayList();
    
    /**
     * when this screen is loaded, construct the file list, clear
     * myGroups and otherGroups, and re-populate them with the new file list.
     * refresh both listViews.
     */
	@Override
	void on_load() {
		GoStudyMain.groupList = FileRead.constructList();
		userIdLabel.setText(GoStudyMain.user.getUserName());
		//groupInfoAnchorPane.setVisible(false);
		myGroups.clear();
		otherGroups.clear();
		
		myGroups.addAll(GoStudyMain.user.ownedGroups(GoStudyMain.groupList));
		ownGroupListView.setItems(myGroups);
		//myGroups.addAll(GoStudyMain.groupList);
		//otherGroups.addAll(GoStudyMain.groupList);
		otherGroups.addAll(GoStudyMain.user.memberedGroups(GoStudyMain.groupList));
		apartOfGroupListView.setItems(otherGroups);
    	
		ownGroupListView.refresh();
		apartOfGroupListView.refresh();
		groupInfoAnchorPane.setVisible(false);
	}
    
	/**
	 * On initialization, create two ListViews, one for group's the user
	 * owns, and another for groups the user is apart of. Update them the groupInfo
	 * panel with whichever group is currently selected.
	 */
    //initialize controller
    public void initialize(){
    	//creates ObservableList for Owned Groups
    	//change this to GoStudyMain.groupList to array of user's created groups
    	//ownGroupListView.setItems(myGroups);
    	
    	ownGroupListView.getSelectionModel().selectedItemProperty().addListener(
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
    					majorLabel.setText(newValue.getMajorName());
    					ownerHBox.setVisible(true);
    					apartOfHBox.setVisible(false);
    					groupInfoAnchorPane.setVisible(true);
    					GoStudyMain.selectedGroup = newValue;
    					apartOfGroupListView.getSelectionModel().select(-1);
    					//TODO temp fix for demo video
    					ownerLabel.setText(newValue.getGroupOwner().getUserName());
    				}
    			} );
    	
    	//creates observableList for Groups the user is apart of
    	//change GoStudyMain.groupList to array of groups the user is in.
    	//apartOfGroupListView.setItems(myGroups);
    	
    	apartOfGroupListView.getSelectionModel().selectedItemProperty().addListener(
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
    					majorLabel.setText(newValue.getMajorName());
    					ownerHBox.setVisible(false);
    					apartOfHBox.setVisible(true);
    					groupInfoAnchorPane.setVisible(true);
    					ownGroupListView.getSelectionModel().select(-1);
    					//TODO temp fix for demo video
    					ownerLabel.setText("Shrek");
    				}
    			} );
    }
    
    
    /*
     *	These Action events are specific to the My Groups
     *	Controller.
     */

    /**
     * takes user to the groupEdit page
     * @param event
     */
    @FXML
    void editGroupButtonPressed(ActionEvent event) {
    	//takes you to group edit screen
    	GoStudyMain.new_child("EditGroup");
    }

    /**
     * Deletes the group the user has selected
     * @param event
     */
    @FXML
    void deleteGroupButtonPressed(ActionEvent event) {
    	Alert confirm = new Alert(AlertType.CONFIRMATION);
    	confirm.setHeaderText("Delete this group?");
    	
    	Optional<ButtonType> result = confirm.showAndWait();
    	if(result.isPresent() && result.get() == ButtonType.OK) {
    		String  name = groupNameLabel.getText();
    		String fileName = Group.stringToFileName(name);
    		Group group = new Group();
    		group.setFileName(fileName);
    		User user = new User();
    		user.setUserName("empty");
    		GroupFileEdit.deleteGroupFile(group, user);
    		//delete the group
    		on_load();
    	}
    	
    }
    
    /**
     * gets user confirmation to leave Group, and removes user
     * from Group, and alerts if the the removal was successful for not.
     * @param event
     */
    @FXML
    void leaveGroupButtonPressed(ActionEvent event) {
    	Alert confirm = new Alert(AlertType.CONFIRMATION);
    	confirm.setHeaderText("Leave this group?");
    	confirm.setTitle("User Confirmation");
    	
    	Optional<ButtonType> result = confirm.showAndWait();
    	if(result.isPresent() && result.get() == ButtonType.OK) {
    		Group group = null;
    		for (Group group1: otherGroups) {
    			if (group1.getGroupName().equals(groupNameLabel.getText()))
    				group = group1;
    		}
        	
        	boolean b = group.leaveGroup(GoStudyMain.user);
        	if (b == false)
        		System.out.println("LEAVE GROUPS FAILED");
    	}
    	

    	Alert changeSuccess = new Alert(AlertType.INFORMATION);
    	changeSuccess.setHeaderText("Successfully left group");
    	changeSuccess.setTitle("Success");
    	changeSuccess.show();
    	
    	Alert changeFailure = new Alert(AlertType.ERROR);
    	changeFailure.setHeaderText("Failed to leave group.");
    	changeFailure.setTitle("Failure");
    	//changeFailure.show();
    	
    }
    
    /*
    *	These Action events all deal with the Menu bar buttons, and should
    *	be the same across all Controllers, except the login page and account
    *	creation controllers.
    */

    /**
     * changes screen to Login
     */
    @FXML
    void signOutButtonPressed(ActionEvent event) {
    	//should change views to the login page
    	GoStudyMain.new_child("Login");
    }

    /**
     * changes screen to MyGroups
     */
    @FXML
    void myGroupButtonPressed(ActionEvent event) {
    	GoStudyMain.new_child("MyGroups");
    }
    
    /**
     * changes screen to FindAGroup
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

}
