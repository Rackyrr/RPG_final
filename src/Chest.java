import java.util.ArrayList;
import java.util.Scanner;

public class Chest {
	int coord_X;
	int coord_Y;
	ArrayList<Weapon> weaponPart = new ArrayList<Weapon>();
	ArrayList<Artefact> artefactPart = new ArrayList<Artefact>();
	ArrayList<Potion> potionPart = new ArrayList<Potion>();
	
	public Chest(ArrayList<Weapon> weaponPart, ArrayList<Artefact> artefactPart, ArrayList<Potion> potionPart,
			int coord_x, int coord_y) {
		super();
		this.weaponPart = weaponPart;
		this.artefactPart = artefactPart;
		this.potionPart = potionPart;
		this.coord_X = coord_x;
		this.coord_Y = coord_y;
	}
	
	public void OpenChest() {
		System.out.println("Le coffre contient : ");
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
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		while (true) {
			if (this.weaponPart.size() == 0 && this.artefactPart.size() == 0 && this.potionPart.size() == 0) {
				System.out.println("Le coffre est vide");
				break;
			}
			System.out.println("Pour recuperer un objet, utilisez get puis le nom de l'objet");
			System.out.println("Pour sortir du coffre, utilisez exit");
			String command = scan.nextLine();
			String[] words = command.split(" ");
			if (words[0].equalsIgnoreCase("exit")) {
				break;
			}
			if (words[0].equalsIgnoreCase("get")) {
				Inventory.getInChest(words[1], this);
			}
		}
	}
}
