package spells;

import effects.LightBurn;
import games.*;

public class FireArrow extends Spell {
	
	
	public FireArrow() {
		
		setSpellName("FireArrow");
		 setSpellDmg(25);
		 setManaCost(15);
		 setEffect("Applies Light Burn for 2 turns");
		
	}

	@Override
	public void castSpell(Enemy enemy) {
		enemy.setHP(enemy.getHP()- (getSpellDmg()*(1.0d-(enemy.getArmour()/100.0d))));
		Effect lightBurn = new LightBurn();
		lightBurn.applyEffect(enemy);
	}

	@Override
	public String effect() {
		String effect = "Light Burn and 25Dmg";
		
		return effect;
	}

}
