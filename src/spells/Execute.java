package spells;

import games.Enemy;
import games.Spell;
import heroes.Hero;
import screens.DungeonFrame;

public class Execute extends Spell {
	
	public Execute() {
		setSpellName("Execute");
		setSpellDmg(10);//////////
		setManaCost(25);
		setEffect("kills the enemy if under 30% HP");
		
		
	}

	@Override
	public void castSpell(Enemy enemy, Hero myHero, DungeonFrame dungeon) {
		
		
		double percentageNow = (enemy.getHP()/enemy.getStartingHP())*100;
		if(percentageNow<=30.00d) {
			enemy.setHP(0);
		}
		else {
			enemy.setHP(enemy.getHP()- (getSpellDmg()));
		}

	}

	@Override
	public String effect() {
		String effect = "kills the enemy if under 30% HP\"";
		return effect;
	}

}
