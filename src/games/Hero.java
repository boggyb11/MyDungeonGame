package games;

import java.text.DecimalFormat;

import javafx.scene.image.Image;

public class Hero {
	 static double HP;
	 static double DMG;
	 static int MP;
	 static Spell heroSpell;
	 static Image playerImage;
	 static double armour;



	public Hero() {
		 
	}

	public void attack(Hero hero, Enemy enemy) {
		calcHeroHp(enemy.attack(hero));
		enemy.setHP(calcEnemyHP(enemy.getHP()));
	}
	public void calcHeroHp(double heroHP) {
		HP = heroHP;
		DecimalFormat df2 = new DecimalFormat(".##");
		df2.format(HP);
	}
	public double calcEnemyHP(double enemyHP) {
		
		double EnemyHP = enemyHP;
		EnemyHP -=DMG;
		return EnemyHP;
		
	}
	public double getHP() {
		return HP;
	}
	public void setHP(double hP) {
		HP = hP;
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
		enemy.setHP(enemy.getHP()-(heroSpell.getSpellDmg()));
	}
	
	
	
	
}
