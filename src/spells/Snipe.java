package spells;

import games.*;
import heroes.*;
import screens.DungeonFrame;
public class Snipe extends Spell{

	
	
	
	public Snipe() {
		setSpellName("Snipe");
		 setSpellDmg(100);
		 setManaCost(50);
		 setEffect("penetrating and very powerful");
		
	}
	
	@Override
	public void castSpell(Enemy enemy,Hero myHero, DungeonFrame dungeon) {
		enemy.setHP(enemy.getHP()- getSpellDmg());
		
	}

	@Override
	public String effect() {
		String effect = "High Damage";
		
		return effect;
	}

}
