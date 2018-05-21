package games;

import screens.DungeonFrame;

public enum LootTable {
//		  NAME,ARMOUR,DMG,HP,MP
	NULL("NULL",0,0.0d,0,0),
	HPPOT("HPPOT",0,0.0d,25,0),
	MEDIUM_HPPOT("HPPOT",0,0.0d,50,0),
	LARGE_HPPOT("HPPOT",0,0.0d,75,0),
	MPPOT("MPPOT",0,0.0d,0,25),
	MEDIUM_MPPOT("MPPOT",0,0.0d,0,50),
	LARGE_MPPOT("MPPOT",0,0.0d,0,75),
	SMALL_ARMOUR_UP("Small Armour Up",10,0.0d,0,0),
	MEDIUM_ARMOUR_UP("Medium Armour Up",20,0.0d,0,0),
	LARGE_ARMOUR_UP("Large Armour Up",30,0.0d,0,0),
	SMALL_ATTACK_UP("Small Attack Up",0,10.0d,0,0),
	MEDIUM_ATTACK_UP("Medium Attack Up",0,20.0d,0,0),
	LARGE_ATTACK_UP("Large Attack Up",0,30.0d,0,0);
	
	private String name;
	private int Armour;
	private double Damage;
	private int HP;
	private int MP;
	DungeonFrame myDungeon = new DungeonFrame();
	
	private LootTable(String name, int Armour, double Damage,int HP, int MP)
	{
		this.name = name;
		this. Armour = Armour;
		this.Damage = Damage;
		this.HP =HP;
		this.MP=MP;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getArmour() {
		return Armour;
	}

	public void setArmour(int armour) {
		Armour = armour;
	}

	public double getDamage() {
		return Damage;
	}

	public void setDamage(double damage) {
		Damage = damage;
	}
	public int getHP() {
		return HP;
	}

	public void setHP(int hP) {
		HP = hP;
	}

	public int getMP() {
		return MP;
	}

	public void setMP(int mP) {
		MP = mP;
	}
	public void use(LootTable item) {
		if(item.HP>0) {
			Hero.currentHP+=item.HP;
			Hero.actualHP+=item.HP;
			myDungeon.getTextArea().appendText("HP healed by "+ item.HP+"\n");
		}
		if(item.MP>0) {
			Hero.MP+=item.MP;
			myDungeon.getTextArea().appendText("MP recovered by "+ item.MP+"\n");
		}
		if(item.Damage>0) {
			Hero.DMG+=item.Damage;
			myDungeon.getTextArea().appendText("Damage increased by "+ item.Damage+"\n");
		}
		//armour
		if(item.Armour>0) {
			Hero.armour+=item.Armour;
			myDungeon.getTextArea().appendText("Armour increased by "+ item.Armour+"\n");
		}
		
	}

	public static LootTable[] getItemPack_01() {
		return itemPack_01;
	}

	public static void setItemPack_01(LootTable[] itemPack_01) {
		LootTable.itemPack_01 = itemPack_01;
	}

	public static LootTable[] itemPack_01 = {LootTable.HPPOT,LootTable.HPPOT,LootTable.MPPOT,LootTable.MPPOT,LootTable.SMALL_ARMOUR_UP,LootTable.SMALL_ATTACK_UP,LootTable.NULL};
	public static LootTable[] itemPack_02 = {LootTable.MEDIUM_HPPOT,LootTable.MEDIUM_HPPOT,LootTable.MEDIUM_MPPOT,LootTable.MEDIUM_MPPOT,LootTable.MEDIUM_ARMOUR_UP,LootTable.MEDIUM_ATTACK_UP,LootTable.NULL};
	public static LootTable[] itemPack_03 = {LootTable.LARGE_HPPOT,LootTable.LARGE_HPPOT,LootTable.LARGE_MPPOT,LootTable.LARGE_MPPOT,LootTable.LARGE_ARMOUR_UP,LootTable.LARGE_ATTACK_UP,LootTable.NULL};
		      
	
	
	
}
