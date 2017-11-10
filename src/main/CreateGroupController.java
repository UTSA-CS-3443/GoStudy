package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class CreateGroupController {

	//instance variables which refer to GUI components
    @FXML private TextField roomNumberTextField;
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
