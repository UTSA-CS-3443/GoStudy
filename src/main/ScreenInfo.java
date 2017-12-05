package main;

import javafx.scene.layout.Pane;

/**
 * A class to store the pane and controller for a certain screen
 * @author StephensonA
 *
 */
public class ScreenInfo {
	Pane pane;
	CommonController controller;
	/**
	 * Construction method
	 * @param pane
	 * @param controller
	 */
	public ScreenInfo(Pane pane, CommonController controller) {
		super();
		this.pane = pane;
		this.controller = controller;
	}
	/**
	 * returns the pane
	 * @return
	 */
	public Pane getPane() {
		return pane;
	}
	/**
	 * returns the CommonController
	 * @return
	 */
	public CommonController getController() {
		return controller;
	}
	
}
