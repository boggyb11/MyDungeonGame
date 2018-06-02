package spells;

import games.*;
import screens.DungeonFrame;
import heroes.*;
public class Sunder extends Spell {
	DungeonFrame myDungeonFrame = new DungeonFrame();
	
	public Sunder() {
	setSpellName("Sunder");
	 setSpellDmg(25);
	 setManaCost(15);
	 setEffect("Reduce Armour by 5");
	}

	@Override
	public void castSpell(Enemy enemy,Hero myHero) {
		enemy.setHP(enemy.getHP()- (getSpellDmg()*(1.0d-(enemy.getArmour()/100.0d))));
		enemy.setArmour(enemy.getArmour()-5);
	}

	@Override
	public String effect() {
		return "Reduce Armour by 5, 25Dmg";
	}
}
