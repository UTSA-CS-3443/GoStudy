package main;

import javafx.scene.layout.Pane;

public class ScreenInfo {
	Pane pane;
	CommonController controller;
	public ScreenInfo(Pane pane, CommonController controller) {
		super();
		this.pane = pane;
		this.controller = controller;
	}
	public Pane getPane() {
		return pane;
	}
	public CommonController getController() {
		return controller;
	}
	
}
