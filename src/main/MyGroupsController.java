package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
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

    /*
     *	These Action events are specific to the Find a Group
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

    }

    //handles Settings button pressed Action Event
    @FXML
    void settingsButtonPressed(ActionEvent event) {

    }
}
