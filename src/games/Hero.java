package games;

import java.text.DecimalFormat;

import effects.LightBurn;
import javafx.scene.image.Image;
import screens.DungeonFrame;

public class Hero {
	 static double currentHP;
	 static double actualHP;
	 public static double DMG;
	 static int MP;
	 static Spell heroSpell;
	 static Image playerImage;
	 static double armour;
	 DecimalFormat df2 = new DecimalFormat(".##");
	 protected SpellBook addStartSpell = new SpellBook();
	
	public Hero() {
		 
	}
	

	public void attack(Hero hero, Enemy enemy) {
		calcHeroHp(enemy.attack(hero));
		if(enemy.isBurning) {
			LightBurn lb = new LightBurn();
			lb.burn(enemy);
		}
		enemy.setHP(calcEnemyHP(enemy.getHP()));
	}
	public void calcHeroHp(double heroHP) {
		currentHP = heroHP;
		df2.format(currentHP);
	}
	public double calcEnemyHP(double enemyHP) {
		
		double EnemyHP = DungeonFrame.enemy.calcEnemyHp(enemyHP);
		
		df2.format(EnemyHP);
		return EnemyHP;
		
	}
	public double getCurrentHP() {
		return currentHP;
	}
	public double getActualHP() {
		return actualHP;
	}


	public void setActualHP(double actualHP) {
		Hero.actualHP = actualHP;
	}


	public void setCurrentHP(double hP) {
		currentHP = hP;
	}
	public double getDMG() {
		return DMG;
	}
	public void setDMG(double dMG) {
		DMG = dMG;
	}

	public  int getMP() {
		return MP;
	}

	public  void setMP(int mP) {
		MP = mP;
	}

	public Spell getHeroSpell() {
		return heroSpell;
	}
	 public Image getPlayerImage() {
		return playerImage;
	}

	public void setPlayerImage(Image playerImage) {
		Hero.playerImage = playerImage;
	}
	public double getArmour() {
		return armour;
	}

	public void setArmour(double armour) {
		Hero.armour = armour;
	}


	public void setHeroSpell(Spell heroSpellIn) {
		heroSpell = heroSpellIn;
	}
	
	public void castSpell(Hero hero, Enemy enemy) {
		MP -= heroSpell.getManaCost();
		heroSpell.castSpell(enemy);
	}
	
	
	
	
}
