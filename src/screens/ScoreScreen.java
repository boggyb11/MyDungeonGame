package screens;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import games.Backpack;
import games.CharacterCreator;
import games.Frame;
import games.SpellBook;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ScoreScreen {
	Backpack playerBackpack = new Backpack();
	SpellBook playerSpellBook = new SpellBook();
	Label enemiesKilled;
	VBox vbox = new VBox(8);
	Button playAgain;
	
	public static final File f = new File("Assets/HighScores.txt");
	
	
	public void setScoreScreen(DungeonFrame dungeonFrame){
		playAgain = new Button("Play Again");
		playAgain.setOnAction(e ->{
			
			playerSpellBook.emptySpellBook();
			playerBackpack.emptyBackpack();
			
    		CharacterCreator cc = new CharacterCreator();
    		DungeonFrame.hasEnemy=false;
    		
    		
    		
    		DungeonFrame.monstersKilled=0;
    		cc.characterSelect();
    		
    		
    		Date date = new Date();
    		String scoreDate = date.toString();
    		//creating the line to be written to the high scores file
    		//Format:
    		// Class:____;Score:____;Date:____;
    		String score = "Class: "+dungeonFrame.myHero.getType()+" Score: "+DungeonFrame.monstersKilled+" Date: "+scoreDate;
    		storeHighScore(score);	
    		System.out.println(score);
    		
		});

		   enemiesKilled = new Label("\nCongratulations you have killed : "+DungeonFrame.monstersKilled+" Enemies !!!!!!!");
		   vbox.getChildren().addAll(enemiesKilled,playAgain);
			Frame.setScene4(new Scene(vbox,600,800));
	    	Frame.getWindow().setScene(Frame.getScene4());	
	    	
	    	
	    
	}
	
	public void storeHighScore(String score) {
		
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			
			fw = new FileWriter(f);
			bw= new BufferedWriter(fw);
			
			fw.write(score);
			bw.write(score);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		finally {
				try {
					//fw.close();
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			
		}
		
		
		
		//write high score to file
		//read high scores
		//sort them by highest value
		//write the top 5
		
		
		
	}
	
	
	  
}
