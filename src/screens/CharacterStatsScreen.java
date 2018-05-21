package screens;

import java.text.DecimalFormat;

import games.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CharacterStatsScreen {
	
	private Scene charStatsScene;
	
	//Label Name = new Label();
	//Label herotype = new Label();
	//private Label level = new Label();
	private Label HP = new Label();
	private Label MP = new Label();
	private Label Arm = new Label();
	private Label Dmg = new Label();
	//private Label Exp = new Label();
	//private Label ExpToLvl = new Label();
	private Button continueButton;
	
	HeroImageCreator heroImage = new HeroImageCreator();
	DecimalFormat df2 = new DecimalFormat(".##");
	
	//private HBox topBox = new HBox(10);
	private VBox stats = new VBox(5);
	private HBox middle = new HBox(10);
	private HBox bottom = new HBox(10);
	private VBox all = new VBox(10);
	
	
	public void showStatsScreen(Hero myHero) {
		ImageView heroImageView = heroImage.setHeroImage(myHero.getPlayerImage());
		
		HP.setText("HP: "+df2.format(myHero.getCurrentHP())+"/"+myHero.getActualHP());
		MP.setText("MP: "+myHero.getMP()+"/"+myHero.getStartingMP());
		Arm.setText("Armour: "+myHero.getArmour());
		Dmg.setText("Damage: "+myHero.getDMG());
		
		continueButton = new Button("Continue");
		continueButton.setOnAction(e ->{
			DungeonFrame hsb = new DungeonFrame();
			hsb.setDungeonFrame();
		
		});
		
		
		stats.getChildren().addAll(HP,MP,Arm,Dmg);
		middle.getChildren().addAll(stats,heroImageView);
		bottom.getChildren().add(continueButton);
		all.getChildren().addAll(middle,bottom);
		charStatsScene=(new Scene(all,600,800));
    	Frame.getWindow().setScene(charStatsScene);	
		
		
	}

	public Scene getCharStatsScene() {
		return charStatsScene;
	}

	public void setCharStatsScene(Scene charStatsScene) {
		this.charStatsScene = charStatsScene;
	}
	
	
	
}
