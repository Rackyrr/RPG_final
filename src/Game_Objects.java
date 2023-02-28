import java.util.ArrayList;

public class Game_Objects {
	static PC pc = new PC();
	static ArrayList<Room> room = new ArrayList<Room>();
	static ArrayList<NPC> NPCDataBase = new ArrayList<NPC>();
	static ArrayList<Item> ItemDataBase = new ArrayList<Item>();
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
	public static void initalizeItemArray() {
		ItemDataBase.add(new Flaming_Sword());
	}

}
