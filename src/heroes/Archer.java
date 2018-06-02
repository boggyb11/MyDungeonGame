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
			break;
		}
		case 4:{
			Spell newSpell = new Bandage();
			addStartSpell.addItem(newSpell);
			break;		}
		case 6:{
			Spell newSpell = new MultiShot();
			addStartSpell.addItem(newSpell);
			break;
		}
		case 8:{
			Spell newSpell = new HeartSeeker();
			addStartSpell.addItem(newSpell);
			break;
		}
		case 10:{
			Spell newSpell = new Snipe();
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
