package main;

import groupStruct.Group;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

   // private final ObservableList<Group> mapGroupsListView = FXCollections.observableArrayList();
    
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
    	GoStudyMain.new_child("Settings");
    }
    //maybe side
    
    //building buttons
    void UCButtonPressed(ActionEvent event) 
    {
    
    }
    void PEButtonPressed(ActionEvent event) 
    {
    
    }
    void HUCButtonPressed(ActionEvent event) 
    {
    
    }
    void MSButtonPressed(ActionEvent event) 
    {
    
    }
    void JPLButtonPressed(ActionEvent event) 
    {
    
    }
    void BBButtonPressed(ActionEvent event) 
    {
    
    }
    void FLNButtonPressed(ActionEvent event) 
    {
    
    }
    void EBButtonPressed(ActionEvent event) 
    {
    
    }
    void AETButtonPressed(ActionEvent event) 
    {
    
    }
    void RWCButtonPressed(ActionEvent event) 
    {
    
    }
    void MBButtonPressed(ActionEvent event) 
    {
    
    }

}
