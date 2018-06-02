package spells;

import games.Enemy;
import games.Spell;
import heroes.*;

public class MultiShot extends Spell{

	
	
	public MultiShot() {
			setSpellName("Multi Shot");
			setSpellDmg(15*Hero.level);//////////
			setManaCost(15);
			setEffect("Fires Multiple arrows at the target");
		
		
		
	}

	@Override
	public void castSpell(Enemy enemy,Hero myHero) {
		enemy.setHP(enemy.getHP()- (getSpellDmg()*(1.0d-(enemy.getArmour()/100.0d))));
		
	}

	@Override
	public String effect() {
		String effect = "Fires an extra arrow each level of your hero";
		return effect;
	}
}
