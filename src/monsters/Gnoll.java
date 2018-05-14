package monsters;

import java.util.Random;

import games.*;

public class Gnoll extends Enemy {

	
	
	public Gnoll() {
		super.setDMG(6.0);
		super.setHP(40);
		super.setEnemyName("Gnoll");
		super.setArmour(1);
	}
	
	
	@Override
	public double attack(Hero hero) {
		Random rand = new Random();
		int roll = rand.nextInt(10);
		double hp = hero.getHP();
		if(roll>=5) {
			
			
			
			hp -=2*(super.getDMG()*(1-(hero.getArmour()/100)));
			//DecimalFormat df2 = new DecimalFormat(".##");
			//double	HP = df2.format(hp);
			return hp;
		}

		else {
			hp -= (super.getDMG()*(1-(hero.getArmour()/100)));
			return hp;
		}
	}
	

}
/*
extra armour and hp 





*/