package spells;

import games.Enemy;
import games.Spell;
import heroes.Hero;
import screens.DungeonFrame;

public class Heal extends Spell {
	
	public Heal() {
		
		setSpellName("Heal");
		setSpellDmg(0);//////////
		setManaCost(25);
		setEffect("Heals the user");
		
		
		
	}

	@Override
	public void castSpell(Enemy enemy, Hero myHero, DungeonFrame dungeon) {
		double newHP = myHero.getCurrentHP()+30;
		myHero.setCurrentHP(newHP);

	}

	@Override
	public String effect() {
		String effect = "Small Heal";
		
		return effect;
	}

}
