package games;

import screens.*;

public class Outcome {
	Backpack playerBackpack = new Backpack();
	SpellBook playerSpellBook = new SpellBook();
	public void outcome(Hero myHero, Enemy enemy) {
		
		//can put updates in here !!!
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
				if(lootDrop.getName() != "NULL")
				{
					DungeonFrame.textArea.appendText("\nYou received "+ lootDrop.getName() + "!!\n");
					playerBackpack.addItem(lootDrop);
				}
				
			 cf.setContinueScreen();
		 }
			if(((enemy.getHP()<=0) && (myHero.getCurrentHP()<=0))||(myHero.getCurrentHP()<=0))
			{
				DungeonFrame.inDungeon = false;
				playerBackpack.emptyBackpack();
				playerSpellBook.emptySpellBook();
				DungeonFrame.textArea.setText("");
				
				
				ScoreScreen ss = new ScoreScreen();
				ss.setScoreScreen();
			}

	}   
}
