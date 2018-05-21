package heroes;

import games.Hero;
import games.Spell;
import javafx.scene.image.Image;
import spells.Sunder;

public class Warrior extends Hero {

	
	public Warrior() {
		
    	super.setCurrentHP(100);
    	super.setActualHP(100);
    	super.setDMG(15);
    	super.setMP(50);
    	super.setArmour(20);
    	super.setPlayerImage(new Image("warriorchar.png"));
		Spell heroSpell = new Sunder();
		super.setHeroSpell(heroSpell);
		addStartSpell.addItem(heroSpell);
	}

	
	
	
	
}
