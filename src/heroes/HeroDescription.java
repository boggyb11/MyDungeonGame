package heroes;

import javafx.scene.control.TextArea;

public class HeroDescription {

	
	public TextArea createDescription(String description) {
		
		TextArea newHeroDescription = new TextArea(description);
		
		newHeroDescription.setMaxWidth(200);
		newHeroDescription.setMaxHeight(200);
		newHeroDescription.setWrapText(true); 
		newHeroDescription.setEditable(false);
	    
	    
	    return newHeroDescription;
	}
	
	
}
