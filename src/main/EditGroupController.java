	package main;

import groupStruct.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import users.User;
import javafx.scene.control.Alert.AlertType;

/**
 * The controller for the EditGroup FXML/screen
 * It gathers information from the user to edit a specific group
 * @author StephensonA
 *
 */
public class EditGroupController extends CommonController{
	
	//instance variables which refer to GUI components
    @FXML private ToggleGroup visibilityToggleGroup;
    @FXML private TextField majorTextField;
    @FXML private TextField buildingTextField;
    @FXML private TextField groupNameTextField;
    @FXML private TextField spotsAvailableTextField;
    @FXML private TextField meetingTimeTextField;
    @FXML private TextField classTextField;
    @FXML private TextArea meetingNotesTextArea;
    @FXML private Label userIdLabel;
    @FXML private RadioButton publicRadioButton;
    @FXML private RadioButton privateRadioButton;

    //Labels for telling the user they entered something incorrectly
    @FXML private Label errRoomNumber;
    @FXML private Label errVisibility;
    @FXML private Label errMeetingtime;
    @FXML private Label errSpots;
    @FXML private Label errGroupName;
    @FXML private Label errClass;
    @FXML private Label errMajor;
    @FXML private Label errBuilding;
    
    
    /**
     * When EditGroup is displayed...
     * displays data from the selected group from MyGroups
     */
    public void on_load() {
    	groupNameTextField.setText(GoStudyMain.selectedGroup.getGroupName());
    	majorTextField.setText(GoStudyMain.selectedGroup.getMajorName());
    	classTextField.setText(GoStudyMain.selectedGroup.getClassName());
    	meetingTimeTextField.setText(GoStudyMain.selectedGroup.getTime());
    	buildingTextField.setText(GoStudyMain.selectedGroup.getLocation());
    	meetingNotesTextArea.setText(GoStudyMain.selectedGroup.getLocationNotes());
    	spotsAvailableTextField.setText(GoStudyMain.selectedGroup.getSeatLimit());
    	if(GoStudyMain.selectedGroup.getAccess().equals("PUBLIC"))
    		publicRadioButton.setSelected(true);
    	else
    		privateRadioButton.setSelected(true);
    }
    /*
     *	These Action events are specific to the Edit Group 
     *	Controller.
     */

    @FXML
    void publicRadioButtonPressed(ActionEvent event) {
    	//Doesn't need to do anything
    }

    @FXML
    void privateRadioButtonPressed(ActionEvent event) {
    	//Doesn't need to do anything
    }

    /**
     * handles the editButtonPressed Action Event
     * Gathers information from the EditGroup screen,
     * edits the group data, and shows
     * an alert to the user if the groups was successfully
     * edited
     */
    @FXML
    void editButtonPressed(ActionEvent event) {
    	String access;
    	if (privateRadioButton.isSelected())
    		access = "PRIVATE";
    	else
    		access = "PUBLIC";
    	//creates edited group
    	Group editedGroup = Group.newGroup(groupNameTextField.getText(), classTextField.getText(), majorTextField.getText(), buildingTextField.getText()
    			, meetingNotesTextArea.getText(), meetingTimeTextField.getText(), access, spotsAvailableTextField.getText());
    	User user = new User();
    	user.setUserName("pablo_migo");
    	GroupFileEdit.editGroup(GoStudyMain.selectedGroup, editedGroup, user);
    	
    	Alert editSuccess = new Alert(AlertType.INFORMATION);
    	editSuccess.setHeaderText("Successfully edited group!");
    	editSuccess.setTitle("Success");
    	editSuccess.showAndWait();
    	GoStudyMain.new_child("MyGroups");
    	
    	Alert editFailure = new Alert(AlertType.ERROR);
    	editFailure.setHeaderText("Group could not be edited.");
    	editFailure.setTitle("Failure");
    	//editFailure.show();
    }
    
    /*
     *	These Action events all deal with the Menu bar buttons, and should
     *	be the same across all Controllers, except the login page and account
     *	creation controllers.
     */
     
    /**
     * handles SignOut button pressed ActionEvent
     * changes to the Login screen
     */
    @FXML
    void signOutButtonPressed(ActionEvent event) {
    	GoStudyMain.new_child("Login");
    }
    
    /**
     * handles My Groups button pressed ActionEvent
     * changes to the MyGroups screen
     */
    @FXML
    void myGroupButtonPressed(ActionEvent event) {
    	GoStudyMain.new_child("MyGroups");
    }
    
    /**
     * handles Find a Group button pressed ActionEvent
     * changes screen to FindAGroup
     */
    @FXML
    void findAGroupButtonPressed(ActionEvent event) {
    	GoStudyMain.new_child("FindAGroup");
    }


    /**
     * handles Create a Group button pressed ActionEvent
     * changes screen to CreateGroup
     */
    @FXML
    void createAGroupButtonPressed(ActionEvent event) {
    	GoStudyMain.new_child("CreateGroup");
    }


    /**
     * handles Map Button pressed ActionEvent
     * changes screen to Map
     */
    @FXML
    void mapButtonPressed(ActionEvent event) {
    	GoStudyMain.new_child("Map");
    }

    /**
     * handles Settings button pressed Action Event
     * changes screen to settings
     */
    @FXML
    void settingsButtonPressed(ActionEvent event) {
    	GoStudyMain.new_child("Settings");
    }

}
