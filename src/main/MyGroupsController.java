package main;

import java.util.Optional;

import groupStruct.Group;
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
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

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
    

	@Override
	void on_load() {
		userIdLabel.setText("Annie");
		ownGroupListView.refresh();
		apartOfGroupListView.refresh();
		groupInfoAnchorPane.setVisible(false);
	}
    
    //initialize controller
    public void initialize(){
    	//creates ObservableList for Owned Groups
    	//change this to GoStudyMain.groupList to array of user's created groups
    	myGroups.addAll(GoStudyMain.groupList);
    	
    	ownGroupListView.setItems(myGroups);
    	
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
    					majorLabel.setText(newValue.getClassName().substring(0,2));
    					ownerHBox.setVisible(true);
    					apartOfHBox.setVisible(false);
    					groupInfoAnchorPane.setVisible(true);
    					GoStudyMain.selectedGroup = newValue;
    				}
    			} );
    	
    	//creates observableList for Groups the user is apart of
    	//change GoStudyMain.groupList to array of groups the user is in.
    	otherGroups.addAll(GoStudyMain.groupList);
    	
    	apartOfGroupListView.setItems(myGroups);
    	
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
    					majorLabel.setText(newValue.getClassName().substring(0,2));
    					ownerHBox.setVisible(false);
    					apartOfHBox.setVisible(true);
    					groupInfoAnchorPane.setVisible(true);
    				}
    			} );
    }
    
    
    /*
     *	These Action events are specific to the My Groups
     *	Controller.
     */

    /*
     * Probably will not be implemented, leaving here though just in case
    @FXML
    void sendInvitesButtonPressed(ActionEvent event) {
    	TextInputDialog sendInvites = new TextInputDialog();
    	sendInvites.setHeaderText("Enter emails, separated by commas");
    	sendInvites.setTitle("Send Invites");
    	
    	Optional<String> emails = sendInvites.showAndWait();
    	System.out.print(emails);						//will return in the format "Optional[whateverUserEntered]"
    	System.out.print(emails.isPresent());			//will return true if the user hit "OK" or false if "cancel"
    	
    	//have a method to parse emails. if parsed successfully. return the success message. otherwise show failure.
    	Alert sendSuccess = new Alert(AlertType.INFORMATION);
    	sendSuccess.setHeaderText("Successfully sent emails");
    	sendSuccess.setTitle("Success");
    	sendSuccess.show();
    	
    	Alert sendFailure = new Alert(AlertType.ERROR);
    	sendFailure.setHeaderText("Failed to send emails");
    	sendFailure.setTitle("Failure");
    	//sendFailure.show();
    }
    */

    @FXML
    void editGroupButtonPressed(ActionEvent event) {
    	//takes you to group edit screen
    	GoStudyMain.new_child("EditGroup");
    }

    @FXML
    void deleteGroupButtonPressed(ActionEvent event) {
    	Alert confirm = new Alert(AlertType.CONFIRMATION);
    	confirm.setHeaderText("Delete this group?");
    	
    	Optional<ButtonType> result = confirm.showAndWait();
    	if(result.isPresent() && result.get() == ButtonType.OK) {
    		//delete the group
    		on_load();
    	}
    	
    }
    
    @FXML
    void leaveGroupButtonPressed(ActionEvent event) {
    	Alert confirm = new Alert(AlertType.CONFIRMATION);
    	confirm.setHeaderText("Leave this group?");
    	confirm.setTitle("User Confirmation");
    	
    	Optional<ButtonType> result = confirm.showAndWait();
    	if(result.isPresent() && result.get() == ButtonType.OK) {
    		//remove user from group(?) 
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

    //handles SignOut button pressed ActionEvent
    @FXML
    void signOutButtonPressed(ActionEvent event) {
    	//should change views to the login page
    	GoStudyMain.new_child("Login");
    }

    //handles My Groups button pressed ActionEvent
    @FXML
    void myGroupButtonPressed(ActionEvent event) {
    	GoStudyMain.new_child("MyGroups");
    }
    
    //handles Find a Group button pressed ActionEvent
    @FXML
    void findAGroupButtonPressed(ActionEvent event) {
    	GoStudyMain.new_child("FindAGroup");
    }

    //handles Create a Group button pressed ActionEvent
    @FXML
    void createAGroupButtonPressed(ActionEvent event) {
    	GoStudyMain.new_child("CreateGroup");
    }

    //handles Map Button pressed ActionEvent
    @FXML
    void mapButtonPressed(ActionEvent event) {
    	GoStudyMain.new_child("Map");
    }

    //handles Settings button pressed Action Event
    @FXML
    void settingsButtonPressed(ActionEvent event) {
    	GoStudyMain.new_child("Settings");
    }

}
