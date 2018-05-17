package games;

import java.util.Random;

import javafx.scene.image.Image;


public abstract class Enemy {

	 private double EnemyHP;
	 private double EnemyDMG;
	 private String enemyName;
	 private double armour;
	 private Image enemyImage;
	 
	 
	 


	public double attack(Hero hero) {
		return 0;
	}
	public void make() {
	}
	
	
	
	
	
		public double getArmour() {return armour;}
		public void setArmour(double armour) {this.armour = armour;}
		public double getHP() {return EnemyHP;}
		public void setHP(double hP) {this.EnemyHP = hP;}
		public double getDMG() {return EnemyDMG;}
		public void setDMG(double dMG) {this.EnemyDMG = dMG;}		
		public  String getEnemyName() {return enemyName;}
		public  void setEnemyName(String enemyName) {this.enemyName = enemyName;}
		public LootTable getItem() {
		LootTable dropItem;
		Random rnd = new Random();
		int i = rnd.nextInt(LootTable.itemPack_01.length);
		int l = LootTable.itemPack_01.length;
		if(i>l) {
			dropItem = LootTable.NULL;
		}
		else {dropItem = LootTable.itemPack_01[i];}
		return dropItem;
	}
		public Image getEnemyImage() {
			return enemyImage;
		}
		public void setEnemyImage(Image enemyImage) {
			this.enemyImage = enemyImage;
		}
}
	
