package spells;

import games.*;
import heroes.*;
import screens.DungeonFrame;
public class Frostbolt extends Spell {

	public Frostbolt() {
		 setSpellName("Frostbolt");
		 setSpellDmg(25);
		 setManaCost(25);
		 setEffect("Ignores Armour");
		
	}

	@Override
	public void castSpell(Enemy enemy,Hero myHero, DungeonFrame dungeon	) {
		enemy.setHP(enemy.getHP()- getSpellDmg());
		
	}

	@Override
	public String effect() {
		String effect = "Ignores Armour, 25Dmg";
		return effect;
	}

	
	
	
	
}
// ignores armour