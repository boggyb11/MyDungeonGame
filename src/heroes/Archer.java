package heroes;

import games.Hero;
import games.Spell;
import javafx.scene.image.Image;
import spells.FireArrow;

public class Archer extends Hero {

	public Archer() {
		
		super.setCurrentHP(80);
		super.setActualHP(80);
		super.setDMG(20);
		super.setMP(100);
		super.setArmour(5);
		super.setPlayerImage(new Image("archerchar.png"));
		Spell heroSpell = new FireArrow();
		super.setHeroSpell(heroSpell);
		addStartSpell.addItem(heroSpell);
		
		
	}
	
}
