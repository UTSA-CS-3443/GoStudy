package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class CreateGroupController {
	
	//an incomplete list of majors which can be used later ensure a valid major is entered.
		/*
		* 	"AIS","ACC","MATE","ASC","AFS","AAS","AMS","ANT","AIM","ARA","ARC","ART","AHC","AST","BBL","BIO","BME",
		*	"BLW","BOH","CME","CHE","CHN","CE","CLA","CSS","COA","COM","CSH","CPE","CS","CSM","COU","CRJ","CRJ","C&I","DAN","DA","DEM","ECE",
		*	"EDU","EDL","EDP","EE","EGR","ENG","ESL","EIS","ENT","ES","ES","FACT","FM","FIN","FL","FRN","GBA","GEM","GRG","GES","GEO","GER",
		*	"GLA","GSL","GRK","HTH","HSA","HIS","HON"
		*/

	//instance variables which refer to GUI components
    @FXML private TextField meetingAreaTextField;
    @FXML private TextField spotsAvailableTextField;
    @FXML private TextField meetingTimeTextBox;
    @FXML private TextField buildingTextField;
    @FXML private TextField groupNameTextField;
    @FXML private TextField classTextField;
    @FXML private TextArea emailInvitesTextArea;
    @FXML private RadioButton publicRadioButton;
    @FXML private RadioButton privateRadioButton;
    @FXML private ChoiceBox<?> majorChoiceBox;
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
    @FXML private Label errRoomNumber;
    @FXML private Label errVisibility;
    @FXML private Label errClass;
    
    /*
     *	These Action events are specific to the Create Group 
     *	Controller.
     */

    //handles the public radio button pressed Action Event
    @FXML
    void publicRadioButtonPressed(ActionEvent event) {

    }

    //handles the private radio button pressed Action Event
    @FXML
    void privateRadioButtonPressed(ActionEvent event) {

    }

    //handles the create button pressed Action Event
    @FXML
    void createButtonPressed(ActionEvent event) {
    	//should probably parse each text field, and alert user if entered incorrectly
    	//otherwise, create a group struct with provided info
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

    }
    
    //handles Settings button pressed Action Event
    @FXML
    void settingsButtonPressed(ActionEvent event) {

    }
}