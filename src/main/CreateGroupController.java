package main;


import groupStruct.Group;
import groupStruct.GroupFileEdit;
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
 * The controller for the CreateGroup FXML/screen
 * It gathers information from the user to create a new group
 * @author StephensonA
 *
 */
public class CreateGroupController extends CommonController {
	
	//an incomplete list of majors which can be used later ensure a valid major is entered.
		/*
		* 	"AIS","ACC","MATE","ASC","AFS","AAS","AMS","ANT","AIM","ARA","ARC","ART","AHC","AST","BBL","BIO","BME",
		*	"BLW","BOH","CME","CHE","CHN","CE","CLA","CSS","COA","COM","CSH","CPE","CS","CSM","COU","CRJ","CRJ","C&I","DAN","DA","DEM","ECE",
		*	"EDU","EDL","EDP","EE","EGR","ENG","ESL","EIS","ENT","ES","ES","FACT","FM","FIN","FL","FRN","GBA","GEM","GRG","GES","GEO","GER",
		*	"GLA","GSL","GRK","HTH","HSA","HIS","HON"
		*/

	//instance variables which refer to GUI components
    @FXML private TextArea meetingNotesTextArea;
    @FXML private TextField spotsAvailableTextField;
    @FXML private TextField meetingTimeTextBox;
    @FXML private TextField buildingTextField;
    @FXML private TextField groupNameTextField;
    @FXML private TextField classTextField;
    @FXML private TextField majorTextField;
    @FXML private TextArea emailInvitesTextArea;
    @FXML private RadioButton publicRadioButton;
    @FXML private RadioButton privateRadioButton;
    @FXML private Label userIdLabel;
    @FXML private ToggleGroup visibilityToggleGroup;
    
    //labels which can be set to visible in case there is an issue creating a group,
    //and an error needs to be displayed to the user
    @FXML private Label errMajor;
    @FXML private Label errBuilding;  
    @FXML private Label errMeetingtime;
    @FXML private Label errSpots;
    @FXML private Label errGroupName;
    @FXML private Label errEmail;
    @FXML private Label errVisibility;
    @FXML private Label errClass;
    @FXML private Label errRoomNumber;
    

    public void on_load(){
    	userIdLabel.setText(GoStudyMain.user.getUserName());
    };
    
    /**
     *	These Action events are specific to the Create Group 
     *	Controller.
     */

    /**handles the public radio button pressed Action Event*/
    @FXML
    void publicRadioButtonPressed(ActionEvent event) {
    	//these actually don't need to do anything
    }

    /**handles the private radio button pressed Action Event*/
    @FXML
    void privateRadioButtonPressed(ActionEvent event) {
    	//these actually don't need to do anything
    }

    /**
     * handles the create button pressed Action Event
     * Gathers information from the CreateGroup screen,
     * creates a new Group from the information and shows
     * an alert to the user if the groups was successfully
     * created
     */
    @FXML
    void createButtonPressed(ActionEvent event) {
    	//should probably parse each text field, and alert user if entered incorrectly
    	//otherwise, create a group struct with provided info
    	String access;
    	if (privateRadioButton.isSelected())
    		access = "PRIVATE";
    	else
    		access = "PUBLIC";
    	Group newGroup = Group.newGroup(groupNameTextField.getText(), classTextField.getText(), majorTextField.getText(), buildingTextField.getText()
    			, meetingNotesTextArea.getText(), meetingTimeTextBox.getText(), access, spotsAvailableTextField.getText());
    	User user = GoStudyMain.user;
    	//user.setUserName("pablo_migo");
    	GroupFileEdit.createGroupFile(newGroup, user);

    	
    	Alert createSuccess = new Alert(AlertType.INFORMATION);
    	createSuccess.setHeaderText("Successfully created group!");
    	createSuccess.setTitle("Success");
    	createSuccess.showAndWait();
    	GoStudyMain.new_child("MyGroups");
    	
    	Alert createFailure = new Alert(AlertType.ERROR);
    	createFailure.setHeaderText("Group could not be created.");
    	createFailure.setTitle("Failure");
    	//createFailure.show();
    	}
    
    /**
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
