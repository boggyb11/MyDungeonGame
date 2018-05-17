package games;

import javafx.scene.image.Image;
import spells.Frostbolt;

public class Mage extends Hero {

	public Mage() {
		
		
		
    	super.setHP(60);
    	super.setDMG(10);
    	super.setMP(200);
    	super.setArmour(1);
    	super.setPlayerImage(new Image("magechar.png"));
		Spell heroSpell = new Frostbolt();
		super.setHeroSpell(heroSpell);
	}

}
