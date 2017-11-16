package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SettingsController extends CommonController{

	
    @FXML private Label emailLabel;
    @FXML private Label userIdLabel;

    /*
     *	These Action events are specific to the Settings
     *	Controller.
     */
    
    @FXML
    void changeEmailButtonPressed(ActionEvent event) {

    }

    @FXML
    void changePasswordButtonPressed(ActionEvent event) {

    }

    @FXML
    void deleteProfileButtonPressed(ActionEvent event) {

    }
    
    /*
     *	These Action events all deal with the Menu bar buttons, and should
     *	be the same across all Controllers, except the login page and account
     *	creation controllers.
     */
        
    @FXML
    void signOutButtonPressed(ActionEvent event) {

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

	@Override
	void on_load() {
		// TODO Auto-generated method stub
	}

}
