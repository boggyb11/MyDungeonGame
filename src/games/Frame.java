package games;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import screens.WelcomeScreen;

public class Frame extends Application {

	private static Stage window;
	static Scene scene1;
	private static Scene scene2;
	private static Scene scene3;
	private static Scene scene4;
	static Scene scene5;
	private static Scene welcomeScene;
	static Scene spellBookScene;

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
		
		setWindow(primaryStage);
		getWindow().setTitle("Dungeon Crawler");
		WelcomeScreen welcome = new WelcomeScreen();
		
		welcome.setWelcomeScreen();
		primaryStage.setScene(getWelcomeScene());
		primaryStage.show();
	
	}
	public static Scene getScene2() {
		return scene2;
	}
	public static void setScene2(Scene scene2) {
		Frame.scene2 = scene2;
	}
	public static Stage getWindow() {
		return window;
	}
	public static void setWindow(Stage window) {
		Frame.window = window;
	}
	public static Scene getScene3() {
		return scene3;
	}
	public static void setScene3(Scene scene3) {
		Frame.scene3 = scene3;
	}
	public static Scene getScene4() {
		return scene4;
	}
	public static void setScene4(Scene scene4) {
		Frame.scene4 = scene4;
	}
	public static Scene getWelcomeScene() {
		return welcomeScene;
	}
	public static void setWelcomeScene(Scene welcomeScene) {
		Frame.welcomeScene = welcomeScene;
	}

	


}

