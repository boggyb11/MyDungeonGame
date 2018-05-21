package games;

import java.text.DecimalFormat;

import effects.LightBurn;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import screens.DungeonFrame;

public abstract class Hero {
	 static double currentHP;
	 static double actualHP;
	 public static double DMG;
	 static double MP;
	 static double startingMP;
	 private static double experience=0;
	 private static double expToLevel=100;
	 private static int level =1;

	static Spell heroSpell;
	 static Image playerImage;
	 static double armour;
	 DecimalFormat df2 = new DecimalFormat(".##");
	 protected SpellBook addStartSpell = new SpellBook();
	
	public Hero() {
		 
	}
	
	public abstract void levelUp();
	
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

	public  double getMP() {
		return MP;
	}

	public  void setMP(double d) {
		MP = d;
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
	 public double getStartingMP() {
		return startingMP;
	}


	public  void setStartingMP(double startingMP) {
		Hero.startingMP = startingMP;
	}
	
	public void castSpell(DungeonFrame dungeonFrame,TextArea textArea, Hero myHero, Enemy enemy,Label hPLabel, Label mPLabel,Label enemyLabel,ProgressBar heroMPBar,ProgressBar enemyHPBar) {
		if(myHero.getMP()>=(myHero.getHeroSpell().getManaCost())) {
		Outcome outcomeCalculator = new Outcome();
		
			MP -= heroSpell.getManaCost();
			heroSpell.castSpell(enemy);
		   heroMPBar.setProgress(outcomeCalculator.calculateHeroMPBar(myHero));
		   enemyHPBar.setProgress(outcomeCalculator.calculateEnemyHPBar(enemy));
		   outcomeCalculator.spellUpdate(textArea, myHero, enemy, hPLabel, mPLabel, enemyLabel);
		   outcomeCalculator.outcome(myHero, enemy,dungeonFrame);
		
		}
		
		else {
			textArea.appendText("\nYou do not have enough mana to cast that spell!!");
		}
	}


	public double getExperience() {
		return experience;
	}


	public void setExperience(double experience) {
		Hero.experience = experience;
	}


	public double getExpToLevel() {
		return expToLevel;
	}


	public void setExpToLevel(double expToLevel) {
		Hero.expToLevel = expToLevel;
	}


	public int getLevel() {
		return level;
	}


	public void setLevel(int level) {
		Hero.level = level;
	}
	
	
	
	
}
