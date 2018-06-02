package spells;

import games.*;
import heroes.Hero;
import screens.DungeonFrame;

public class LightningBolt extends Spell {
	
	
	public LightningBolt() {
		setSpellName("Lightning Bolt");
		setSpellDmg(15);//////////
		setManaCost(15);
		setEffect("Fires Multiple Bolts of Lightning at the target");
		
		
		
	}

	@Override
	public void castSpell(Enemy enemy, Hero myHero, DungeonFrame dungeon) {
		enemy.setHP(enemy.getHP()- (getSpellDmg())*Hero.level);
		
	}

	@Override
	public String effect() {
		String effect = "Fires an extra Lightning Bolt each level of your hero";
		return effect;
	}

}
