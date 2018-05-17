package games;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class CharacterCreator {
	private Button WarriorSelectButton = new Button("Warrior");
	private Button MageSelectButton = new Button("Mage");
	private Button ArcherSelectButton = new Button("Archer");
	private Button back = new Button("Back");
	Hero myHero;
	HBox hbox = new HBox(3);
	HBox hbox2 = new HBox(3);
	VBox vbox = new VBox(3);
	Pane spacer = new Pane();
	Pane spacer2 = new Pane();
	Pane spacer3 = new Pane();
	Pane spacer4 = new Pane();
	
	
public void characterSelect() {
	back.setOnAction(new EventHandler<ActionEvent>() {
	    @Override public void handle(ActionEvent e) {
	    	WelcomeScreen ws = new WelcomeScreen();
	    	ws.setWelcomeScreen();
	    }
	});
	
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
	ArcherSelectButtonSet();
	MageSelectButtonSet();
	WarriorSelectButtonSet();
	hbox2.getChildren().addAll(iv1,spacer3,iv2,spacer4,iv3);
	hbox.getChildren().addAll(getWarriorSelectButton(),spacer,getMageSelectButton(),spacer2,getArcherSelectButton());
	vbox.getChildren().addAll(hbox2,hbox,DungeonFrame.textArea,back);
	Frame.scene1 = new Scene(vbox, 600,800);
	Frame.window.setScene(Frame.scene1);
}
	
	
	public void WarriorSelectButtonSet() {
		WarriorSelectButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	myHero = new Warrior();
		    	DungeonFrame df = new DungeonFrame();
				df.setDungeonFrame();
		    }
		});

	}
	
	public void MageSelectButtonSet() {
		MageSelectButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	myHero = new Mage();
		    	DungeonFrame df = new DungeonFrame();
				df.setDungeonFrame();
		    }
		});

	}
	
	public void ArcherSelectButtonSet() {
		ArcherSelectButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	myHero = new Archer();
		    	DungeonFrame df = new DungeonFrame();
				df.setDungeonFrame();
		    }
		});

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Button getWarriorSelectButton() {return WarriorSelectButton;}
	public Button getMageSelectButton() {return MageSelectButton;}
	public Button getArcherSelectButton() {return ArcherSelectButton;}
}
