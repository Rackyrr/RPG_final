
public class Skeleton extends NPC {
	int coord_X;
	int coord_Y;
	
	public Skeleton (int coord_y, int coord_x) {
		coord_X = coord_x;
		coord_Y = coord_y;
		id = "Skeleton";
		hp = 10;
		attack = 10;
		defence = 10;
		speed = 10;
		desc = "Un Squelette barre la porte";
		name= "Un Squelette";
	}
}
