package heroes;

import games.Spell;
import javafx.scene.image.Image;
import spells.*;


public class Mage extends Hero {

	public Mage() {
		
		
		super.setType("Mage");
    	super.setCurrentHP(60);
    	super.setActualHP(60);
    	super.setDMG(10);
    	super.setMP(200);
    	super.setStartingMP(200);
    	super.setArmour(1);
    	super.setPlayerImage(new Image("magechar.png"));
		Spell heroSpell = new Frostbolt();
		//Spell secondSpell = new Firebolt();
		super.setHeroSpell(heroSpell);
		addStartSpell.addItem(heroSpell);
		//addStartSpell.addItem(secondSpell);
	}

	
	
	public void doNewSpells() {
		switch(super.getLevel()){
		case 2:{
			Spell newSpell = new Firebolt();
			addStartSpell.addItem(newSpell);
			break;
		}
		case 4:{
			Spell newSpell = new Heal();
			addStartSpell.addItem(newSpell);
			break;		}
		case 6:{
			Spell newSpell = new FrostPrism();
			addStartSpell.addItem(newSpell);
			break;
		}
		case 8:{
			Spell newSpell = new LightningBolt();
			addStartSpell.addItem(newSpell);
			break;
		}
		case 10:{
			Spell newSpell = new FrostFire();
			addStartSpell.addItem(newSpell);
			break;
		}
			
			
		}
		
	}
	@Override
	public void levelUp() {
	doStats();
	doNewSpells();
		
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
