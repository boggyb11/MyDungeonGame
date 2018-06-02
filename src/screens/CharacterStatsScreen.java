package screens;

import java.text.DecimalFormat;

import games.*;
import heroes.Hero;
import heroes.HeroImageCreator;
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
	private Label level = new Label();
	private Label hP = new Label();
	private Label mP = new Label();
	private Label arm = new Label();
	private Label dmg = new Label();
	private Label exp = new Label();
	private Label expToLvl = new Label();
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
		level.setText("Level: "+myHero.getLevel());
		hP.setText("HP: "+df2.format(myHero.getCurrentHP())+"/"+myHero.getActualHP());
		mP.setText("MP: "+df2.format(myHero.getMP())+"/"+df2.format(myHero.getStartingMP()));
		arm.setText("Armour: "+myHero.getArmour());
		dmg.setText("Damage: "+myHero.getDMG());
		exp.setText("Experience: "+ myHero.getExperience());
		expToLvl.setText("Experience to Level: "+myHero.getExpToLevel());
		continueButton = new Button("Continue");
		continueButton.setOnAction(e ->{
			DungeonFrame hsb = new DungeonFrame();
			hsb.setDungeonFrame();
		
		});
		
		
		stats.getChildren().addAll(level,hP,mP,arm,dmg,exp,expToLvl);
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
