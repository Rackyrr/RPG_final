
public class Skeleton extends NPC {
	int coord_X;
	int coord_Y;
	
	public Skeleton (int coord_x, int coord_y) {
		super(coord_x, coord_y);
		id = "Skeleton";
		hp = 10;
		attack = 10;
		defence = 10;
		speed = 10;
		desc = "Un Squelette barre la porte";
		name= "Squelette";
	}
}
