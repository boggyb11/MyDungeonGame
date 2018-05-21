package spells;

import games.*;

public class Frostbolt extends Spell {

	public Frostbolt() {
		 setSpellName("Frostbolt");
		 setSpellDmg(25);
		 setManaCost(25);
		 setEffect("Ignores Armour");
		
	}

	@Override
	public void castSpell(Enemy enemy) {
		enemy.setHP(enemy.getHP()- getSpellDmg());
		
	}

	@Override
	public String effect() {
		String effect = "Ignores Armour, 25Dmg";
		return effect;
	}

	
	
	
	
}
// ignores armour