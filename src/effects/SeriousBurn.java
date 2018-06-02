package effects;

import games.Effect;
import games.Enemy;
import screens.DungeonFrame;

public class SeriousBurn extends Effect {

	private static int seriousBurningCount = 2;
	@Override
	public void applyEffect(Enemy enemy,DungeonFrame dungeon) {
		enemy.isBurning =true;
		burn(enemy, dungeon);

	}
	
	public void burn(Enemy enemy, DungeonFrame dungeon) {
		if (enemy.isBurning) {
			if(seriousBurningCount>=1)	{
				enemy.setHP(enemy.getHP()-10);
				dungeon.getTextArea().appendText("\nEnemy burned for 10 Dmg!");
				seriousBurningCount --;
			}
			else enemy.isBurning =false;
		}
		
	}

	public static int getSeriousBurningCount() {
		return seriousBurningCount;
	}

	public static void setSeriousBurningCount(int burningCount) {
		seriousBurningCount = burningCount;
	}

}
