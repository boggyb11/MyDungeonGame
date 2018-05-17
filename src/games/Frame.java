package games;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Frame extends Application {

	static Stage window;
	static Scene scene1, scene2, scene3,scene4,scene5,welcomeScene;
	CharacterCreator cc = new CharacterCreator();
	HBox hbox = new HBox(3);
	HBox hbox2 = new HBox(3);
	VBox vbox = new VBox(3);
	Pane spacer = new Pane();
	Pane spacer2 = new Pane();
	Pane spacer3 = new Pane();
	Pane spacer4 = new Pane();
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		window=primaryStage;
		window.setTitle("Dungeon Crawler");
		WelcomeScreen welcome = new WelcomeScreen();
		welcome.setWelcomeScreen();
		primaryStage.setScene(welcomeScene);
		primaryStage.show();
	
	}
	
	
	


}

