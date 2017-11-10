package main;

import groupStruct.Group;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class FindAGroupController {

	//instance variables which refer to GUI components
	@FXML private AnchorPane groupDisplayPane;
    @FXML private Label visibilityLabel;
    @FXML private Label ownerLabel;
    @FXML private Label classLabel;
    @FXML private Label openSpotsLabel;
    @FXML private Label meetingTimeLabel;
    @FXML private Label meetingAreaLabel;
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
					meetingAreaLabel.setText(newValue.getLocationNotes());
					openSpotsLabel.setText(newValue.getSeatLimit());
					totalSpotsLabel.setText(newValue.getSeatLimit());
					meetingTimeLabel.setText(newValue.getTime());
					classLabel.setText(newValue.getClassName());
					visibilityLabel.setText(newValue.getAccess());
					majorLabel.setText(newValue.getClassName().substring(0,2));
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
    	//perhaps create a search function that can be overloaded and pass the values from the text field as values?
    	//then search public groups for those things
    	//

    }

    //handles reset button pressed action event
    @FXML
    void resetButtonPressed(ActionEvent event) {
    	//clear list of found groups
    	//remove search terms from their respected text fields

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
