package games;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HeroImageCreator {

	
	
	public ImageView setHeroImage(Image hero) {
		ImageView newHeroImage = new ImageView();
		newHeroImage.setImage(hero);
		newHeroImage.setFitWidth(200);
		newHeroImage.setFitHeight(300);
		newHeroImage.setPreserveRatio(true);
		newHeroImage.setSmooth(true);
		
		return newHeroImage;
	}
}
