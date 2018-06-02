package spells;

import effects.LightBurn;
import games.*;
import heroes.*;
import screens.DungeonFrame;
public class FireArrow extends Spell {
	
	
	public FireArrow() {
		
		setSpellName("FireArrow");
		 setSpellDmg(25);
		 setManaCost(15);
		 setEffect("Applies Light Burn for 2 turns");
		
	}

	@Override
	public void castSpell(Enemy enemy,Hero myHero, DungeonFrame dungeon) {
		enemy.setHP(enemy.getHP()- (getSpellDmg()*(1.0d-(enemy.getArmour()/100.0d))));
		Effect lightBurn = new LightBurn();
		lightBurn.applyEffect(enemy, dungeon);
	}

	@Override
	public String effect() {
		String effect = "Light Burn and 25Dmg";
		
		return effect;
	}

}
