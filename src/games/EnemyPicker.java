package games;

import java.util.Random;

import monsters.Gnoll;
import monsters.Imp;
import monsters.Skeleton;
import screens.DungeonFrame;

public class EnemyPicker {

	final String[] simpleEnemy =new String [] {"Imp","Skeleton","Gnoll"};
public String getEnemy() {
		
		Random rand = new Random();
		int index = rand.nextInt(simpleEnemy.length);
		return simpleEnemy[index];
	}
	public Enemy spawn() {
		
		switch(getEnemy()) {
		case "Imp": {
			DungeonFrame.hasEnemy=true;
			 DungeonFrame.enemy = new Imp();
		DungeonFrame.textArea.appendText("Imp has appeared!\n");	
			 return new Imp();
		}
		case "Skeleton" :{
			DungeonFrame.hasEnemy=true;
			DungeonFrame.enemy = new Skeleton();
			DungeonFrame.textArea.appendText("Skeleton has appeared!\n");
			
			return new Skeleton();
		}
		
		case "Gnoll" :{
			DungeonFrame.hasEnemy=true;
			DungeonFrame.enemy = new Gnoll();
			DungeonFrame.textArea.appendText("Gnoll has appeared!\n");
			 
			return new Gnoll();
		}
		
		default:{
			return new Gnoll();
		
		}
		}
		
	}
}
