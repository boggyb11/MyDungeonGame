package spells;

import effects.Stun;
import games.Effect;
import games.Enemy;
import games.Spell;
import heroes.Hero;
import screens.DungeonFrame;

public class Charge extends Spell {
	
	public Charge() {
		setSpellName("Charge");
		setSpellDmg(25);//////////
		setManaCost(15);
		setEffect("Charges at the enemy, stunning them");
		
		
		
	}

	@Override
	public void castSpell(Enemy enemy, Hero myHero, DungeonFrame dungeon) {
		enemy.setHP(enemy.getHP()- (getSpellDmg()));
		Effect stun = new Stun();
		stun.applyEffect(enemy,dungeon);
	}

	@Override
	public String effect() {
		String effect = "Charges at the enemy, stunning them";
		return effect;
	}

}
