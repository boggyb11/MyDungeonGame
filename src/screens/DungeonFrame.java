package screens;

import java.text.DecimalFormat;

import games.*;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
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
		
		final ProgressBar pb = new ProgressBar(0);
	    final ProgressIndicator pi = new ProgressIndicator(0);
		
		Hero myHero = new Hero();
		VBox vbox = new VBox(8);
		HBox labelBox = new HBox(3);
		HBox barBox = new HBox(3);
		Pane spacer = new Pane();
		Pane spacer2 = new Pane();
		Label hPLabel,mPLabel,enemyLabel;
		HBox imageHbox = new HBox(2);
		Image enemyImage;
		
		


		Dungeon myDungeon;
		Options options = new Options();
		Backpack playerBackpack = new Backpack();
		SpellBook playerSpellBook = new SpellBook();
		EnemyPicker ep = new EnemyPicker();
		HeroImageCreator heroImage = new HeroImageCreator();
		DecimalFormat df2 = new DecimalFormat(".##");
		Outcome outcomeCalculator = new Outcome();

		
		
		public void setDungeonFrame() {
			textArea.setEditable(false);
			
		if(hasEnemy==false) {
			enemy = ep.spawn();
				enemyLabel = new Label("Enemy HP: "+df2.format(enemy.getHP()));
		}
		
			ImageView myHeroImage = heroImage.setHeroImage(myHero.getPlayerImage());
			ImageView myEnemyImage = heroImage.setHeroImage(enemy.getEnemyImage());
	        
		   textArea.appendText(options.battleOptions());
		   hPLabel= new Label("HP : "+df2.format(myHero.getCurrentHP()));mPLabel= new Label("MP : "+myHero.getMP());
		   enemyLabel = new Label("Enemy HP: "+df2.format(enemy.getHP()));
		  
		   
		   
		   
		  pb.setProgress(calculateHeroHPBar());
		   
		   
		   
		   setAttackButton();setSpellButton();setRunButton();setBackpackButton();setSpellBookButton();

		   HBox.setHgrow(spacer, Priority.ALWAYS);
		   HBox.setHgrow(spacer2, Priority.ALWAYS);
		   
		   labelBox.getChildren().addAll(hPLabel,mPLabel,spacer,enemyLabel);
		   barBox.getChildren().add(pb);
		   imageHbox.getChildren().addAll(myHeroImage,spacer2,myEnemyImage);
		   vbox.getChildren().addAll(labelBox,barBox,imageHbox,textArea,attack,spell,run,backpack,spellBook);
		   
		   Frame.setScene2(new Scene(vbox,600,800));
		   Frame.getWindow().setScene(Frame.getScene2());
	    	
	   }
		
		public void doAttack() {myHero.attack(myHero, enemy);}
		
		public void setAttackButton() {
			  attack.setOnAction((event)->{
					doAttack();							
					String outcomes =("\nYou received "+ df2.format(enemy.getDMG()*(1.0d-(myHero.getArmour()/100.0d)))+" Damage from the "+"Enemy"+"!!"+"\nYou Attack for "+ myHero.getDMG()+" Enemy has "+" : "+df2.format(enemy.getHP())+" HP remaining!!\n");
					textArea.appendText(outcomes);
					pb.setProgress(calculateHeroHPBar());
					System.out.println(calculateHeroHPBar());
					hPLabel.setText("HP: "+df2.format(myHero.getCurrentHP()));mPLabel.setText("MP : "+myHero.getMP());enemyLabel.setText("Enemy HP: "+enemy.getHP());
					outcomeCalculator.outcome(myHero, enemy);});
			
			
		}
		public void setSpellButton() {
			
			   spell.setOnAction((event)->{castSpell();outcomeCalculator.outcome(myHero, enemy);});

		}
		public void setRunButton() {
			  run.setOnAction((event)->{ContinueFrame cf = new ContinueFrame();cf.setContinueScreen();});
			
		}
		public void setBackpackButton() {
			
			   backpack.setOnAction((event)->{playerBackpack.displayBackpack();});

			
		}
		public void setSpellBookButton() {
			
			spellBook.setOnAction((event)->{playerSpellBook.displaySpellBook();});
		}
		public void setTextArea(String text) {textArea.setText(text);}
		public TextArea getTextArea() {return textArea;}
		
		
		public void castSpell() {
			if(myHero.getMP()>=(myHero.getHeroSpell().getManaCost())) {
				
				myHero.castSpell(myHero, enemy);
				textArea.appendText("\nYou cast : " + myHero.getHeroSpell().getSpellName()+" ["+ myHero.getHeroSpell().effect()+"]");
				String outcomes =("\nEnemy has : "+ df2.format(enemy.getHP())+" HP remaining!!\n");
				textArea.appendText(outcomes);
				hPLabel.setText("HP: "+df2.format(myHero.getCurrentHP()));mPLabel.setText("MP : "+myHero.getMP());enemyLabel.setText("Enemy HP: "+enemy.getHP());
				 
			}
			else {
				textArea.appendText("\nYou do not have enough mana to cast that spell!!");
			}
			 hPLabel.setText("HP: "+myHero.getCurrentHP()); 
			 mPLabel.setText("MP : "+myHero.getMP()); 
		}
	

	public Enemy getEnemy() {
		
		
		return enemy;
	}
	
	public double calculateHeroHPBar() {
		double startingHP = myHero.getActualHP();
		double currentHP = myHero.getCurrentHP();
		
		double HPPercentage = currentHP/startingHP ;
		
		return HPPercentage;
	}


	
	
	
	

}
