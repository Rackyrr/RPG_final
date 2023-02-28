import java.util.ArrayList;

public class Game_Objects {
	static PC pc = new PC();
	static ArrayList<Room> room = new ArrayList<Room>();
	static ArrayList<NPC> NPCDataBase = new ArrayList<NPC>();
	static ArrayList<Weapon> WeaponDataBase = new ArrayList<Weapon>();
	static ArrayList<Artefact> ArtefactDataBase = new ArrayList<Artefact>();
	static ArrayList<Potion> PotionDataBase = new ArrayList<Potion>();
	static ArrayList<Chest> ChestDataBase = new ArrayList<Chest>();
	static char[][] map = Map.initMap();
	
	public static void initalizeNPCArray() {
		NPCDataBase.add(new Slime(16,15));
		NPCDataBase.add(new Slime(13,15));
		NPCDataBase.add(new Slime(12,10));
		NPCDataBase.add(new Goblin(10,18));
		NPCDataBase.add(new Goblin(31,18));
		NPCDataBase.add(new Skeleton(5,8));
		NPCDataBase.add(new Skeleton(28,8));
		NPCDataBase.add(new Troll(16,3));
	}
	public static void initalizeWeaponArray() {
		WeaponDataBase.add(new Weapon("Petit_Glaive","Un petit glaive qui inflige 3 point de dommage suplementaire",
				true, "Main", 3, 0));
		WeaponDataBase.add(new Weapon("Hache","Une Hache qui inflige 6 point de dommage suplementaire, mais moins 2 points de vitesse",
				true, "Main", 6, 2));
		WeaponDataBase.add(new Weapon("Espadon","Un espadon qui inflige 9 point de dommage suplementaire, mais moins 5 points de vitesse",
				true, "Main", 9, 5));
	}
	public static void initalizeArtefactArray() {
		ArtefactDataBase.add(new Artefact("Armure_en_cuir","Une armure donne 2 points de defense",
				true, "Body",2));
		ArtefactDataBase.add(new Artefact("Armure_en_cotte_de_maille","Une armure donne 4 points de defense",
				true, "Body",4));
		ArtefactDataBase.add(new Artefact("Armure_en_acier","Une armure donne 5 points de defense",
				true, "Body",5));
	}
	public static void initalizePotionArray() {
		PotionDataBase.add(new Potion("Petite_Potion_de_soin","Une potion qui soigne de 10hp",
				false, null, 10));
		PotionDataBase.add(new Potion("Grande_Potion_de_soin","Une potion qui soigne de 20hp",
				false, null, 20));
		PotionDataBase.add(new Potion("Potion_de_soin","Une potion qui soigne de 15hp",
				false, null, 15));
	}
	public static void initalizeChestArray() {

	}

}
