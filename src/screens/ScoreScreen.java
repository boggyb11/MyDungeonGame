package screens;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;

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
	Date date = new Date();
	String scoreDate = date.toString();
	ArrayList<String> scoreList = new ArrayList<>();
	public static final File f = new File("Assets/HighScores.txt");
	
	
	public void setScoreScreen(DungeonFrame dungeonFrame){
		playAgain = new Button("Play Again");
		playAgain.setOnAction(e ->{
			
    		
    		String score = "Class: "+dungeonFrame.myHero.getType()+", Score: -"+DungeonFrame.monstersKilled+"-, Date: "+scoreDate+"\n";
    		storeHighScore(score);
    		readFile();
    		
    		reset();
		});
		   enemiesKilled = new Label("\nCongratulations you have killed : "+DungeonFrame.monstersKilled+" Enemies !!!!!!!");
		   vbox.getChildren().addAll(enemiesKilled,playAgain);
			Frame.setScene4(new Scene(vbox,600,800));
	    	Frame.getWindow().setScene(Frame.getScene4());	
	}
	public void reset() {
		CharacterCreator cc = new CharacterCreator();
		playerSpellBook.emptySpellBook();
		playerBackpack.emptyBackpack();
		DungeonFrame.hasEnemy=false;
		DungeonFrame.monstersKilled=0;
		cc.characterSelect();
	}
	public void storeHighScore(String score) {
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(f,true);
			bw= new BufferedWriter(fw);
			bw.write(score);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
				try {
					if (bw != null) {
						bw.close();
					}
					if(fw!=null) {
						fw.close();
					}
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			
		}

	}
	public void sortingTopFive() {
		overWriteScore();
		String [] parts;
		ArrayList<String> allScores = new ArrayList<>();
		
		Iterator<String> scoresOne = scoreList.iterator();
		while (scoresOne.hasNext()) {
			String score=scoresOne.next();
			parts = score.split("-");
			String scorePart = parts[1];
			allScores.add(scorePart);
		}
		Collections.sort(allScores);
		for(String sortedScore: allScores) {
					Iterator<String> scores = scoreList.iterator();
					while (scores.hasNext()) {
						String score= scores.next();
						parts = score.split("-");
						String scorePart = parts[1];
						
						if(sortedScore.equals(scorePart)) {
							storeHighScore(score.toString()+"\n");
							System.out.println(score.toString());
							scoreList.remove(score);
							break;
					}
			}
		}
	}
	
	public void readFile() {
		FileReader r=null;
		BufferedReader br = null;
		try {
			r = new FileReader(f);
			br = new BufferedReader(r);
			String line ;
			while ((line = br.readLine()) != null) {
		       scoreList.add(line);
		    }
			sortingTopFive();
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
			
		}catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		finally {
		try {
			r.close();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
		
		
		
		
	}
	
	public void overWriteScore() {
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(f);
			bw= new BufferedWriter(fw);
			bw.write("");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
				try {
					if (bw != null) {
						bw.close();
					}
					if(fw!=null) {
						fw.close();
					}
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			
		}

	}
	@Override
	public String toString() {
		DungeonFrame df = new DungeonFrame();
		return "Class: "+df.myHero.getType()+", Score: -"+DungeonFrame.monstersKilled+"-, Date: "+scoreDate+"\n";
		
	}



}
