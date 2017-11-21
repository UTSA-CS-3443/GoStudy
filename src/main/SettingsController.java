package main;

import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class SettingsController extends CommonController{

	
    @FXML private Label emailLabel;
    @FXML private Label userIdLabel;
    @FXML private TextField emailTextField;
    @FXML private PasswordField passwordTextField;

    /*
     *	These Action events are specific to the Settings
     *	Controller.
     */
    
    @FXML
    void changeEmailButtonPressed(ActionEvent event) {
    	//have a method to parse  the email. if parsed successfully. return the success message. otherwise show failure.
    	Alert changeSuccess = new Alert(AlertType.INFORMATION);
    	changeSuccess.setHeaderText("Successfully changed your email");
    	changeSuccess.setTitle("Success");
    	changeSuccess.show();
    	
    	Alert changeFailure = new Alert(AlertType.ERROR);
    	changeFailure.setHeaderText("Failed to change your email");
    	changeFailure.setTitle("Failure");
    	//changeFailure.show();
    }

    @FXML
    void changePasswordButtonPressed(ActionEvent event) {
    	Alert confirm = new Alert(AlertType.CONFIRMATION);
    	confirm.setHeaderText("You cant change your password >:(");
    	confirm.setTitle("User Confirmation");
    	confirm.show();
    }

    @FXML
    void deleteProfileButtonPressed(ActionEvent event) {
    	Alert confirm = new Alert(AlertType.CONFIRMATION);
    	confirm.setHeaderText("Delete your account?");
    	confirm.setTitle("User Confirmation");
    	
    	Optional<ButtonType> result = confirm.showAndWait();
    	if(result.isPresent() && result.get() == ButtonType.OK) {
    		//delete user
    		on_load();
    	}
    	
    	Alert sendSuccess = new Alert(AlertType.INFORMATION);
    	sendSuccess.setHeaderText("Successfully deleted your account. We didn't like you anyway!! ;` - `; ");
    	sendSuccess.setTitle("Success");
    	sendSuccess.showAndWait();
    	
    	Alert sendFailure = new Alert(AlertType.ERROR);
    	sendFailure.setHeaderText("Failed to send emails");
    	sendFailure.setTitle("Failure");
    	//sendFailure.show();
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