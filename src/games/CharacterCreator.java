package games;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import spells.*;

public class CharacterCreator {
	private Button WarriorSelectButton = new Button("Warrior");
	private Button MageSelectButton = new Button("Mage");
	private Button ArcherSelectButton = new Button("Archer");
	Hero myHero;
	
	
	
	
	
	
	public void WarriorSelectButtonSet() {
		WarriorSelectButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	myHero = new Warrior();
		    	myHero.setHP(100);
				myHero.setDMG(15);
				myHero.setMP(50);
				myHero.setArmour(20);
				myHero.setPlayerImage(new Image("warriorchar.png"));
				Spell heroSpell = new Sunder();
				myHero.setHeroSpell(heroSpell);
		    	DungeonFrame df = new DungeonFrame();
				df.setDungeonFrame();
		    }
		});

	}
	
	public void MageSelectButtonSet() {
		MageSelectButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	myHero = new Mage();
		    	myHero.setHP(60);
				myHero.setDMG(10);
				myHero.setMP(200);
				myHero.setArmour(1);
				myHero.setPlayerImage(new Image("magechar.png"));
				Spell heroSpell = new Frostbolt();
				myHero.setHeroSpell(heroSpell);
		    	DungeonFrame df = new DungeonFrame();
				df.setDungeonFrame();
		    }
		});

	}
	
	public void ArcherSelectButtonSet() {
		ArcherSelectButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	myHero = new Archer();
		    	myHero.setHP(80);
				myHero.setDMG(20);
				myHero.setMP(100);
				myHero.setArmour(5);
				myHero.setPlayerImage(new Image("archerchar.png"));
				Spell heroSpell = new FireArrow();
				myHero.setHeroSpell(heroSpell);
		    	DungeonFrame df = new DungeonFrame();
				df.setDungeonFrame();
		    }
		});

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Button getWarriorSelectButton() {return WarriorSelectButton;}
	public Button getMageSelectButton() {return MageSelectButton;}
	public Button getArcherSelectButton() {return ArcherSelectButton;}
}
