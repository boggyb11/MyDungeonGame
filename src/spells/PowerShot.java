package spells;

import games.Enemy;
import games.Spell;
import heroes.*;
public class PowerShot extends Spell {
	
	public PowerShot() {
		
		setSpellName("PowerShot");
		 setSpellDmg(35);
		 setManaCost(20);
		 setEffect(effect());
	}

	@Override
	public void castSpell(Enemy enemy,Hero myHero) {
		// TODO Auto-generated method stub
		enemy.setHP(enemy.getHP()- (getSpellDmg()));

	}

	@Override
	public String effect() {
		// TODO Auto-generated method stub
		return "Pierces Armour";
	}

}
