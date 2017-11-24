package main;

import groupStruct.Group;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;

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
    	userIdLabel.setText("Annie");
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
    
    public static void getMapGroup(Group mapGroup) {
    	newValue = mapGroup;
    }
    
    @FXML
    void joinGroupButtonPressed(ActionEvent event) {
    	//should check to see if they are apart of the group before adding them
    	Alert joinSuccess = new Alert(AlertType.INFORMATION);
    	joinSuccess.setHeaderText("Successfully joined group!");
    	joinSuccess.setTitle("Success");
    	joinSuccess.show();
    	
    	Alert joinFailure = new Alert(AlertType.ERROR);
    	joinFailure.setHeaderText("You are already in this group.");
    	joinFailure.setTitle("Failure");
    	//joinFailure.show();
    }    
    
    
    @FXML
    void signOutButtonPressed(ActionEvent event) {
    	GoStudyMain.new_child("Login");
    }

    @FXML
    void myGroupButtonPressed(ActionEvent event) {
    	GoStudyMain.new_child("MyGroups");
    }

    @FXML
    void findAGroupButtonPressed(ActionEvent event) {
    	GoStudyMain.new_child("FindAGroup");
    }

    @FXML
    void createAGroupButtonPressed(ActionEvent event) {
    	GoStudyMain.new_child("CreateGroup");
    }

    @FXML
    void mapButtonPressed(ActionEvent event) {
    	GoStudyMain.new_child("Map");
    }

    @FXML
    void settingsButtonPressed(ActionEvent event) {
    	GoStudyMain.new_child("Settings");
    }
}
