package screens;

import java.text.DecimalFormat;

import games.*;
import heroes.Hero;
import heroes.HeroImageCreator;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class DungeonFrame {
		public static int monstersKilled=0;
		public static TextArea textArea = new TextArea();
		public static boolean hasEnemy = false;
		public static Enemy enemy;
		public static boolean inDungeon = true;
		
		private final Button attack = new Button("Attack");
		private final Button spell = new Button("Spell");
		private final Button run = new Button("Run");
		private final Button backpack = new Button("Backpack");
		private final Button spellBook = new Button("SpellBook");
		private final Button heroStats = new Button("Hero Stats");
		
		
		CharacterCreator cc = new CharacterCreator();
		Hero myHero = cc.getMyHero();
		VBox vbox = new VBox(8);
		HBox labelBox = new HBox(3);
		HBox actionBox1 = new HBox(1);
		HBox actionBox2 = new HBox(1);
		HBox barBox = new HBox(3);
		Pane spacer = new Pane();
		Pane spacer2 = new Pane();
		Pane spacer3 = new Pane();
		Pane actionBox1SpacerL = new Pane();
		Pane actionBox1SpacerR = new Pane();
		Pane actionBox2SpacerL = new Pane();
		Pane actionBox2SpacerR = new Pane();
		
		Label hPLabel,mPLabel,enemyLabel;
		HBox imageHbox = new HBox(2);
		Image enemyImage;
		
		


		Options options = new Options();
		Backpack playerBackpack = new Backpack();
		SpellBook playerSpellBook = new SpellBook();
		EnemyPicker ep = new EnemyPicker();
		HeroImageCreator heroImage = new HeroImageCreator();
		DecimalFormat df2 = new DecimalFormat(".##");
		Outcome outcomeCalculator = new Outcome();
		
		ProgressBar heroHPBar;// = new ProgressBar(outcomeCalculator.calculateHeroHPBar(myHero));
		ProgressBar enemyHPBar;// = new ProgressBar(outcomeCalculator.calculateEnemyHPBar(enemy));
		ProgressBar heroMPBar;// = new ProgressBar(1);

		
		
		public void setDungeonFrame() {
			textArea.setEditable(false);
			
		if(hasEnemy==false) {
			enemy = ep.spawn(this);
				enemyLabel = new Label("Enemy HP: "+df2.format(enemy.getHP()));
		}
		
			ImageView myHeroImage = heroImage.setHeroImage(myHero.getPlayerImage());
			ImageView myEnemyImage = heroImage.setHeroImage(enemy.getEnemyImage());
	        
			textArea.appendText(options.battleOptions());
			hPLabel= new Label("HP : "+df2.format(myHero.getCurrentHP()));mPLabel= new Label("MP : "+myHero.getMP());
			enemyLabel = new Label("Enemy HP: "+df2.format(enemy.getHP()));
			
			heroHPBar= new ProgressBar(outcomeCalculator.calculateHeroHPBar(myHero));
			enemyHPBar = new ProgressBar(outcomeCalculator.calculateEnemyHPBar(enemy));
			heroMPBar = new ProgressBar(outcomeCalculator.calculateHeroMPBar(myHero));
			heroHPBar.setStyle("-fx-accent: green;");
			heroMPBar.setStyle("-fx-accent: blue");
			enemyHPBar.setStyle("-fx-accent: red;");
		   
		   setAttackButton();setSpellButton();setRunButton();setBackpackButton();setSpellBookButton();setHeroStatsButton();

		   HBox.setHgrow(spacer, Priority.ALWAYS);
		   HBox.setHgrow(spacer2, Priority.ALWAYS);
		   HBox.setHgrow(spacer3, Priority.ALWAYS);
		   HBox.setHgrow(actionBox1SpacerL, Priority.ALWAYS);
		   HBox.setHgrow(actionBox1SpacerR, Priority.ALWAYS);
		   HBox.setHgrow(actionBox2SpacerL, Priority.ALWAYS);
		   HBox.setHgrow(actionBox2SpacerR, Priority.ALWAYS);
		   
		   labelBox.getChildren().addAll(hPLabel,mPLabel,spacer,enemyLabel);
		   barBox.getChildren().addAll(heroHPBar,heroMPBar,spacer3,enemyHPBar);
		   imageHbox.getChildren().addAll(myHeroImage,spacer2,myEnemyImage);
		   actionBox1.getChildren().addAll(attack,actionBox1SpacerL,spell,actionBox1SpacerR,run);
		   actionBox2.getChildren().addAll(backpack,actionBox2SpacerL,spellBook,actionBox2SpacerR,heroStats);
		   
		   
		   vbox.getChildren().addAll(labelBox,barBox,imageHbox,textArea,actionBox1,actionBox2);
		   
		   Frame.setScene2(new Scene(vbox,600,800));
		   Frame.getWindow().setScene(Frame.getScene2());
	    	
	   }
		
		
		public void setAttackButton() {
			  attack.setOnAction((event)->{
					myHero.attack(myHero, enemy);
					
					heroHPBar.setProgress(outcomeCalculator.calculateHeroHPBar(myHero));
					enemyHPBar.setProgress(outcomeCalculator.calculateEnemyHPBar(enemy));
					
					outcomeCalculator.attackUpdate(textArea, myHero, enemy, hPLabel, mPLabel, enemyLabel);
					outcomeCalculator.outcome(myHero, enemy,this);});
		}
		public void setSpellButton() {
			
			   spell.setOnAction((event)->{
				   myHero.castSpell(this, textArea, myHero, enemy, enemyLabel, enemyLabel, enemyLabel, enemyHPBar, enemyHPBar);
				   
				   heroMPBar.setProgress(outcomeCalculator.calculateHeroMPBar(myHero));
				   enemyHPBar.setProgress(outcomeCalculator.calculateEnemyHPBar(enemy));
				   });

		}
		public void setRunButton() {
			  run.setOnAction((event)->{ContinueFrame cf = new ContinueFrame();cf.setContinueScreen(this);});
			
		}
		public void setBackpackButton() {
			
			   backpack.setOnAction((event)->{playerBackpack.displayBackpack(this);});

			
		}
		public void setSpellBookButton() {
			
			spellBook.setOnAction((event)->{playerSpellBook.displaySpellBook(this);});
		}


		public void setHeroStatsButton() {
			CharacterStatsScreen statsScreen = new CharacterStatsScreen();
			heroStats.setOnAction((event)->{statsScreen.showStatsScreen(myHero);});
		}
		
	


	
	
	
	
	
	//////////// GETTERS AND SETTERS/////////////////
	
	public void setTextArea(String text) {
		textArea.setText(text);
	}
	
	public Enemy getEnemy() {
		return enemy;
	}
	
	public TextArea getTextArea() {
		return textArea;
	}
	
	public static int getMonstersKilled() {
		return monstersKilled;
	}

	public static void setMonstersKilled(int monstersKilled) {
		DungeonFrame.monstersKilled = monstersKilled;
	}

	public static boolean isHasEnemy() {
		return hasEnemy;
	}

	public static void setHasEnemy(boolean hasEnemy) {
		DungeonFrame.hasEnemy = hasEnemy;
	}

	public static boolean isInDungeon() {
		return inDungeon;
	}

	public static void setInDungeon(boolean inDungeon) {
		DungeonFrame.inDungeon = inDungeon;
	}

	public void setTextArea(TextArea textArea) {
		DungeonFrame.textArea = textArea;
	}

	public static void setEnemy(Enemy enemy) {
		DungeonFrame.enemy = enemy;
	}

	public Label gethPLabel() {
		return hPLabel;
	}

	public void sethPLabel(Label hPLabel) {
		this.hPLabel = hPLabel;
	}

	public Label getmPLabel() {
		return mPLabel;
	}

	public void setmPLabel(Label mPLabel) {
		this.mPLabel = mPLabel;
	}


	public HBox getBarBox() {
		return barBox;
	}


	public void setBarBox(HBox barBox) {
		this.barBox = barBox;
	}


	public Button getHeroStats() {
		return heroStats;
	}



	
	
	
	

}
