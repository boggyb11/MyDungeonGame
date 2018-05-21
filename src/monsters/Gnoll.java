package monsters;

import java.util.Random;

import games.*;
import javafx.scene.image.Image;

public class Gnoll extends Enemy {

	
	
	public Gnoll() {
		super.setDMG(6.0);
		super.setHP(80);
		super.setEnemyName("Gnoll");
		super.setArmour(5);
		super.setEnemyImage(new Image("gnoll.png"));
	}
	
	
	@Override
	public double attack(Hero hero) {
		Random rand = new Random();
		int roll = rand.nextInt(10);
		double hp = hero.getCurrentHP();
		if(roll>=5) {
			hp-=super.getDMG();
			return hp;
		}

		else {
			hp -= (super.getDMG()*(1-(hero.getArmour()/100)));
			return hp;
		}
	}


	@Override
	public double calcEnemyHp(double enemyHP) {

		double EnemyHP = enemyHP;
		EnemyHP -=(Hero.DMG*(1-(armour/100)));
		return EnemyHP;
		
	}
	

}

