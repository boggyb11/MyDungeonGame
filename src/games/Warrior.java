package games;

import javafx.scene.image.Image;
import spells.Sunder;

public class Warrior extends Hero {

	
	public Warrior() {
		
    	super.setHP(100);
    	super.setDMG(15);
    	super.setMP(50);
    	super.setArmour(20);
    	super.setPlayerImage(new Image("warriorchar.png"));
		Spell heroSpell = new Sunder();
		super.setHeroSpell(heroSpell);
	}
}
