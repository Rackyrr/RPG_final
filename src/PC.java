import java.util.ArrayList;

public class PC {
	String name;
	int hp;
	int xp;
	int coord_X;
	int coord_Y;
	int attack;
	int defence;
	int speed;
	int InRoom = 0;
	boolean IsDead = false;
	ArrayList<Item> item = new ArrayList<Item>();

	
	public void look() {
		System.out.println("Hp : " + hp);
		System.out.println("Xp : " + xp);
		System.out.println("Attaque : " + attack);
		System.out.println("Defense : " + defence);
		System.out.println("Vitesse : " + speed);
	}

}
