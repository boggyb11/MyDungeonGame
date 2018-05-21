package screens;

import games.CharacterCreator;
import games.Frame;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class WelcomeScreen {

	private final Button play = new Button("Play");
	private final Button highScores = new Button("High Scores");
	private final Button options = new Button("Options");
	private final Label title= new Label("Dungeon Run");
	private final BackgroundImage myBI= new BackgroundImage(new Image("welcomeImage.png",600,800,false,true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
	private final Background BG = new Background(myBI);
	VBox vbox = new VBox(20);
	
	public void setWelcomeScreen() {
		play.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	CharacterCreator cc = new CharacterCreator();
		    	cc.characterSelect();
		    
		    }
		});
		
		play.setFont(Font.font("Verdana",20));
		highScores.setFont(Font.font("Verdana",20));
		options.setFont(Font.font("Verdana",20));
		title.setFont(Font.font("Verdana",30));
		title.setTextFill(Color.BLUE);
		
		vbox.setAlignment(Pos.CENTER);		
		vbox.setBackground(BG);
		vbox.getChildren().addAll(title,play,highScores,options);
		Frame.setWelcomeScene(new Scene(vbox, 600,800));
		   Frame.getWindow().setScene(Frame.getWelcomeScene());
		   
		   
	}
	
	
	
	
	
	
	

	
	
}
