package games;

public class Options {

	
	
	
	public String battleOptions(){
		String BattleOptions ="What would you like to do?\n";
		return BattleOptions;
	}
	 public String getAreYouSure() {
		String AreYouSure ="\t\t\tWould you like to continue in the Dungeon or Exit?\n"+
							"1.Continue\n"+
							"2.Exit\n";
		return AreYouSure;
	}
	 public String getBothDead(){
			
			String BothDead ="\t\t\tDouble K.O !!!!!!\n" + 
							 "\t\t\tExiting Dungeon\n"; 
			return BothDead;
		}

	 public String getSuccesfulKill()
		{
			String SuccessfulKill="-----------------------------------------------------------------------------------\n" + 
					"\t\t\tWhat would you like to do ?\n" + 
					"1.Continue in the Dungeon\n" + 
					"2.Exit Dungeon\n"+
					"-----------------------------------------------------------------------------------\n"
					;
			return SuccessfulKill;
			
		}

}
