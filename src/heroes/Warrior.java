package heroes;

import games.Spell;
import javafx.scene.image.Image;
import spells.*;

public class Warrior extends Hero {

	
	public Warrior() {
		super.setType("Warrior");
    	super.setCurrentHP(100);
    	super.setActualHP(100);
    	super.setDMG(15);
    	super.setMP(50);
    	super.setStartingMP(50);
    	super.setArmour(20);
    	super.setPlayerImage(new Image("warriorchar.png"));
		Spell heroSpell = new Sunder();
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
			Spell newSpell = new Charge();
			addStartSpell.addItem(newSpell);
			break;
		}
		case 4:{
			Spell newSpell = new Bandage();
			addStartSpell.addItem(newSpell);
			break;		}
		case 6:{
			Spell newSpell = new Execute();
			addStartSpell.addItem(newSpell);
			break;
		}
		case 8:{
			Spell newSpell = new HeartSeeker();
			addStartSpell.addItem(newSpell);
			break;
		}
		case 10:{
			Spell newSpell = new Annihilation();
			addStartSpell.addItem(newSpell);
			break;
		}
			
			
		}
		
	}

	public void doStats() {
		
		super.setActualHP(super.getActualHP()*1.1);
		super.setCurrentHP(super.getActualHP());
		
		super.setDMG(super.getDMG()*1.1);
		
		super.setStartingMP(super.getStartingMP()*1.1);
		super.setMP(super.getStartingMP());
		
		super.setArmour(super.getArmour()*1.1);
		
		super.setExpToLevel(100+25*super.getLevel());
		
	}
	
	
	
}
