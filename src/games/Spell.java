package games;

import java.util.ArrayList;

public abstract class Spell {

	static ArrayList<Spell> spellList = new ArrayList<>();
	String spellName="Spell";
	int spellDmg=0;
	int manaCost=0;
	String effect;// = effect();
	

	public Spell() {
		
	} 
	public abstract void castSpell(Enemy enemy);
	public abstract String effect();
	public void setSpell(Spell spell) {
		Hero.heroSpell=spell;
	}
	
	
	
	public String getEffect() {
		return effect;
	}
	public void setEffect(String effect) {
		this.effect = effect;
	}
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
