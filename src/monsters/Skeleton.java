package monsters;


import games.*;
import heroes.Hero;
import javafx.scene.image.Image;

public class Skeleton extends Enemy{

	public Skeleton() {
		super.setDMG(6.0);
		super.setHP(60);
		super.setStartingHP(60);
		super.setEnemyName("Skeleton");
		super.setArmour(10);
		super.setEnemyImage(new Image("skeleton.png"));
		super.setExperience(25);
	}
	
	@Override
	public double attack(Hero hero) {
		double hp = hero.getCurrentHP();
			hp -= (super.getDMG()*(1-(hero.getArmour()/100)));
			return hp;
	}

	@Override
	public double calcEnemyHp(double enemyHP) {

		double EnemyHP = enemyHP;
		EnemyHP -=(Hero.DMG*(1-(armour/100)));
		return EnemyHP;
		
	}
	}

