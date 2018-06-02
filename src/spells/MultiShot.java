package spells;

import games.Enemy;
import games.Spell;
import heroes.*;
import screens.DungeonFrame;

public class MultiShot extends Spell{

	
	
	public MultiShot() {
			setSpellName("Multi Shot");
			setSpellDmg(15);//////////
			setManaCost(15);
			setEffect("Fires Multiple arrows at the target");
		
		
		
	}

	@Override
	public void castSpell(Enemy enemy,Hero myHero, DungeonFrame dungeon) {
		enemy.setHP(enemy.getHP()- (getSpellDmg()*(1.0d-(enemy.getArmour()/100.0d))*Hero.level));
		
	}

	@Override
	public String effect() {
		String effect = "Fires an extra arrow each level of your hero";
		return effect;
	}
}
