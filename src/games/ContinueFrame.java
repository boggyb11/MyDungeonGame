package games;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class ContinueFrame{
	
	Hero myHero = new Hero();
	Label continueLabel;
	VBox vbox = new VBox(8);
	HBox hbox = new HBox(1);
	Button continueButton;
	Button endButton;
	public void setContinueScreen(){
		   
			continueButton = new Button("Continue");
			continueButton.setOnAction(e ->{
				DungeonFrame hsb = new DungeonFrame();
				hsb.setDungeonFrame();
			
			});
			
			endButton = new Button("End");
			endButton.setOnAction(e ->{
				ScoreScreen ss = new ScoreScreen();
				ss.setScoreScreen();});
			
			
			
			Image heroImage =myHero.getPlayerImage();
			ImageView iv1 = new ImageView();
			iv1.setImage(heroImage);
			iv1.setFitWidth(200);
			iv1.setFitHeight(300);
			iv1.setPreserveRatio(true);
	        iv1.setSmooth(true);
			
			
			
			continueLabel = new Label("Would you like to continue in the dungeon or end your run now ?");
			hbox.getChildren().add(iv1);
			vbox.getChildren().addAll(continueLabel,hbox,DungeonFrame.textArea,continueButton,endButton );
			
			
			Frame.scene3 = new Scene(vbox,600,800);
	    	Frame.window.setScene(Frame.scene3);	
	}
	//test
	
	  
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//}
//	public static void display()
//	{
//	Stage popupwindow=new Stage();
//	      
//	popupwindow.initModality(Modality.APPLICATION_MODAL);
//	popupwindow.setTitle("CONTINUE?");
//	      
//	      
//	Label label1= new Label("Would you like to continue in the Dungeon or Exit ?");
//	      
//	     
//	Button button1= new Button("Continue");
//	     
//	//when continue is clicked, popup closes and new dungeon is started     
//	button1.setOnAction(e ->{
//	@SuppressWarnings("unused")
//	Dungeon myDungeon = new Dungeon();
//	popupwindow.close();}
//	);
//	     
//	     
//
//	VBox layout= new VBox(10);
//	     
//	      
//	layout.getChildren().addAll(label1, button1);
//	      
//	layout.setAlignment(Pos.CENTER);
//	      
//	Scene scene1= new Scene(layout, 300, 250);
//	      
//	popupwindow.setScene(scene1);
//	      
//	popupwindow.showAndWait();
//	       
//	}
//
//	}
