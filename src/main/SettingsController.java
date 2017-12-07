package main;

import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import users.User;
import javafx.scene.control.Alert.AlertType;
/**
 * 
 * @author Annie Stephenson
 * @author Gloria Trevino - only for the change password
 * 
 * Controller for the settings
 *
 */

public class SettingsController extends CommonController{

    @FXML private Label userIdLabel;
    @FXML private PasswordField passwordTextField;
	@FXML private Labeled userIdLabel2;
    

    /*
     *	These Action events are specific to the Settings
     *	Controller.
     */

	/**
	 * changes the user's password
	 * @param event
	 */
    @FXML
    void changePasswordButtonPressed(ActionEvent event) {
    		String newPassword = passwordTextField.getText();
    		String Username = "annie";
    		User user = new User();
    		int boo = user.changePassword(newPassword, Username);
    		System.out.println(boo);
    		if(boo == 1){
    	
    			Alert confirm = new Alert(AlertType.CONFIRMATION);
    			confirm.setHeaderText("Stop changing your password... it was changed.");
    			confirm.setTitle("User Confirmation");
    			confirm.show();
    		}
    }

    /**
     * delete's the user's account
     * @param event
     */
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
    	GoStudyMain.new_child("Login");
    	
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
     * changes screen to CreateAGroup
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

    /**
     * when settings screen is loaded, do nothing
     */
	@Override
	void on_load() {

		userIdLabel.setText(GoStudyMain.user.getUserName());
		userIdLabel2.setText(GoStudyMain.user.getUserName());
		// TODO Auto-generated method stub


	}

}
