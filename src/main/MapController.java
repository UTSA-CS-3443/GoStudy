package main;

import java.util.ArrayList;

import groupStruct.Group;
import groupStruct.findGroup;
import javafx.scene.control.Button;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
/**
 * 
 * Currently does not display full map.
 * Needs button implementation to display groups
 *
 */
public class MapController extends CommonController {

	@FXML private AnchorPane mapGroupDisplayPane;
	@FXML private ListView<Group> mapGroupsListView;
	@FXML private Button BB;
	@FXML private Button ART;
	@FXML private Button MS;
	@FXML private Button JPL;
	@FXML private Button FLN;
	@FXML private Button UC;
	@FXML private Button AET;
	@FXML private Button PE;
	@FXML private Button MB;
	@FXML private Button MH;
	@FXML private Button HUC;
	@FXML private Button EB;
	@FXML private Button RWC;
    private final ObservableList<Group> foundGroups = FXCollections.observableArrayList();
    private ArrayList<Group> matchedGroups;

    
    @FXML void signOutButtonPressed(ActionEvent event) {

    }
    
    public void on_load(){
    	//
    	mapGroupsListView.refresh();
    }
    
     //try to make groups pop up
    public void initialize() {
    	mapGroupsListView.setItems(foundGroups);//currentGroups
    	
    	mapGroupsListView.getSelectionModel().selectedItemProperty().addListener(
    			new ChangeListener<Group>() {
    				@Override
    				public void changed(ObservableValue<? extends Group> ov, Group oldValue, Group newValue) {
    				
    				}
    			} );
    }			
    
    //building buttons
    
    @FXML
    void PEButtonPressed(ActionEvent event) //should find groups based on building name and print on side 
    {
    	foundGroups.clear();
    	matchedGroups = findGroup.findGroupByBuilding("PE", GoStudyMain.groupList);
        foundGroups.addAll(matchedGroups);
        mapGroupsListView.refresh(); 
	
    }
    @FXML
    void UCButtonPressed(ActionEvent event) 
    {
    	foundGroups.clear();
    	matchedGroups = findGroup.findGroupByBuilding("UC", GoStudyMain.groupList);
        foundGroups.addAll(matchedGroups);
        mapGroupsListView.refresh(); 
    }
    @FXML
    void HUCButtonPressed(ActionEvent event) 
    {
    	foundGroups.clear();
    	matchedGroups = findGroup.findGroupByBuilding("HUC", GoStudyMain.groupList);
        foundGroups.addAll(matchedGroups);
        mapGroupsListView.refresh(); 
    }
    @FXML
    void MSButtonPressed(ActionEvent event) 
    {
    	foundGroups.clear();
    	matchedGroups = findGroup.findGroupByBuilding("MS", GoStudyMain.groupList);
        foundGroups.addAll(matchedGroups);
        mapGroupsListView.refresh(); 
    }
    @FXML
    void JPLButtonPressed(ActionEvent event) 
    {
    	foundGroups.clear();
    	matchedGroups = findGroup.findGroupByBuilding("JPL", GoStudyMain.groupList);
        foundGroups.addAll(matchedGroups);
        mapGroupsListView.refresh(); 
    }
    @FXML
    void BBButtonPressed(ActionEvent event) 
    {
    	foundGroups.clear();
    	matchedGroups = findGroup.findGroupByBuilding("BB", GoStudyMain.groupList);
        foundGroups.addAll(matchedGroups);
        mapGroupsListView.refresh(); 
    
    }
    @FXML
    void EBButtonPressed(ActionEvent event) 
    {
    	foundGroups.clear();
    	matchedGroups = findGroup.findGroupByBuilding("BB", GoStudyMain.groupList);
        foundGroups.addAll(matchedGroups);
        mapGroupsListView.refresh(); 
    
    }
    @FXML
    void AETButtonPressed(ActionEvent event) 
    {
    	foundGroups.clear();
    	matchedGroups = findGroup.findGroupByBuilding("AET", GoStudyMain.groupList);
        foundGroups.addAll(matchedGroups);
        mapGroupsListView.refresh(); 
    }
    @FXML
    void ARTButtonPressed(ActionEvent event) 
    {
    	foundGroups.clear();
    	matchedGroups = findGroup.findGroupByBuilding("AET", GoStudyMain.groupList);
        foundGroups.addAll(matchedGroups);
        mapGroupsListView.refresh(); 
    }
    @FXML
    void RWCButtonPressed(ActionEvent event) 
    {
    	foundGroups.clear();
    	matchedGroups = findGroup.findGroupByBuilding("RWC", GoStudyMain.groupList);
        foundGroups.addAll(matchedGroups);
        mapGroupsListView.refresh(); 
    }
    @FXML
    void MBButtonPressed(ActionEvent event) 
    {
    	foundGroups.clear();
    	matchedGroups = findGroup.findGroupByBuilding("MB", GoStudyMain.groupList);
        foundGroups.addAll(matchedGroups);
        mapGroupsListView.refresh(); 
    }
    @FXML
    void NPBButtonPressed(ActionEvent event) 
    {
    	foundGroups.clear();
    	matchedGroups = findGroup.findGroupByBuilding("NPB", GoStudyMain.groupList);
        foundGroups.addAll(matchedGroups);
        mapGroupsListView.refresh(); 
    }
    @FXML
    void MHButtonPressed(ActionEvent event) 
    {
    	foundGroups.clear();
    	matchedGroups = findGroup.findGroupByBuilding("MH", GoStudyMain.groupList);
        foundGroups.addAll(matchedGroups);
        mapGroupsListView.refresh(); 
    }
    @FXML
    void FLNButtonPressed(ActionEvent event) 
    {
    	foundGroups.clear();
    	matchedGroups = findGroup.findGroupByBuilding("FLN", GoStudyMain.groupList);
        foundGroups.addAll(matchedGroups);
        mapGroupsListView.refresh(); 
    }
    
    //other buttons
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
}