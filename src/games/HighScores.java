package games;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javafx.scene.control.TextArea;

public class HighScores {
	
	private static final String filename = "Assets/HighScores.txt.txt";
	
	
	
	public void readHighScores(TextArea HScores) {
		
		FileReader r=null;
		BufferedReader br = null;
		try {
			File scores = new File(filename);
			r = new FileReader(scores);
			br = new BufferedReader(r);
			 String line;
			    while ((line = br.readLine()) != null) {
			        HScores.appendText(line+"\n");
			        
			    }
			    
		}catch (FileNotFoundException e) {
			e.printStackTrace();
			
		}catch (IOException ioe) {
			ioe.printStackTrace();
			
		}finally {
		try {
			r.close();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
		
		
	}
	

}
/*
 * When you finish a run, store the score in a text document
 * when you click high scores, show the high scores
 * 
 * 
 * 
 */

