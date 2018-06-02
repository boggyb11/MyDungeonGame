package spells;

import games.Enemy;
import games.Spell;
import heroes.*;
import screens.DungeonFrame;
public class Bandage extends Spell {

	
	
	public Bandage() {
		setSpellName("Bandage");
		 setSpellDmg(0);
		 setManaCost(25);
		 setEffect("Small Heal");
		
		
	}
	@Override
	public void castSpell(Enemy enemy,Hero myHero, DungeonFrame dungeon) {
		
		double newHP = myHero.getCurrentHP()+30;
		myHero.setCurrentHP(newHP);
		

	}

	@Override
	public String effect() {
		String effect = "Small Heal";
		
		return effect;
	}

}
