package main;

import groupStruct.Group;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
/**
 * The controller for the Group FXML/screen
 * When the user selects a group from the Map screen,
 * it takes them here. Displays group data and has a button for
 * the user to join the group.
 * @author StephensonA
 *
 */
/**
 * @author steph
 *
 */
/**
 * @author steph
 *
 */
public class GroupController extends CommonController{

    @FXML private Label groupNameLabel;
    @FXML private Label visibilityLabel;
    @FXML private Label ownerLabel;
    @FXML private Label classLabel;
    @FXML private Label majorLabel;
    @FXML private Label meetingNotesLabel;
    @FXML private Label buildingLabel;
    @FXML private Label totalSpotsLabel;
    @FXML private Label openSpotsLabel;
    @FXML private AnchorPane groupDisplayPane;
    @FXML private Label meetingTimeLabel;
	@FXML private Labeled userIdLabel;
    
    private static Group newValue;

    public void on_load() {
    	userIdLabel.setText(GoStudyMain.user.getUserName());
		groupNameLabel.setText(newValue.getGroupName());
		buildingLabel.setText(newValue.getLocation());
		meetingNotesLabel.setText(newValue.getLocationNotes());
		openSpotsLabel.setText(newValue.getSeatLimit());
		totalSpotsLabel.setText(newValue.getSeatLimit());
		meetingTimeLabel.setText(newValue.getTime());
		classLabel.setText(newValue.getClassName());
		visibilityLabel.setText(newValue.getAccess());
		majorLabel.setText(newValue.getMajorName());
		groupDisplayPane.setVisible(true);
		ownerLabel.setText("Shrek");
    }
    
    /**
     * sets newValue to be equal to the group passed to it
     * @param mapGroup
     */
    public static void getMapGroup(Group mapGroup) {
    	newValue = mapGroup;
    }
    
    
    /**
     * join the currently selected group, if not already in it
     * @param event
     */
    @FXML
    void joinGroupButtonPressed(ActionEvent event) {
    	//should check to see if they are apart of the group before adding them
    	//System.out.println("HELELELELELELEEOLOLOL");
    	
    	Alert joinSuccess = new Alert(AlertType.INFORMATION);
    	joinSuccess.setHeaderText("Successfully joined group!");
    	joinSuccess.setTitle("Success");
    	joinSuccess.show();
    	
    	Alert joinFailure = new Alert(AlertType.ERROR);
    	joinFailure.setHeaderText("You are already in this group.");
    	joinFailure.setTitle("Failure");
    	//joinFailure.show();
    }    
    
    /**
     * changes screen to Login
     */
    @FXML
    void signOutButtonPressed(ActionEvent event) {
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
