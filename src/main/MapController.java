package main;

import java.util.ArrayList;

import groupStruct.Group;
import groupStruct.findGroup;
import javafx.scene.control.Button;
import javafx.scene.control.Labeled;
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
 *	MapController extends common controller interface
 *	Constructs our map user interface functions
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
	@FXML private Labeled userIdLabel;
    private final ObservableList<Group> foundGroups = FXCollections.observableArrayList();
    private ArrayList<Group> matchedGroups;

    public Group selectedGroup;
    /**
     * Used to load and refresh this screen's view
     * User currently hardcoded for display
     * @return void
     */
    public void on_load(){
    	userIdLabel.setText("Annie");
    	foundGroups.clear();
       	mapGroupsListView.getSelectionModel().select(-1);
    	mapGroupsListView.refresh();
    }
    
     /**
      * Initializes group list view for map's group display
      * @return void
      */
    public void initialize() {
    	mapGroupsListView.setItems(foundGroups);//currentGroups
    	
    	mapGroupsListView.getSelectionModel().selectedItemProperty().addListener(
    			new ChangeListener<Group>() {
    				@Override
    				public void changed(ObservableValue<? extends Group> ov, Group oldValue, Group newValue) {
    					GroupController.getMapGroup(newValue);
    					GoStudyMain.new_child("Group");
    				}
    			} );
    }			
    
    //building buttons
    /**
     * PE building button pressed event
     * @param event
     */
    @FXML
    void PEButtonPressed(ActionEvent event) //should find groups based on building name and print on side 
    {
    	foundGroups.clear();
    	matchedGroups = findGroup.findGroupByBuilding("PE", GoStudyMain.groupList);
        foundGroups.addAll(matchedGroups);
        mapGroupsListView.refresh(); 
	
    }
    /**
     * UC Button pressed action event
     * Displays groups at this location upon click
     * @param event
     */
    @FXML
    void UCButtonPressed(ActionEvent event) 
    {
    	foundGroups.clear();
    	matchedGroups = findGroup.findGroupByBuilding("UC", GoStudyMain.groupList);
        foundGroups.addAll(matchedGroups);
        mapGroupsListView.refresh(); 
    }
    /**
     * HUC Map button clicked event
     * Displays groups at this location
     * @param event
     */
    @FXML
    void HUCButtonPressed(ActionEvent event) 
    {
    	foundGroups.clear();
    	matchedGroups = findGroup.findGroupByBuilding("HUC", GoStudyMain.groupList);
        foundGroups.addAll(matchedGroups);
        mapGroupsListView.refresh(); 
    }
    /**
     * MS Button clicked event
     * displays buttons at this location
     * @param event
     */
    @FXML
    void MSButtonPressed(ActionEvent event) 
    {
    	foundGroups.clear();
    	matchedGroups = findGroup.findGroupByBuilding("MS", GoStudyMain.groupList);
        foundGroups.addAll(matchedGroups);
        mapGroupsListView.refresh(); 
    }
    /**
     * JPL button clicked event
     * Displays groups at this location
     * @param event
     */
    @FXML
    void JPLButtonPressed(ActionEvent event) 
    {
    	foundGroups.clear();
    	matchedGroups = findGroup.findGroupByBuilding("JPL", GoStudyMain.groupList);
        foundGroups.addAll(matchedGroups);
        mapGroupsListView.refresh(); 
    }
    /**
     * BB Button clicked event 
     * Displays groups at this location 
     * @param event
     */
    @FXML
    void BBButtonPressed(ActionEvent event) 
    {
    	foundGroups.clear();
    	matchedGroups = findGroup.findGroupByBuilding("BB", GoStudyMain.groupList);
        foundGroups.addAll(matchedGroups);
        mapGroupsListView.refresh(); 
    
    }
    /**
     * EB Button cliked event
     * Displays groups at this location
     * @param event
     */
    @FXML
    void EBButtonPressed(ActionEvent event) 
    {
    	foundGroups.clear();
    	matchedGroups = findGroup.findGroupByBuilding("BB", GoStudyMain.groupList);
        foundGroups.addAll(matchedGroups);
        mapGroupsListView.refresh(); 
    
    }
    /**
     * AET button clicked event
     * Displays groups at this location
     * @param event
     */
    @FXML
    void AETButtonPressed(ActionEvent event) 
    {
    	foundGroups.clear();
    	matchedGroups = findGroup.findGroupByBuilding("AET", GoStudyMain.groupList);
        foundGroups.addAll(matchedGroups);
        mapGroupsListView.refresh(); 
    }
    /**
     * ART Button clicked event
     * Displays groups at this location
     * @param event
     */
    @FXML
    void ARTButtonPressed(ActionEvent event) 
    {
    	foundGroups.clear();
    	matchedGroups = findGroup.findGroupByBuilding("AET", GoStudyMain.groupList);
        foundGroups.addAll(matchedGroups);
        mapGroupsListView.refresh(); 
    }
    /**
     * RWC Button pressed
     * Clicking displays groups at this location
     * @param event
     */
    @FXML
    void RWCButtonPressed(ActionEvent event) 
    {
    	foundGroups.clear();
    	matchedGroups = findGroup.findGroupByBuilding("RWC", GoStudyMain.groupList);
        foundGroups.addAll(matchedGroups);
        mapGroupsListView.refresh(); 
    }
    /**
     * MB Button clicked event
     * Displays buildings at this location
     * @param event
     */
    @FXML
    void MBButtonPressed(ActionEvent event) 
    {
    	foundGroups.clear();
    	matchedGroups = findGroup.findGroupByBuilding("MB", GoStudyMain.groupList);
        foundGroups.addAll(matchedGroups);
        mapGroupsListView.refresh(); 
    }
    /**
     * NPB Button clicked event
     * Clicking displays groups at this location
     * @param event
     */
    @FXML
    void NPBButtonPressed(ActionEvent event) 
    {
    	foundGroups.clear();
    	matchedGroups = findGroup.findGroupByBuilding("NPB", GoStudyMain.groupList);
        foundGroups.addAll(matchedGroups);
        mapGroupsListView.refresh(); 
    }
    /**
     * MH Button clicked event
     * displays groups at this location
     * @param event
     */
    @FXML
    void MHButtonPressed(ActionEvent event) 
    {
    	foundGroups.clear();
    	matchedGroups = findGroup.findGroupByBuilding("MH", GoStudyMain.groupList);
        foundGroups.addAll(matchedGroups);
        mapGroupsListView.refresh(); 
    }
    /**
     * FLN Button building clicked
     * Displays groups at this location
     * @param event
     */
    @FXML
    void FLNButtonPressed(ActionEvent event) 
    {
    	foundGroups.clear();
    	matchedGroups = findGroup.findGroupByBuilding("FLN", GoStudyMain.groupList);
        foundGroups.addAll(matchedGroups);
        mapGroupsListView.refresh(); 
    }
    
    /**
     * Menu button pressed
     * Changes scene within the application to my groups view
     * @param event
     */
    @FXML
    void myGroupButtonPressed(ActionEvent event) {
    	GoStudyMain.new_child("MyGroups");
    }
    /**
     * find group buttton event
     * Changes view to find group search function
     * @param event
     */
    @FXML
    void findAGroupButtonPressed(ActionEvent event) {
    	GoStudyMain.new_child("FindAGroup");
    }
	/**
	 * group creation button event
	 * Clicking will change view to this view for group creation
	 * @param event
	 */
    @FXML
    void createAGroupButtonPressed(ActionEvent event) {
    	GoStudyMain.new_child("CreateGroup");
    }
    /**
     * Map button
     * Yassss
     * @param event
     */
    @FXML
    void mapButtonPressed(ActionEvent event) {
    	GoStudyMain.new_child("Map");
    	
    }
    /**
     * Changes to settings view
     * @param event
     */
    @FXML
    void settingsButtonPressed(ActionEvent event) {
    	GoStudyMain.new_child("Settings");
    }
    /**
     * sign out button will return view back to primary screen view
     * Back to login screen
     * @param event
     */
    @FXML void signOutButtonPressed(ActionEvent event) {
    	GoStudyMain.new_child("Login");
    }
    
}