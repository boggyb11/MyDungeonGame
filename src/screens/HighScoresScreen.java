package screens;

import games.Frame;
import games.HighScores;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class HighScoresScreen {
	private final Label title= new Label("High Scores");
	private final TextArea scores= new TextArea();
	VBox vbox = new VBox(20);
	
	public void showHighScores() {
		
		title.setFont(Font.font("Verdana",30));
		title.setTextFill(Color.BLUE);
		
		HighScores hs = new HighScores();
		hs.readHighScores(scores);
		
		
		
		
		
		vbox.setAlignment(Pos.CENTER);		
		vbox.getChildren().addAll(title,scores);
		Frame.setHighScoresScene(new Scene(vbox, 600,800));
		   Frame.getWindow().setScene(Frame.getHighScoresScene());
	}
	
	
	
}
