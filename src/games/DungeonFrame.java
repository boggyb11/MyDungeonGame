package games;

import java.text.DecimalFormat;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class DungeonFrame {
		static int monstersKilled=0;
		static TextArea textArea = new TextArea();
		static boolean hasEnemy = false;
		Hero myHero = new Hero();
		VBox vbox = new VBox(8);
		HBox hbox = new HBox(3);
		Pane spacer = new Pane();
		Pane spacer2 = new Pane();
		Label hPLabel,mPLabel,enemyLabel;
		Button attack = new Button("Attack");
		Button spell = new Button("Spell");
		Button run = new Button("Run");
		Button backpack = new Button("Backpack");
		Dungeon myDungeon;
		Options options = new Options();
		boolean inDungeon = true;
		Backpack playerBackpack = new Backpack();
		DecimalFormat df2 = new DecimalFormat(".##");
		static Enemy enemy;
		EnemyPicker ep = new EnemyPicker();
		
		
		HBox imageHbox = new HBox(2);
		Image enemyImage;
		
		
		
		public void setDungeonFrame() {
		if(hasEnemy==false) {
			enemy = ep.spawn();
				enemyLabel = new Label("Enemy HP: "+df2.format(enemy.getHP()));
		}
			//Images
			Image heroImage =myHero.getPlayerImage();ImageView iv1 = new ImageView();iv1.setImage(heroImage);iv1.setFitWidth(200);iv1.setFitHeight(300);iv1.setPreserveRatio(true);iv1.setSmooth(true);
	        ImageView iv2 = new ImageView();iv2.setImage(enemy.getEnemyImage());iv2.setFitWidth(200);iv2.setFitHeight(300);iv2.setPreserveRatio(true);iv2.setSmooth(true);
	        
	        //text area and labels
		   textArea.appendText(options.battleOptions());
		   hPLabel= new Label("HP : "+df2.format(myHero.getHP()));mPLabel= new Label("MP : "+myHero.getMP());
		   enemyLabel = new Label("Enemy HP: "+df2.format(enemy.getHP()));
		   //Events
		   attack.setOnAction((event)->{
				doAttack();							
				String outcomes =("\nYou received "+ df2.format(enemy.getDMG()*(1.0d-(myHero.getArmour()/100.0d)))+" Damage from the "+"Enemy"+"!!"+"\nYou Dealt "+ myHero.getDMG()+" Damage to the "+"Enemy"+" : "+df2.format(enemy.getHP())+" HP remaining!!\n");
				textArea.appendText(outcomes);
				hPLabel.setText("HP: "+df2.format(myHero.getHP()));mPLabel.setText("MP : "+myHero.getMP());enemyLabel.setText("Enemy HP: "+enemy.getHP());
				outcome();});
		   spell.setOnAction((event)->{castSpell();outcome();});
		   run.setOnAction((event)->{ContinueFrame cf = new ContinueFrame();cf.setContinueScreen();});
		   backpack.setOnAction((event)->{playerBackpack.displayBackpack();});
		   
		   //set frame
		   HBox.setHgrow(spacer, Priority.ALWAYS);
		   HBox.setHgrow(spacer2, Priority.ALWAYS);
		   hbox.getChildren().addAll(hPLabel,mPLabel,spacer,enemyLabel);
		   imageHbox.getChildren().addAll(iv1,spacer2,iv2);
		   vbox.getChildren().addAll(hbox,imageHbox,textArea,attack,spell,run,backpack);
		   Frame.scene2 = new Scene(vbox,600,800);
		   Frame.window.setScene(Frame.scene2);
	    	
	   }
		
		public void doAttack() {myHero.attack(myHero, enemy);}
		public void outcome() {
			
			if(myHero.getHP()>0 && enemy.getHP()>0) {
			}
			//if monster's dead
			 if(enemy.getHP()<=0) {
				 String killedMonster = ("\n"+enemy.getEnemyName() + " has been killed!\n");
				textArea.appendText(killedMonster);
				ContinueFrame cf = new ContinueFrame();
				 monstersKilled++;
				 hasEnemy =false;
				 LootTable lootDrop = enemy.getItem();
					if(lootDrop.getName() != "NULL")
					{
						textArea.appendText("\nYou received "+ lootDrop.getName() + "!!\n");
						playerBackpack.addItem(lootDrop);
					}
					
				 cf.setContinueScreen();
			 }
				if(((enemy.getHP()<=0) && (myHero.getHP()<=0))||(myHero.getHP()<=0))
				{
					inDungeon = false;
					playerBackpack.emptyBackpack();
					textArea.setText("");
					
					
					ScoreScreen ss = new ScoreScreen();
					ss.setScoreScreen();
				}

		}   
		public TextArea getTextArea() {return textArea;}
		public void setTextArea(String text) {textArea.setText(text);}
		public void castSpell() {
			if(myHero.getMP()>=(myHero.getHeroSpell().getManaCost())) {
				myHero.castSpell(myHero, enemy);
				textArea.appendText("\nYou cast : "+ myHero.getHeroSpell().getSpellName());
				 String outcomes =("\nYou Dealt "+ myHero.getHeroSpell().getSpellDmg()+" Damage to the "+"Enemy"+" : "+enemy.getHP()+" HP remaining!!\n");
				 textArea.appendText(outcomes);
				 
			}
			else {
				textArea.appendText("\nYou do not have enough mana to cast that spell!!");
			}
			 hPLabel.setText("HP: "+myHero.getHP()); 
			 mPLabel.setText("MP : "+myHero.getMP()); 
		}
	

	
	
	
	
	
	
	
	
	
	

}
