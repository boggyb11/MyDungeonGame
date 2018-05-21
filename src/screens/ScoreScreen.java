package screens;

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
	public void setScoreScreen(){
		playAgain = new Button("Play Again");
		playAgain.setOnAction(e ->{
			
			playerSpellBook.emptySpellBook();
			playerBackpack.emptyBackpack();
			
    		CharacterCreator cc = new CharacterCreator();
    		DungeonFrame.hasEnemy=false;
    		
    		
    		
    		DungeonFrame.monstersKilled=0;
    		cc.characterSelect();
    		
    		
    		
    		
		});
		
		
		   enemiesKilled = new Label("\nCongratulations you have killed : "+DungeonFrame.monstersKilled+" Enemies !!!!!!!");
		   vbox.getChildren().addAll(enemiesKilled,playAgain);
			Frame.setScene4(new Scene(vbox,600,800));
	    	Frame.getWindow().setScene(Frame.getScene4());	
	    	
	    	
	    
	}
	
	
	  
}
