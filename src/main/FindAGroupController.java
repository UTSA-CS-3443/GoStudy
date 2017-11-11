package main;

import groupStruct.Group;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;

public class FindAGroupController {

	//instance variables which refer to GUI components
	@FXML private AnchorPane groupDisplayPane;
    @FXML private Label visibilityLabel;
    @FXML private Label ownerLabel;
    @FXML private Label classLabel;
    @FXML private Label openSpotsLabel;
    @FXML private Label meetingTimeLabel;
    @FXML private Label meetingNotesLabel;
    @FXML private Label majorLabel;
    @FXML private Label buildingLabel;
    @FXML private Label totalSpotsLabel;
    @FXML private TextField buildingTextField;
    @FXML private TextField nameTextField;
    @FXML private Label groupNameLabel;
    @FXML private TextField majorTextField;
    @FXML private ListView<Group> foundGroupsListView;
    @FXML private TextField classTextField;  
    
    //findAGroupController ObservableLists
    private final ObservableList<Group> foundGroups = FXCollections.observableArrayList();
    
    public void initialize() {
    foundGroups.addAll(GoStudyMain.groupList);
	
	foundGroupsListView.setItems(foundGroups);
	
	foundGroupsListView.getSelectionModel().selectedItemProperty().addListener(
			new ChangeListener<Group>() {
				@Override
				public void changed(ObservableValue<? extends Group> ov, Group oldValue, Group newValue) {
					groupNameLabel.setText(newValue.getGroupName());
					buildingLabel.setText(newValue.getLocation());
					meetingNotesLabel.setText(newValue.getLocationNotes());
					openSpotsLabel.setText(newValue.getSeatLimit());
					totalSpotsLabel.setText(newValue.getSeatLimit());
					meetingTimeLabel.setText(newValue.getTime());
					classLabel.setText(newValue.getClassName());
					visibilityLabel.setText(newValue.getAccess());
					majorLabel.setText(newValue.getClassName().substring(0,2));
					groupDisplayPane.setVisible(true);
				}
			} );
    }
    
    
    
    /*
     *	These Action events are specific to the Find a Group 
     *	Controller.
     */
    
    //handles search button pressed action event
    @FXML
    void searchButtonPressed(ActionEvent event) {

    }

    //handles reset button pressed action event
    @FXML
    void resetButtonPressed(ActionEvent event) {
    	//clear list of found groups
    	//remove search terms from their respected text fields
    	nameTextField.setText("");
    	majorTextField.setText("");
    	classTextField.setText("");
    	buildingTextField.setText("");
    	groupDisplayPane.setVisible(false);
    }
    
    @FXML
    void joinGroupButtonPressed(ActionEvent event) {
    	//should check to see if they are apart of the group before adding them
    	Alert joinSuccess = new Alert(AlertType.INFORMATION);
    	joinSuccess.setHeaderText("Successfuly joined group!");
    	joinSuccess.setTitle("Success");
    	joinSuccess.show();
    	
    	Alert joinFailure = new Alert(AlertType.ERROR);
    	joinFailure.setHeaderText("You are already in this group.");
    	joinFailure.setTitle("Failure");
    	//joinFailure.show();
    }
    
    
    /*
     *	These Action events all deal with the Menu bar buttons, and should
     *	be the same across all Controllers, except the login page and account
     *	creation controllers.
     */
    
    
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

    }
    
    @FXML 
    void signOutButtonPressed(ActionEvent event) {

    }
}
