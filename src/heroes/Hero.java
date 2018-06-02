package heroes;

import java.text.DecimalFormat;

import effects.LightBurn;
import effects.SeriousBurn;
import effects.Stun;
import games.Enemy;
import games.Outcome;
import games.Spell;
import games.SpellBook;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import screens.DungeonFrame;

public abstract class Hero {
	public static double currentHP;
	public static double actualHP;
	 public static double DMG;
	 public static double MP;
	 public static double startingMP;
	 public static double experience=0;
	 private static double expToLevel=100;
	 public static int level =1;
	 private String type;

	public static Spell heroSpell;
	 static Image playerImage;
	 public static double armour;
	 DecimalFormat df2 = new DecimalFormat(".##");
	 protected SpellBook addStartSpell = new SpellBook();
	
	public Hero() {
		 
	}
	
	public abstract void levelUp();
	
	public void attack(Hero hero, Enemy enemy,DungeonFrame dungeon) {
		
		if(enemy.isBurning) {
			LightBurn lb = new LightBurn();
			lb.burn(enemy, dungeon);
		}
		if(enemy.isSeriousBurning) {
			SeriousBurn sb = new SeriousBurn();
			sb.burn(enemy, dungeon);
			
		}
		if(enemy.isStunned) {
			enemy.setHP(calcEnemyHP(enemy.getHP()));
			Stun stun = new Stun();
			stun.stunCheck(enemy);
			return;
			
		}
		calcHeroHp(enemy.attack(hero));
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
		df2.format(Hero.actualHP);
	}


	public void setCurrentHP(double hP) {
		currentHP = hP;
		df2.format(Hero.currentHP);
	}


	public  double getMP() {
	//	df2.format(Hero.MP);
		return MP;
	}

	public  void setMP(double d) {
		Hero.MP = d;
		df2.format(Hero.MP);
	}
	 public double getStartingMP() {
		// df2.format(Hero.startingMP);
		return startingMP;
	}


	public  void setStartingMP(double startingMP) {
		Hero.startingMP = startingMP;
		df2.format(Hero.startingMP);
	}
	

	public Spell getHeroSpell() {
		return heroSpell;
	}
	public double getDMG() {
		return DMG;
	}
	public void setDMG(double dMG) {
		DMG = dMG;
		df2.format(Hero.DMG);
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
		df2.format(Hero.armour);
	}


	public void setHeroSpell(Spell heroSpellIn) {
		heroSpell = heroSpellIn;
	}

	public void castSpell(DungeonFrame dungeonFrame,TextArea textArea, Hero myHero, Enemy enemy,Label hPLabel, Label mPLabel,Label enemyLabel,ProgressBar heroMPBar,ProgressBar enemyHPBar) {
		if(myHero.getMP()>=(myHero.getHeroSpell().getManaCost())) {
		Outcome outcomeCalculator = new Outcome();
		
			MP -= heroSpell.getManaCost();
			heroSpell.castSpell(enemy,myHero, dungeonFrame);
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
	
}
