package games;

import java.util.ArrayList;

public abstract class Spell {

	static ArrayList<Spell> spellList = new ArrayList<>();
	String spellName="Spell";
	int spellDmg=0;
	int manaCost=0;


	
	public Spell() {
		
	} 

	
	
	
	
	////////////methods
//	public Spell getSpell(Spell spell) {
//		
//		for(Spell spells: spellList) {
//			if(spell.getSpellName()== spells.getSpellName()) {
//				return spells;
//			}
//		}
//		return null;//potential ERROR here
//	}
	public void setSpellName(String spellName) {
		this.spellName = spellName;
	}
	public String getSpellName() {
		return spellName;
	}
	public int getSpellDmg() {
		return spellDmg;
	}
	public void setSpellDmg(int spellDmg) {
		this.spellDmg = spellDmg;
	}
	public int getManaCost() {
		return manaCost;
	}
	public void setManaCost(int manaCost) {
		this.manaCost = manaCost;
	}
	
	
}
