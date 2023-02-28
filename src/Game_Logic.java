import java.util.Scanner;

public class Game_Logic {
	public Game_Logic() {
		Game_Objects.room.add(new Room(1));
		Game_Objects.room.get(0).name = "Floating in space";
		Game_Objects.room.get(0).desc.add("Desc Line 1");
		Game_Objects.room.get(0).exits.add("South 2");
		Game_Objects.room.get(0).exits.add("North 3");

	}

	public void waitforCommand() {
		System.out.println("Que voulez vous faire ?");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String com = sc.nextLine();
		String[] words = com.split(" ");
		processCommand(words);

	}

	public void processCommand(String[] command) {
		if (command[0].equalsIgnoreCase("show")) {
			showMap();
		}
		if (command[0].equalsIgnoreCase("move")) {
			move(command);
		}
		if (command[0].equalsIgnoreCase("fight")) {
			fight(); 
		}
		if (command[0].equalsIgnoreCase("inventory")) {
			Inventory.CheckInventory();
		}
		if (command[0].equalsIgnoreCase("equip")) {
			Inventory.Equip(command);
		}
		if (command[0].equalsIgnoreCase("remove")) {
			Inventory.Unequiped(command);
		}
		if (command[0].equalsIgnoreCase("open")) {
			boolean IsAchest = false;
			int coord_ch_Y = 0;
			int coord_ch_X = 0;
			Chest localChest = null;
			if (Game_Objects.map[Game_Objects.pc.coord_Y+1][Game_Objects.pc.coord_X] == 'C') {
				IsAchest = true;
				coord_ch_Y = Game_Objects.pc.coord_Y+1;
				coord_ch_X = Game_Objects.pc.coord_X;
			}
			if (Game_Objects.map[Game_Objects.pc.coord_Y-1][Game_Objects.pc.coord_X] == 'C') {
				IsAchest = true;
				coord_ch_Y = Game_Objects.pc.coord_Y-1;
				coord_ch_X = Game_Objects.pc.coord_X;
			}
			if (Game_Objects.map[Game_Objects.pc.coord_Y][Game_Objects.pc.coord_X+1] == 'C') {
				IsAchest = true;
				coord_ch_Y = Game_Objects.pc.coord_Y;
				coord_ch_X = Game_Objects.pc.coord_X+1;
			}
			if (Game_Objects.map[Game_Objects.pc.coord_Y][Game_Objects.pc.coord_X-1] == 'C') {
				IsAchest = true;
				coord_ch_Y = Game_Objects.pc.coord_Y;
				coord_ch_X = Game_Objects.pc.coord_X-1;
			}
			if (IsAchest == false) {
				System.out.println("Il n'y a pas de coffre aux alentours");
			}
			if (IsAchest == true) {
				for (int index_coffre=0; index_coffre < Game_Objects.ChestDataBase.size(); index_coffre +=1) {
					if (Game_Objects.ChestDataBase.get(index_coffre).coord_X == coord_ch_X 
							&& Game_Objects.ChestDataBase.get(index_coffre).coord_Y == coord_ch_Y ) {
						localChest = Game_Objects.ChestDataBase.get(index_coffre);
					}
				}
				localChest.OpenChest();
			}
		}
		
		
	}
	/*public void look(String[] command) {
		if (command.length == 1) {
			for (int i=0; i < Game_Objects.room.size(); i+=1) {
				if (Game_Objects.room.get(i).number == Game_Objects.pc.InRoom) {
					System.out.println(Game_Objects.room.get(i).name);
					for (int y=0; y < Game_Objects.room.get(i).desc.size();y+=1) {
						System.out.println(Game_Objects.room.get(i).desc.get(y));
					}
					System.out.println("Exits :");
					for (int y=0; y < Game_Objects.room.get(i).exits.size();y+=1) {
						String exitNameFull = Game_Objects.room.get(i).exits.get(y);
						String[] exitName = exitNameFull.split(" ");
						System.out.println(exitName[0]);
					}
					for (int y=0; y < Game_Objects.room.get(i).npc.size();y+=1) {
						System.out.println(Game_Objects.room.get(i).npc.get(y).desc);
					}
					for (int y=0; y < Game_Objects.room.get(i).item.size();y+=1) {
						System.out.println(Game_Objects.room.get(i).item.get(y).desc);
					}
				}
			}
		}
		if (command.length == 2) {
			if (command[1].equals("self")) {
				Game_Objects.pc.look();
				System.out.println("Vous portez :");
				for (int i=0; i < Game_Objects.pc.item.size();i+=1) {
					System.out.println(Game_Objects.pc.item.get(i).name);
				}
			}
		}
	}*/
	
	public static void showMap() {
		for (int i=0; i < Game_Objects.map.length; i+=1) {
			for (int j=0; j < Game_Objects.map[i].length; j+=1) {
				System.out.print(Game_Objects.map[i][j]);
			}
			System.out.print('\n');
		}
	}
	public void move(String[] command) {
		if (command.length == 1) {
			System.out.println("Aller ou ?");
		}
		if (command.length == 2) {
			if (command[1].equalsIgnoreCase("forward")) {
				if (Game_Objects.map[Game_Objects.pc.coord_Y-1][Game_Objects.pc.coord_X] == 'X') {
					System.out.println("Un mur vous bloque la route");
				}
				if (Game_Objects.map[Game_Objects.pc.coord_Y-1][Game_Objects.pc.coord_X] == 'C') {
					System.out.println("Vous ne pouvez pas marcher sur le coffre");
				}
				if (Game_Objects.map[Game_Objects.pc.coord_Y-1][Game_Objects.pc.coord_X] == ' ') {
					Game_Objects.map[Game_Objects.pc.coord_Y-1][Game_Objects.pc.coord_X]='P';
					Game_Objects.map[Game_Objects.pc.coord_Y][Game_Objects.pc.coord_X]=' ';
					Game_Objects.pc.coord_Y -=1;
					showMap();
				}
				else {
						System.out.println("Un ennemi se tient ici");
				}
			}		
			if (command[1].equalsIgnoreCase("left")) {
				if (Game_Objects.map[Game_Objects.pc.coord_Y][Game_Objects.pc.coord_X-1] == 'X') {
					System.out.println("Un mur vous bloque la route");
				}
				if (Game_Objects.map[Game_Objects.pc.coord_Y][Game_Objects.pc.coord_X-1] == 'C') {
					System.out.println("Vous ne pouvez pas marcher sur le coffre");
				}
				if (Game_Objects.map[Game_Objects.pc.coord_Y][Game_Objects.pc.coord_X-1] == ' ') {
					Game_Objects.map[Game_Objects.pc.coord_Y][Game_Objects.pc.coord_X-1]='P';
					Game_Objects.map[Game_Objects.pc.coord_Y][Game_Objects.pc.coord_X]=' ';
					Game_Objects.pc.coord_X -=1;
					showMap();
				}
				else {
					System.out.println("Un ennemi se tient ici");
				}
			}		
			if (command[1].equalsIgnoreCase("right")) {
				if (Game_Objects.map[Game_Objects.pc.coord_Y][Game_Objects.pc.coord_X+1] == 'X') {
					System.out.println("Un mur vous bloque la route");
				}
				if (Game_Objects.map[Game_Objects.pc.coord_Y][Game_Objects.pc.coord_X+1] == 'C') {
					System.out.println("Vous ne pouvez pas marcher sur le coffre");
				}
				if (Game_Objects.map[Game_Objects.pc.coord_Y][Game_Objects.pc.coord_X+1] == ' ') {
					Game_Objects.map[Game_Objects.pc.coord_Y][Game_Objects.pc.coord_X+1]='P';
					Game_Objects.map[Game_Objects.pc.coord_Y][Game_Objects.pc.coord_X]=' ';
					Game_Objects.pc.coord_X +=1;
					showMap();
				}
				else {
					System.out.println("Un ennemi se tient ici");
				}
			}		
			if (command[1].equalsIgnoreCase("backward")) {
				if (Game_Objects.map[Game_Objects.pc.coord_Y+1][Game_Objects.pc.coord_X] == 'X') {
					System.out.println("Un mur vous bloque la route");
				}
				if (Game_Objects.map[Game_Objects.pc.coord_Y+1][Game_Objects.pc.coord_X] == 'C') {
					System.out.println("Vous ne pouvez pas marcher sur le coffre");
				}
				if (Game_Objects.map[Game_Objects.pc.coord_Y+1][Game_Objects.pc.coord_X] == ' ') {
					Game_Objects.map[Game_Objects.pc.coord_Y+1][Game_Objects.pc.coord_X]='P';
					Game_Objects.map[Game_Objects.pc.coord_Y][Game_Objects.pc.coord_X]=' ';
					Game_Objects.pc.coord_Y +=1;
					showMap();
				}
				else {
					System.out.println("Un ennemi se tient ici");
				}
			}		
		}
	}
	
	public void fight() {
		boolean ennemi_autour = false;
		int coord_en_Y = 0;
		int coord_en_X = 0;
		boolean EnnemiDead = false;
		boolean PCDead = false;
		if (Game_Objects.map[Game_Objects.pc.coord_Y+1][Game_Objects.pc.coord_X] != 'X' 
				&& Game_Objects.map[Game_Objects.pc.coord_Y+1][Game_Objects.pc.coord_X] != ' ' 
				&& Game_Objects.map[Game_Objects.pc.coord_Y+1][Game_Objects.pc.coord_X] != 'C') {
			ennemi_autour = true;
			coord_en_Y = Game_Objects.pc.coord_Y+1;
			coord_en_X = Game_Objects.pc.coord_X;
		}
		if (Game_Objects.map[Game_Objects.pc.coord_Y-1][Game_Objects.pc.coord_X] != 'X' 
				&& Game_Objects.map[Game_Objects.pc.coord_Y-1][Game_Objects.pc.coord_X] != ' ' 
				&& Game_Objects.map[Game_Objects.pc.coord_Y-1][Game_Objects.pc.coord_X] != 'C') {
			ennemi_autour = true;
			coord_en_Y = Game_Objects.pc.coord_Y-1;
			coord_en_X = Game_Objects.pc.coord_X;
		}
		if (Game_Objects.map[Game_Objects.pc.coord_Y][Game_Objects.pc.coord_X+1] != 'X' 
				&& Game_Objects.map[Game_Objects.pc.coord_Y][Game_Objects.pc.coord_X+1] != ' ' 
				&& Game_Objects.map[Game_Objects.pc.coord_Y][Game_Objects.pc.coord_X+1] != 'C') {
			ennemi_autour = true;
			coord_en_Y = Game_Objects.pc.coord_Y;
			coord_en_X = Game_Objects.pc.coord_X+1;
		}
		if (Game_Objects.map[Game_Objects.pc.coord_Y][Game_Objects.pc.coord_X-1] != 'X' 
				&& Game_Objects.map[Game_Objects.pc.coord_Y][Game_Objects.pc.coord_X-1] != ' ' 
				&& Game_Objects.map[Game_Objects.pc.coord_Y][Game_Objects.pc.coord_X-1] != 'C') {
			ennemi_autour = true;
			coord_en_Y = Game_Objects.pc.coord_Y;
			coord_en_X = Game_Objects.pc.coord_X-1;
		}
		if (ennemi_autour == false) {
			System.out.println("Il n'y a personne a attaquer autour de vous");
		}
		if (ennemi_autour == true) {
			NPC Ennemi = null;
			for (int index_liste_npc=0; index_liste_npc < Game_Objects.NPCDataBase.size();index_liste_npc+=1 ) {
				if (Game_Objects.NPCDataBase.get(index_liste_npc).coord_Y == coord_en_Y 
						&& Game_Objects.NPCDataBase.get(index_liste_npc).coord_X == coord_en_X ) {
					Ennemi = Game_Objects.NPCDataBase.get(index_liste_npc);
				}
			}			
			System.out.println("Vous entrez en combat avec un "
					+ Ennemi.name);
			if ((Game_Objects.pc.speed-Game_Objects.pc.weaponEquiped.MalusOnSpeed) > Ennemi.speed) {
				System.out.println("Vous êtes plus rapide que l'adversaire, "
						+ "vous attaquez en premier");
				@SuppressWarnings("resource")
				Scanner scan = new Scanner(System.in);
				while(true) {
					int Degat = 0;
					System.out.println("C'est votre tour");
					System.out.println("Que voulez vous faire ?");
					System.out.println("Vous pouvez :");
					System.out.println("Attack 		Flee");
					String Command_fight  = scan.nextLine();
					if (Command_fight.equalsIgnoreCase("attack")) {
						Degat = Game_Objects.pc.attack+ Game_Objects.pc.weaponEquiped.Dammage - Ennemi.defence;
						if (Degat < 0)
							Degat = 0;
						System.out.println("Vous attaquez le "
								+ Ennemi.name
								+" et vous lui inflige "
								+ Degat
								+" points de degats");
						Ennemi.hp -= Degat;
						if (Ennemi.hp <= 0) {
							EnnemiDead = true;
							break;
						}
					}
					if (Command_fight.equalsIgnoreCase("flee")) {
						System.out.println("Vous fuyez le combat");
						break;
					}
					System.out.println("C'est au tour du "
							+ Ennemi.name);
					Degat = Ennemi.attack - Game_Objects.pc.defence+Game_Objects.pc.artefactEquiped.BonusDefence;
					if (Degat < 0)
						Degat = 0;
					System.out.println("Il vous attaque et vous inflige"
							+ Degat);
					Game_Objects.pc.hp -= Degat;
					if (Game_Objects.pc.hp <= 0) {
						PCDead = true;
						break;
					}
				}
			}
			if ((Game_Objects.pc.speed-Game_Objects.pc.weaponEquiped.MalusOnSpeed) < Ennemi.speed) {
				System.out.println("Le " + Ennemi.name + "est plus rapide que vous,"
						+ "il a donc l'avantage");
				@SuppressWarnings("resource")
				Scanner scan = new Scanner(System.in);
				while(true) {
					int Degat = 0;
					System.out.println("C'est au tour du "
							+ Ennemi.name);
					Degat = Ennemi.attack - Game_Objects.pc.defence+Game_Objects.pc.artefactEquiped.BonusDefence;
					if (Degat < 0)
						Degat = 0;
					System.out.println("Il vous attaque et vous inflige"
							+ Degat);
					Game_Objects.pc.hp -= Degat;
					if (Game_Objects.pc.hp <= 0) {
						PCDead = true;
						break;
					}
					System.out.println("C'est votre tour");
					System.out.println("Que voulez vous faire ?");
					System.out.println("Vous pouvez :");
					System.out.println("Attack 		Flee");
					String Command_fight  = scan.nextLine();
					if (Command_fight.equalsIgnoreCase("attack")) {
						Degat = Game_Objects.pc.attack+ Game_Objects.pc.weaponEquiped.Dammage - Ennemi.defence;
						if (Degat < 0)
							Degat = 0;
						System.out.println("Vous attaquez le "
								+ Ennemi.name
								+" et vous lui inflige "
								+ Degat
								+" points de degats");
						Ennemi.hp -= Degat;
						if (Ennemi.hp <= 0) {
							EnnemiDead = true;
							break;
						}
					}
					if (Command_fight.equalsIgnoreCase("flee")) {
						System.out.println("Vous fuyez le combat");
						break;
					}
				}
			}
			if (PCDead) {
				System.out.println("Vous etes mort");
				Game_Objects.pc.IsDead = true;
			}
			if (EnnemiDead) {
				System.out.println("Vous avez vaincu le "+ Ennemi.name);
				Game_Objects.map[Ennemi.coord_Y][Ennemi.coord_X] =' ';
			}
		}
	}
		
	/*@SuppressWarnings("deprecation")
	public void summon(String[] command) {
		if (command.length == 1) {
			System.out.println("Invoquer quoi ?");
		}
		if (command.length == 2) {
			for (int i=0; i< Game_Objects.NPCDataBase.size(); i+=1) {
				NPC localNPC = (NPC) Game_Objects.NPCDataBase.get(i);
				if (localNPC.id.equalsIgnoreCase(command[1])) {
					for (int y=0; y< Game_Objects.room.size(); y+=1) {
						if (Game_Objects.room.get(y).number == Game_Objects.pc.InRoom) {
							try {
								Game_Objects.room.get(y).npc.add((NPC) Class.forName(localNPC.id).newInstance());
								System.out.println("Vous avez invoque "+ Game_Objects.room.get(y)
								.npc.get(Game_Objects.room.get(y).npc.size()-1).name);
							} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
								//TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public void create_item(String[] command) {
		if (command.length == 1) {
			System.out.println("Creer quoi ?");
		}
		if (command.length == 2) {
			for (int i=0; i< Game_Objects.ItemDataBase.size(); i+=1) {
				Item localItem = (Item) Game_Objects.ItemDataBase.get(i);
				if (localItem.id.equalsIgnoreCase(command[1])) {
					for (int y=0; y< Game_Objects.room.size(); y+=1) {
						if (Game_Objects.room.get(y).number == Game_Objects.pc.InRoom) {
							try {
								Game_Objects.room.get(y).item.add((Item) Class.forName(localItem.id).newInstance());
							} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
								//TODO Auto-generated catch block
								e.printStackTrace();
							}
							System.out.println("Vous avez creer un "
									+ Game_Objects.room.get(y).item.get(Game_Objects.room.get(y).item.size()-1).name);
						}
					}
				}
			}
		}
	}
	
	public void get(String[] command) {
		if (command.length == 1) {
			System.out.println("Prendre quoi ?");
		}
		if (command.length == 2) {
			for (int i=0; i< Game_Objects.ItemDataBase.size(); i+=1) {
				for (int y=0; y< Game_Objects.room.size(); y+=1) {
					if (Game_Objects.room.get(y).number == Game_Objects.pc.InRoom) {
						for (int z =0; z < Game_Objects.room.get(y).item.size(); z+=1) {
							if (command[1].equalsIgnoreCase(Game_Objects.room.get(y).item.get(z).id)) {
								Item localItem = Game_Objects.room.get(y).item.get(z);
								Game_Objects.pc.item.add(localItem);
								System.out.println("You pick up a " + localItem.name);
								Game_Objects.room.get(y).item.remove(z);
								break;
							}
						}
					}
				}
			}
		}
	}*/
	
	@SuppressWarnings("resource")
	public void createCharacter() {
		System.out.println("Bienvenue, Quel est votre nom ?");
		Scanner sc = new Scanner(System.in);
		Game_Objects.pc.name = sc.next();
		System.out.println("Vous allez commencer votre aventure avec 100hp, "
				+ "\n "
				+ "15 points d'attaque, 10 points de defense et 7 points de vitesse.");
		System.out.println("Vous etes aussi equippe d'un petit glaive et de 2 petites potions de soins");
		Inventory.initInventory();
		Game_Objects.pc.hp = 100;
		Game_Objects.pc.attack = 15;
		Game_Objects.pc.defence = 10;
		Game_Objects.pc.speed = 7;
		Game_Objects.pc.InRoom = 1;
		Game_Objects.pc.coord_X = 16;
		Game_Objects.pc.coord_Y = 18;
	}
	
}
