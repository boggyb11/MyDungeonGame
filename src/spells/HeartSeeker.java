package spells;

import java.util.Random;

import games.Enemy;
import games.Spell;
import heroes.*;

public class HeartSeeker extends Spell {
	
	public HeartSeeker() {
		setSpellName("Heartseeker");
		 setSpellDmg(30);
		 setManaCost(25);
		 setEffect("Chance of crit");
		
		
		
	}
	
	
	

	@Override
	public void castSpell(Enemy enemy, Hero myHero) {
		
		Random rand = new Random();
		//may need checking
		int num = rand.nextInt(10);
		if(num>5) {
			enemy.setHP(enemy.getHP()- (getSpellDmg()*4));
		}
		
		else {
		enemy.setHP(enemy.getHP()- (getSpellDmg()*(1.0d-(enemy.getArmour()/100.0d))));
		}
	}

	@Override
	public String effect() {
		String effect = "chance to crit";
		
		return effect;
	}

}
