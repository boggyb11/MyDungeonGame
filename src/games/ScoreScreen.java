package games;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ScoreScreen {
	
	Label enemiesKilled;
	VBox vbox = new VBox(8);
	Button playAgain;
	public void setScoreScreen(){
		playAgain = new Button("Play Again");
		playAgain.setOnAction(e ->{
    		//Frame f = new Frame();
    		CharacterCreator cc = new CharacterCreator();
    		DungeonFrame.hasEnemy=false;
    		DungeonFrame.monstersKilled=0;
    		//f.setStart();
    		cc.characterSelect();
		});
		
		
		   enemiesKilled = new Label("\nCongratulations you have killed : "+DungeonFrame.monstersKilled+" Enemies !!!!!!!");
		   vbox.getChildren().addAll(enemiesKilled,playAgain);
			Frame.scene4 = new Scene(vbox,600,800);
	    	Frame.window.setScene(Frame.scene4);	
	    	
	    	
	    
	}
	
	
	  
}
