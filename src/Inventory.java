import java.util.ArrayList;

public class Inventory {
	static int weaponCapacity = 2;
	static int potionCapacity = 5;
	static int artefactCapacity = 3;
	static ArrayList<Weapon> weaponPart = new ArrayList<Weapon>();
	static ArrayList<Artefact> artefactPart = new ArrayList<Artefact>();
	static ArrayList<Potion> potionPart = new ArrayList<Potion>();
	
	public static void initInventory() {
		weaponPart.add(Game_Objects.WeaponDataBase.get(0));
		potionPart.add(Game_Objects.PotionDataBase.get(0));
		potionPart.add(Game_Objects.PotionDataBase.get(0));
	}
	
	public static void CheckInventory() {
		System.out.println("INVENTAIRE :");
		System.out.println("Armes :");
		for (int index_inv_weapon=0; index_inv_weapon < weaponPart.size();index_inv_weapon+=1) {
			System.out.println(weaponPart.get(index_inv_weapon).name + " : " + weaponPart.get(index_inv_weapon).desc);
		}
		System.out.println("Artefacts :");
		for (int index_inv_artefact=0; index_inv_artefact < artefactPart.size();index_inv_artefact+=1) {
			System.out.println(artefactPart.get(index_inv_artefact).name + " : " + artefactPart.get(index_inv_artefact).desc);
		}
		System.out.println("Potions :");
		for (int index_inv_potion=0; index_inv_potion < potionPart.size();index_inv_potion+=1) {
			System.out.println(potionPart.get(index_inv_potion).name + " : " + potionPart.get(index_inv_potion).desc);
		}
	}
	
	public static void Equip(String[] command) {
		if (command.length == 1) {
			System.out.println("Que voulez-vous equipe ?");
			Inventory.CheckInventory();
		}
		if (command.length == 2) {
			for (int indexArme=0; indexArme < weaponPart.size();indexArme+=1) {
				if (command[1].equalsIgnoreCase(weaponPart.get(indexArme).name)) {
					if (Game_Objects.pc.weaponEquiped != null) {
						weaponPart.add(Game_Objects.pc.weaponEquiped);
					}
					Game_Objects.pc.weaponEquiped = weaponPart.get(indexArme);
					weaponPart.remove(indexArme);
					System.out.println("Vous avez equipe" + Game_Objects.pc.weaponEquiped.name);
				}
			}
			for (int indexArtefact=0; indexArtefact < artefactPart.size();indexArtefact+=1) {
				if (command[1].equalsIgnoreCase(artefactPart.get(indexArtefact).name)) {
					if (Game_Objects.pc.artefactEquiped != null) {
						artefactPart.add(Game_Objects.pc.artefactEquiped);
					}
					Game_Objects.pc.artefactEquiped = artefactPart.get(indexArtefact);
					weaponPart.remove(indexArtefact);
					System.out.println("Vous avez equipe " + Game_Objects.pc.artefactEquiped.name);
				}
			}
		}
	}
	
	public static void Unequiped(String[] command) {
		if (command.length == 1) {
			System.out.println("Que voulez-vous desequipe ?");
			if (Game_Objects.pc.weaponEquiped != null)
				System.out.println(Game_Objects.pc.weaponEquiped.name);
			if (Game_Objects.pc.artefactEquiped != null)
				System.out.println(Game_Objects.pc.artefactEquiped.name);
		}
		if (command.length == 2) {
			if (command[1].equalsIgnoreCase(Game_Objects.pc.weaponEquiped.name)) {
				if (weaponPart.size() == weaponCapacity) {
					System.out.println("Votre inventaire est plein");
					System.out.println("Enlevez quelque chose dans votre inventaire avant");
				}
				if (weaponPart.size() < weaponCapacity) {
					weaponPart.add(Game_Objects.pc.weaponEquiped);
					System.out.println(Game_Objects.pc.weaponEquiped.name + " est desequipe");
					Game_Objects.pc.weaponEquiped = null;
				}
			}
			if (command[1].equalsIgnoreCase(Game_Objects.pc.artefactEquiped.name)) {
				if (artefactPart.size() == artefactCapacity) {
					System.out.println("Votre inventaire est plein");
					System.out.println("Enlevez quelque chose dans votre inventaire avant");
				}
				if (artefactPart.size() < artefactCapacity) {
					artefactPart.add(Game_Objects.pc.artefactEquiped);
					System.out.println(Game_Objects.pc.artefactEquiped.name + " est desequipe");
					Game_Objects.pc.artefactEquiped = null;
				}
			}
			else {
				System.out.println("Rien n'est equipe");
			}
		}
	}
	public static void Drop(String[] command){
		if (command.length == 1) {
			System.out.println("Que voulez-vous retirer ?");
			Inventory.CheckInventory();
		}
		if (command.length == 2) {
			if (command[1].equalsIgnoreCase(Game_Objects.pc.weaponEquiped.name)) {
				System.out.println(Game_Objects.pc.weaponEquiped.name + " est enleve de l'inventaire");
				Game_Objects.pc.weaponEquiped = null;
			}
			for (int indexArme=0; indexArme < weaponPart.size();indexArme+=1) {
				if (command[1].equalsIgnoreCase(weaponPart.get(indexArme).name)) {
					System.out.println(weaponPart.get(indexArme).name + " est enleve de l'inventaire");
					weaponPart.remove(indexArme);
				}
			}
			if (command[1].equalsIgnoreCase(Game_Objects.pc.artefactEquiped.name)) {
				System.out.println(Game_Objects.pc.artefactEquiped.name + " est enleve de l'inventaire");
				Game_Objects.pc.artefactEquiped = null;
			}
			for (int indexArtefact=0; indexArtefact < artefactPart.size();indexArtefact+=1) {
				if (command[1].equalsIgnoreCase(artefactPart.get(indexArtefact).name)) {
					System.out.println(artefactPart.get(indexArtefact).name + " est enleve de l'inventaire");
					artefactPart.remove(indexArtefact);
				}
			}
		}
	}
	
	public static void usePotion(String[] command) {
		if (command.length == 1) {
			System.out.println("Quelles potions voulez-vous utiliser ?");
			System.out.println("Potions :");
			for (int index_inv_potion=0; index_inv_potion < potionPart.size();index_inv_potion+=1) {
				System.out.println(potionPart.get(index_inv_potion).name + " : " + potionPart.get(index_inv_potion).desc);
			}
		}
		if (command.length == 2) {
			for (int index_inv_potion=0; index_inv_potion < potionPart.size();index_inv_potion+=1) {
				if ( command[1].equalsIgnoreCase(potionPart.get(index_inv_potion).name)) {
					System.out.println("Vous avez utilise " + potionPart.get(index_inv_potion).name);
					Game_Objects.pc.hp += potionPart.get(index_inv_potion).Healing;
					potionPart.remove(index_inv_potion);
				}
			}
		}
	}
	
	public static void getInChest(String item, Chest localchest) {
		for (int index_potion=0; index_potion < localchest.potionPart.size();index_potion+=1) {
			if (item.equalsIgnoreCase(localchest.potionPart.get(index_potion).name)) {
				if (potionCapacity == potionPart.size()) {
					System.out.println("Vous n'avez plus de place, vous devez enlever quelque chose de votre"
							+ " inventaire");
				}
				if (potionCapacity > potionPart.size()) {
					System.out.println("Vous recuperez " +localchest.potionPart.get(index_potion).name);
					potionPart.add(localchest.potionPart.get(index_potion));
					localchest.potionPart.remove(index_potion);
				}
			}
		}
		for (int index_arme=0; index_arme < localchest.weaponPart.size();index_arme+=1) {
			if (item.equalsIgnoreCase(localchest.weaponPart.get(index_arme).name)) {
				if (weaponCapacity == weaponPart.size()) {
					System.out.println("Vous n'avez plus de place, vous devez enlever quelque chose de votre"
							+ " inventaire");
				}
				if (weaponCapacity > weaponPart.size()) {
					System.out.println("Vous recuperez " +localchest.weaponPart.get(index_arme).name);
					weaponPart.add(localchest.weaponPart.get(index_arme));
					localchest.weaponPart.remove(index_arme);
				}
			}
		}
		for (int index_artefact=0; index_artefact < localchest.artefactPart.size();index_artefact+=1) {
			if (item.equalsIgnoreCase(localchest.artefactPart.get(index_artefact).name)) {
				if (artefactCapacity == artefactPart.size()) {
					System.out.println("Vous n'avez plus de place, vous devez enlever quelque chose de votre"
							+ " inventaire");
				}
				if (artefactCapacity > artefactPart.size()) {
					System.out.println("Vous recuperez " +localchest.artefactPart.get(index_artefact).name);
					artefactPart.add(localchest.artefactPart.get(index_artefact));
					localchest.artefactPart.remove(index_artefact);
				}
			}
		}
	}
}
