package monsters;

//import java.text.DecimalFormat;
import java.util.Random;

import games.*;
import javafx.scene.image.Image;

public class Imp extends Enemy {

public Imp() {
	
	super.setDMG(6.0);
	super.setHP(40);
	super.setEnemyName("Imp");
	super.setArmour(1);
	super.setEnemyImage(new Image("imp.png"));
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
 * chance to crit
 * set hp, dmg, armour crit chance
 * need to set a method of choosing enemy
 * 
 * 
 * 
 * 
 * 
 * 
*/
