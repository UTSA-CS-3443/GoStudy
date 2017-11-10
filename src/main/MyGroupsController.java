package main;

import groupStruct.Group;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;

public class MyGroupsController {

	@FXML private HBox ownerHBox;
    @FXML private Label visibilityLabel;
    @FXML private Label ownerLabel;
    @FXML private Label classLabel;
    @FXML private Label buildingLabel;
    @FXML private Label majorLabel;
    @FXML private Label meetingAreaLabel;
    @FXML private Label totalSpotsLabel;
    @FXML private Label openSpotsLabel;
    @FXML private Label meetingTimeLabel;
    @FXML private Label groupNameLabel;
    @FXML private ListView<Group> apartOfGroupListView;
    @FXML private ListView<Group> ownGroupListView;

    //myGroupController ObservableLists
    private final ObservableList<Group> myGroups = FXCollections.observableArrayList();
    private final ObservableList<Group> otherGroups = FXCollections.observableArrayList();
    
    //initialize controller
    public void initialize() {
    	
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
    					meetingAreaLabel.setText(newValue.getLocationNotes());
    					openSpotsLabel.setText(newValue.getSeatLimit());
    					totalSpotsLabel.setText(newValue.getSeatLimit());
    					meetingTimeLabel.setText(newValue.getTime());
    					classLabel.setText(newValue.getClassName());
    					visibilityLabel.setText(newValue.getAccess());
    					majorLabel.setText(newValue.getClassName().substring(0,2));
    					ownerHBox.setVisible(true);
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
    					meetingAreaLabel.setText(newValue.getLocationNotes());
    					openSpotsLabel.setText(newValue.getSeatLimit());
    					totalSpotsLabel.setText(newValue.getSeatLimit());
    					meetingTimeLabel.setText(newValue.getTime());
    					classLabel.setText(newValue.getClassName());
    					visibilityLabel.setText(newValue.getAccess());
    					majorLabel.setText(newValue.getClassName().substring(0,2));
    					ownerHBox.setVisible(false);
    				}
    			} );
    }
    
    
    
    /*
     *	These Action events are specific to the My Groups
     *	Controller.
     */

    @FXML
    void sendInvitesButtonPressed(ActionEvent event) {

    }

    @FXML
    void editGroupButtonPressed(ActionEvent event) {

    }

    @FXML
    void deleteGroupButtonPressed(ActionEvent event) {

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

    }
}
