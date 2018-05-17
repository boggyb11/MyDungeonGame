package games;

import javafx.scene.image.Image;
import spells.FireArrow;

public class Archer extends Hero {

	public Archer() {
		
		super.setHP(80);
		super.setDMG(20);
		super.setMP(100);
		super.setArmour(5);
		super.setPlayerImage(new Image("archerchar.png"));
		Spell heroSpell = new FireArrow();
		super.setHeroSpell(heroSpell);
		
		
	}
	
}
