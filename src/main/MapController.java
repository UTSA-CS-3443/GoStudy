package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
/**
 * 
 * Currently does not display full map.
 * Needs button implementation to display groups
 *
 */
public class MapController extends CommonController {

    @FXML private ListView<?> mapGroupsListView;
    @FXML void signOutButtonPressed(ActionEvent event) {

    }

    public void on_load(){};
    
    @FXML
    void myGroupButtonPressed(ActionEvent event) {
    	GoStudyMain.new_child("MyGroups");
    }

    @FXML
    void findAGroupButtonPressed(ActionEvent event) {
    	GoStudyMain.new_child("FindAGroup");
    }
	/**
	 * new_child previously "CreateAGroup", caused application to crash.
	 * Renamed to correct string input to switch to CreateGroup scene
	 * @param event
	 */
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

}
