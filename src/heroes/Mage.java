package heroes;

import games.Hero;
import games.Spell;
import javafx.scene.image.Image;
import spells.Firebolt;
import spells.Frostbolt;

public class Mage extends Hero {

	public Mage() {
		
		
		
    	super.setCurrentHP(60);
    	super.setActualHP(60);
    	super.setDMG(10);
    	super.setMP(200);
    	super.setStartingMP(200);
    	super.setArmour(1);
    	super.setPlayerImage(new Image("magechar.png"));
		Spell heroSpell = new Frostbolt();
		Spell secondSpell = new Firebolt();
		super.setHeroSpell(heroSpell);
		addStartSpell.addItem(heroSpell);
		addStartSpell.addItem(secondSpell);
	}

	@Override
	public void levelUp() {
		// TODO Auto-generated method stub
		
	}

}
