package effects;

import java.util.Random;

import games.Effect;
import games.Enemy;
import screens.DungeonFrame;

public class Stun extends Effect {

	@Override
	public void applyEffect(Enemy enemy,DungeonFrame dungeon) {
		enemy.isStunned=true;

	}

	
	
	public void stunCheck(Enemy enemy) {
		Random rand = new Random();
		
		int num = rand.nextInt(10);
		if(num>5) {
			enemy.isStunned=false;
		}
		
	
	}
}
