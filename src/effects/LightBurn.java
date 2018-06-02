package effects;

import games.Effect;
import games.Enemy;
import screens.DungeonFrame;

public class LightBurn extends Effect {

private static int burningCount = 2;

@Override
	public void applyEffect(Enemy enemy,DungeonFrame dungeon) {
	enemy.isBurning =true;
	burn(enemy, dungeon);
	}

public void burn(Enemy enemy, DungeonFrame dungeon) {
	if (enemy.isBurning) {
		if(burningCount>=1)	{
			enemy.setHP(enemy.getHP()-5);
			dungeon.getTextArea().appendText("\nEnemy burned for 5 Dmg!");
			burningCount --;
		}
		else enemy.isBurning =false;
	}
	
}

}
