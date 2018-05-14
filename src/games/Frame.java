package games;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
//import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Frame extends Application {

	static Stage window;
	static Scene scene1, scene2, scene3,scene4,scene5;
	CharacterCreator hsb = new CharacterCreator();
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
		Image warrior = new Image ("warrior.png");
		ImageView iv1 = new ImageView();
		iv1.setImage(warrior);
		iv1.setFitWidth(200);
		iv1.setFitHeight(300);
		iv1.setPreserveRatio(true);
        iv1.setSmooth(true);
        
        Image Mage = new Image ("sorcerer.png");
		ImageView iv2 = new ImageView();
		iv2.setImage(Mage);
		iv2.setFitWidth(200);
		iv2.setFitHeight(300);
		iv2.setPreserveRatio(true);
        iv2.setSmooth(true);
        
        Image Archer = new Image ("archer.png");
		ImageView iv3 = new ImageView();
		iv3.setImage(Archer);
		iv3.setFitWidth(200);
		iv3.setFitHeight(300);
		iv3.setPreserveRatio(true);
		iv3.setSmooth(true);
		
		
		HBox.setHgrow(spacer3, Priority.ALWAYS);
		HBox.setHgrow(spacer4, Priority.ALWAYS);
		HBox.setHgrow(spacer2, Priority.ALWAYS);
		HBox.setHgrow(spacer, Priority.ALWAYS);
		hsb.ArcherSelectButtonSet();
		hsb.MageSelectButtonSet();
		hsb.WarriorSelectButtonSet();
		hbox2.getChildren().addAll(iv1,spacer3,iv2,spacer4,iv3);
		hbox.getChildren().addAll(hsb.getWarriorSelectButton(),spacer,hsb.getMageSelectButton(),spacer2,hsb.getArcherSelectButton());
		vbox.getChildren().addAll(hbox2,hbox,DungeonFrame.textArea);
		scene1 = new Scene(vbox, 600,800);
		primaryStage.setScene(scene1);
		primaryStage.show();
	
	}
	public void setStart() {
		Image warrior = new Image ("warrior.png");
		ImageView iv1 = new ImageView();
		iv1.setImage(warrior);
		iv1.setFitWidth(200);
		iv1.setFitHeight(300);
		iv1.setPreserveRatio(true);
        iv1.setSmooth(true);
        
        Image Mage = new Image ("sorcerer.png");
		ImageView iv2 = new ImageView();
		iv2.setImage(Mage);
		iv2.setFitWidth(200);
		iv2.setFitHeight(300);
		iv2.setPreserveRatio(true);
        iv2.setSmooth(true);
        
        Image Archer = new Image ("archer.png");
		ImageView iv3 = new ImageView();
		iv3.setImage(Archer);
		iv3.setFitWidth(200);
		iv3.setFitHeight(300);
		iv3.setPreserveRatio(true);
		iv3.setSmooth(true);
		
		
		HBox.setHgrow(spacer3, Priority.ALWAYS);
		HBox.setHgrow(spacer4, Priority.ALWAYS);
		HBox.setHgrow(spacer2, Priority.ALWAYS);
		HBox.setHgrow(spacer, Priority.ALWAYS);
		
		
		hsb.WarriorSelectButtonSet();
		hsb.ArcherSelectButtonSet();
		hsb.MageSelectButtonSet();
		hbox2.getChildren().addAll(iv1,spacer3,iv2,spacer4,iv3);
		hbox.getChildren().addAll(hsb.getWarriorSelectButton(),spacer,hsb.getMageSelectButton(),spacer2,hsb.getArcherSelectButton());
		vbox.getChildren().addAll(hbox2,hbox,DungeonFrame.textArea);
    	window.setScene(scene1);
	}
	
	
	


}

