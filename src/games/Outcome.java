package games;

import java.text.DecimalFormat;

import heroes.Hero;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import screens.*;

public class Outcome {
	Backpack playerBackpack = new Backpack();
	SpellBook playerSpellBook = new SpellBook();
	DecimalFormat df2 = new DecimalFormat(".##");
	
	
	
	public void attackUpdate(TextArea textArea, Hero myHero, Enemy enemy,Label hPLabel,Label mPLabel, Label enemyLabel) {
		
		hPLabel.setText("HP: "+df2.format(myHero.getCurrentHP()));
		mPLabel.setText("MP : "+df2.format(myHero.getMP()));
		enemyLabel.setText("Enemy HP: "+df2.format(enemy.getHP()));
		String outcomes =("\nYou received "+ df2.format(enemy.getDMG()*(1.0d-(myHero.getArmour()/100.0d)))+" Damage from the "+"Enemy"+"!!"+"\nYou Attack for "+ myHero.getDMG()+" Enemy has "+" : "+df2.format(enemy.getHP())+" HP remaining!!\n");
		textArea.appendText(outcomes);
		
	}
	public void spellUpdate(TextArea textArea, Hero myHero, Enemy enemy,Label hPLabel,Label mPLabel, Label enemyLabel) {
		textArea.appendText("\nYou cast : " + myHero.getHeroSpell().getSpellName()+" ["+ myHero.getHeroSpell().effect()+"]");
		String outcomes =("\nEnemy has : "+ df2.format(enemy.getHP())+" HP remaining!!\n");
		textArea.appendText(outcomes);
		hPLabel.setText("HP: "+df2.format(myHero.getCurrentHP()));
		mPLabel.setText("MP : "+df2.format(myHero.getMP()));
		enemyLabel.setText("Enemy HP: "+df2.format(enemy.getHP()));
	}
	
	public double calculateHeroHPBar(Hero myHero) {
		double startingHP = myHero.getActualHP();
		double currentHP = myHero.getCurrentHP();
		double HPPercentage = currentHP/startingHP ;
		return HPPercentage;
	}
	public double calculateEnemyHPBar(Enemy enemy){
		double startingHP = enemy.getStartingHP();
		double currentHP = enemy.getHP();
		double HPPercentage = currentHP/startingHP ;
		return HPPercentage;
		
	}
	public double calculateHeroMPBar(Hero myHero) {
		double startingMP = myHero.getStartingMP();
		double currentMP = myHero.getMP();
		
		double MPPercentage = currentMP/startingMP;
		
		return MPPercentage;
		
	}
	
	public void outcome(Hero myHero, Enemy enemy, DungeonFrame dungeonFrame) {
		if(myHero.getCurrentHP()>0 && enemy.getHP()>0) {
			
			
			
		}
		//if monster's dead
		 if(enemy.getHP()<=0) {
			 String killedMonster = ("\n"+enemy.getEnemyName() + " has been killed!\n");
			 DungeonFrame.textArea.appendText(killedMonster);
			 ContinueFrame cf = new ContinueFrame();
			 DungeonFrame.monstersKilled++;
			 DungeonFrame.hasEnemy=false;
			 LootTable lootDrop = enemy.getItem();
			 
			 //////////////////////////////////////////////
			 double gainedExperience = enemy.getExperience();
			 double exp = (myHero.getExperience() + gainedExperience);
			 myHero.setExperience(exp);
			 myHero.setExpToLevel(myHero.getExpToLevel()-gainedExperience);
			 checkLevelUp(myHero,dungeonFrame);
			 
				if(lootDrop.getName() != "NULL")
				{
					DungeonFrame.textArea.appendText("\nYou received "+ lootDrop.getName() + "!!\n");
					playerBackpack.addItem(lootDrop);
				}
				
			 cf.setContinueScreen(dungeonFrame);
		 }
			if(((enemy.getHP()<=0) && (myHero.getCurrentHP()<=0))||(myHero.getCurrentHP()<=0))
			{
				DungeonFrame.inDungeon = false;
				playerBackpack.emptyBackpack();
				playerSpellBook.emptySpellBook();
				DungeonFrame.textArea.setText("");
				
				
				ScoreScreen ss = new ScoreScreen();
				ss.setScoreScreen(dungeonFrame);
			}

	}  
	public void checkLevelUp(Hero myHero, DungeonFrame dungeonFrame) {
		if(myHero.getExpToLevel()<=0) {
			myHero.setLevel(myHero.getLevel()+1);
			myHero.levelUp();
			DungeonFrame.textArea.appendText("\n------------------------------");
			DungeonFrame.textArea.appendText("\nYou have gained a level !!!!!!");
			DungeonFrame.textArea.appendText("\n------------------------------");
			
			
		}
		
		
	}
}
