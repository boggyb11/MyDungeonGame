package monsters;

//import java.text.DecimalFormat;
import java.util.Random;

import games.*;
import javafx.scene.image.Image;

public class Imp extends Enemy {

public Imp() {
	
	super.setDMG(8.0);
	super.setHP(35);
	super.setStartingHP(35);
	super.setEnemyName("Imp");
	super.setArmour(1);
	super.setEnemyImage(new Image("imp.png"));
	super.setExperience(25);
}

@Override
public double attack(Hero hero) {
	Random rand = new Random();
	int roll = rand.nextInt(10);
	double hp = hero.getCurrentHP();
	if(roll>=5) {
		
		
		
		hp -=2*(super.getDMG()*(1-(hero.getArmour()/100)));
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
