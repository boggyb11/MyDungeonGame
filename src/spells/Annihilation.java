package spells;

import games.Enemy;
import games.Spell;
import heroes.Hero;
import screens.DungeonFrame;

public class Annihilation extends Spell {
	
	public Annihilation() {
		
		setSpellName("Annihilation");
		setSpellDmg(100);//////////
		setManaCost(40);
		setEffect("Very high damage");
	}

	@Override
	public void castSpell(Enemy enemy, Hero myHero, DungeonFrame dungeon) {
		enemy.setHP(enemy.getHP()- (getSpellDmg()*(1.0d-(enemy.getArmour()/100.0d))));

	}

	@Override
	public String effect() {
		String effect = "Very high Damage";
		return effect;
	}

}
