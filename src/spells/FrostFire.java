package spells;

import effects.*;
import games.Effect;
import games.Enemy;
import games.Spell;
import heroes.Hero;
import screens.DungeonFrame;

public class FrostFire extends Spell {
	
	public FrostFire() {
		
		 setSpellName("FrostFire");
		 setSpellDmg(50);
		 setManaCost(25);
		 setEffect("Burns and ignores armour");
		
		
		
	}

	@Override
	public void castSpell(Enemy enemy, Hero myHero, DungeonFrame dungeon) {
		enemy.setHP(enemy.getHP()- (getSpellDmg()));
		Effect SeriousBurn = new SeriousBurn();
		SeriousBurn.applyEffect(enemy, dungeon);

	}

	@Override
	public String effect() {
		String effect = "Burns and ignores armour";
		return effect;
	}

}
