package effects;

import games.Effect;
import games.Enemy;
import screens.DungeonFrame;

public class LightBurn extends Effect {

private static int burningCount = 2;//bad place for static not sure how else to do it
DungeonFrame myDungeon = new DungeonFrame();

@Override
	public void applyEffect(Enemy enemy) {
	enemy.isBurning =true;
	burn(enemy);
	}

public void burn(Enemy enemy) {
	if (enemy.isBurning) {
		if(burningCount>=1)	{
			DungeonFrame.enemy.setHP(DungeonFrame.enemy.getHP()-5);
			myDungeon.getTextArea().appendText("\nEnemy burned for 5 Dmg!");
			burningCount --;
		}
		else enemy.isBurning =false;
	}
	
}

}
