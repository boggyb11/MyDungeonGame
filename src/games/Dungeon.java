package games;
//
//import java.util.Scanner;



public class Dungeon{
//	static int monstersKilled=0;
//	Hero myHero = new Hero();
//	Options options = new Options();
//	Scanner reader = new Scanner(System.in);
//	DungeonFrame hsb = new DungeonFrame();
//	Enemy enemy = new Enemy(50, 5);
//	boolean inDungeon = true;
	
	
	/////////////Constructor//////////////
	public Dungeon() {

	//	DUNGEON:
			//while(inDungeon) {
//				if(myHero.getHP()>0 && enemy.getHP()>0) {
					//show battle options view
		
		
		
		
//						hsb.setDungeonFrame();
//						hsb.attack.setOnAction((event)->{
//						doAttack();
//						String outcomes =("\nYou received "+ enemy.getDMG()+" Damage from the "+"Enemy"+"!!"+"\nYou Dealt "+ myHero.getDMG()+" Damage to the "+"Enemy"+":"+enemy.getHP()+" HP remaining!!");
//						hsb.textArea.appendText(outcomes);
//						hsb.hPLabel.setText("HP: "+myHero.getHP());
//						outcome();
//					});
					//on click of other buttons:
				}
	
	
//	public void outcome() {
//		
//		if(myHero.getHP()>0 && enemy.getHP()>0) {
//			//continue
//		}
//		//if monster's dead
//		 if(enemy.getHP()<=0) {
//			 String killedMonster = ("______ has been killed");
//			 hsb.setTextArea(killedMonster);
//			ContinueFrame cf = new ContinueFrame();
//			 monstersKilled++;
//			 cf.setContinueScreen();
//		 }
//			if((enemy.getHP()<=0) && (myHero.getHP()<=0))
//			{
//				inDungeon = false;
//				System.out.println(options.getBothDead());
//				ScoreScreen ss = new ScoreScreen();
//				ss.setScoreScreen();
//			}
//			else if(myHero.getHP()<=0)
//			{
//				inDungeon = false;
//				System.out.println("\tYou Have Died! .... Exiting Dungeon");
//				ScoreScreen ss = new ScoreScreen();
//				ss.setScoreScreen();
//			}
//
//	}
//	public Enemy getEnemy() {return this.enemy;}
//	public void doAttack() {myHero.attack(myHero, enemy);}
	
}
//			while(myHero.getHP()>0 && enemy.getHP()>0) {
//				
//				//System.out.println(options.battleOptions());
//				int playerSelection = reader.nextInt();
//				//get the player selection
//					switch(playerSelection) {
//			
//					case 1:
//									//perform attack
//						myHero.attack(myHero, enemy);
//						System.out.println("You Attack!");
//									//show the player the outcomes
//						System.out.println("\t\t\t You received "+ enemy.getDMG()+" Damage from the "+"Enemy"+"!!");
//						System.out.println("\t\t\t You Dealt "+ myHero.getDMG()+" Damage to the "+"Enemy"+":"+enemy.getHP()+" HP remaining!!");
//						break;
//				
//				case 2:// spell attack
//					if(heroMP>=myHero.getSpellMP()) {
//						System.out.println(newTextOptions.castSpell());
//						Attack spellAttack = new Attack();
//						newMonster.setMonsterHP(spellAttack.calcMonsterHP(myHero.getSpellDMG(), monsterHP));
//						spellAttack.calcMP(heroMP, myHero.getSpellMP());
//						heroHP = myHero.getheroHP();
//						heroMP = myHero.getheroMP();
//						monsterHP= newMonster.getMonsterHP();
//					//show the player the outcomes
//						if(monsterHP>0) {System.out.println("\t\t\tYou Dealt "+ myHero.getSpellDMG()+" Damage to the "+"Enemy"+":"+monsterHP+" HP remaining!!");}
//						else {System.out.println("\t\t\tYou Dealt "+ myHero.getSpellDMG()+" Damage to the "+"Enemy");}
//						newTextOptions.printHeroHP();newTextOptions.printHeroMP();
//					}
//					else System.out.println("\t\t\tNot enough MP !!");
//				break;
//				
//				//When the player chooses to run
//				case 3:
//					System.out.println(options.getAreYouSure());
//					int selection3 = reader.nextInt();
//					if (selection3 ==1)
//					{
//								System.out.println("\t\t\tYou Run past this enemy only to find another one!");
//								continue DUNGEON;
//								}
//					else if(selection3 ==2) // exit out of dungeon
//						{
//						System.out.println("goodbye");
//						return;
//					}
//					else System.out.println("INVALID COMMAND");
//				break;	
//
//			
//			
//			
//					}
//			}//end of while both alive loop
//			//exit if both dead
//			if((enemy.getHP()<=0) && (myHero.getHP()<=0))
//			{
//				inDungeon = false;
//				System.out.println(options.getBothDead());
//				return;
//			}
//			//if monster's dead
//			else if(enemy.getHP()<=0) {
//				System.out.println("-----------------------------------------------------------------------------------------------");
//				System.out.println("\t\t\tMonster" + " has been killed!!!");
//				System.out.println("-----------------------------------------------------------------------------------------------");
//			
//
//				System.out.println(options.getSuccesfulKill());
//				int selection2 = reader.nextInt();
//				switch(selection2)
//				{
//				case 1:
//					continue DUNGEON;
//				case 2:
//					System.out.println("Goodbye");
//					return;
//				}
//			}
//			//if hero is dead
//			else if(myHero.getHP()<=0)
//			{
//				inDungeon = false;
//				System.out.println("\tYou Have Died! .... Exiting Dungeon");
//				return;
//			}
//			}
//		reader.close();
//
//
//
//		
//		
//	
//	
//
//}
//
//
//}
