package spells;

import effects.*;
import games.Effect;
import games.Enemy;
import games.Spell;
import heroes.Hero;
import screens.DungeonFrame;

public class FrostPrism extends Spell {
	
	public FrostPrism() {
		setSpellName("Frost Prism");
		setSpellDmg(30);//////////
		setManaCost(25);
		setEffect("Holds the target in a prism of frost");
		
		
		
		
	}

	@Override
	public void castSpell(Enemy enemy, Hero myHero, DungeonFrame dungeon) {
		enemy.setHP(enemy.getHP()- (getSpellDmg()));
		Effect stun = new Stun();
		stun.applyEffect(enemy,dungeon);

	}

	@Override
	public String effect() {
		String effect = "Holds the target in a prism of frost";
		return effect;
	}

}
