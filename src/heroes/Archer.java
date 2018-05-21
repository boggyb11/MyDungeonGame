package heroes;

import games.*;
import javafx.scene.image.Image;
import spells.*;

public class Archer extends Hero {

	public Archer() {
		
		super.setCurrentHP(80);
		super.setActualHP(80);
		super.setDMG(20);
		super.setMP(100);
		super.setStartingMP(100);
		super.setArmour(5);
		super.setPlayerImage(new Image("archerchar.png"));
		Spell heroSpell = new FireArrow();
		super.setHeroSpell(heroSpell);
		addStartSpell.addItem(heroSpell);
		
		
	}

	@Override
	public void levelUp() {

		doStats();
		doNewSpells();
		
		
		
	}
	
	public void doNewSpells() {
		switch(super.getLevel()){
		case 2:{
			Spell newSpell = new PowerShot();
			addStartSpell.addItem(newSpell);
		}
		case 4:{
			
		}
		case 6:{
			
		}
		case 8:{
			
		}
		case 10:{
			
		}
			
			
		}
		
	}
	
	public void doStats() {
		
		super.setActualHP(super.getActualHP()*1.4);
		super.setCurrentHP(super.getActualHP());
		
		super.setDMG(super.getDMG()*1.4);
		
		super.setStartingMP(super.getStartingMP()*1.4);
		super.setMP(super.getStartingMP());
		
		super.setArmour(super.getArmour()*1.4);
		
	}
	
}
