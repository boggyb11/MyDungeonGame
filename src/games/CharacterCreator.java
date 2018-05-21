package games;

import heroes.Archer;
import heroes.Mage;
import heroes.Warrior;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import screens.DungeonFrame;
import screens.WelcomeScreen;

public class CharacterCreator {
	private final Image warrior = new Image ("warrior.png");
	private final Image sorcerer = new Image ("sorcerer.png");
	private final Image archer = new Image ("archer.png");
	private Button WarriorSelectButton = new Button("Warrior");
	private Button MageSelectButton = new Button("Mage");
	private Button ArcherSelectButton = new Button("Archer");
	private Button back = new Button("Back");
	private String warriorDescription = "A fighter specialized in close combat with good HP and armour";
	private String sorcererDescription = "A Spellcaster specialized in Magic with good damage but low HP";
	private String archerDescription = "A well rounded fighter good with bows";

	private static Hero myHero;
	HBox hbox = new HBox(3);
	HBox hbox2 = new HBox(3);
	HBox hboxDescription = new HBox(3);
	VBox vbox = new VBox(3);
	Pane spacer = new Pane();
	Pane spacer2 = new Pane();
	Pane spacer3 = new Pane();
	Pane spacer4 = new Pane();
	Pane spacer5 = new Pane();
	Pane spacer6 = new Pane();

	HeroDescription heroDescription = new HeroDescription();
	HeroImageCreator heroImage = new HeroImageCreator();
	
	
public void characterSelect() {
	
	
	ImageView warImage = heroImage.setHeroImage(warrior);
	ImageView sorcImage = heroImage.setHeroImage(sorcerer);
	ImageView archImage = heroImage.setHeroImage(archer);
	
	TextArea warDescript = heroDescription.createDescription(warriorDescription);
	TextArea sorcererDescript = heroDescription.createDescription(sorcererDescription);
	TextArea archerDescript = heroDescription.createDescription(archerDescription);
    
	
	
	HBox.setHgrow(spacer, Priority.ALWAYS);
	HBox.setHgrow(spacer2, Priority.ALWAYS);
	HBox.setHgrow(spacer3, Priority.ALWAYS);
	HBox.setHgrow(spacer4, Priority.ALWAYS);
	HBox.setHgrow(spacer5, Priority.ALWAYS);
	HBox.setHgrow(spacer6, Priority.ALWAYS);
	
	ArcherSelectButtonSet();
	MageSelectButtonSet();
	WarriorSelectButtonSet();
	backButtonSet();
	
	hbox2.getChildren().addAll(warImage,spacer3,sorcImage,spacer4,archImage);
	hbox.getChildren().addAll(getWarriorSelectButton(),spacer,getMageSelectButton(),spacer2,getArcherSelectButton());
	hboxDescription.getChildren().addAll(warDescript,spacer5,sorcererDescript,spacer6,archerDescript);
	vbox.getChildren().addAll(hbox2,hbox,hboxDescription,back);
	
	Frame.scene1 = new Scene(vbox, 600,800);
	Frame.getWindow().setScene(Frame.scene1);
}
	public void backButtonSet() {
		back.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	WelcomeScreen ws = new WelcomeScreen();
		    	ws.setWelcomeScreen();
		    }
		});
		
		
	}
	
	public void WarriorSelectButtonSet() {
		WarriorSelectButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	setMyHero(new Warrior());
		    	DungeonFrame df = new DungeonFrame();
				df.setDungeonFrame();
		    }
		});

	}
	
	public void MageSelectButtonSet() {
		MageSelectButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	setMyHero(new Mage());
		    	DungeonFrame df = new DungeonFrame();
				df.setDungeonFrame();
		    }
		});

	}
	
	public void ArcherSelectButtonSet() {
		ArcherSelectButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	setMyHero(new Archer());
		    	DungeonFrame df = new DungeonFrame();
				df.setDungeonFrame();
		    }
		});

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Button getWarriorSelectButton() {return WarriorSelectButton;}
	public Button getMageSelectButton() {return MageSelectButton;}
	public Button getArcherSelectButton() {return ArcherSelectButton;}
	public Hero getMyHero() {
		return myHero;
	}
	public void setMyHero(Hero myHero) {
		CharacterCreator.myHero = myHero;
	}
}
