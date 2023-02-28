
public class Slime extends NPC{
	int coord_X;
	int coord_Y;
	
	public Slime (int coord_x, int coord_y) {
		super(coord_x,coord_y);
		id = "Slime";
		hp = 10;
		attack = 100;
		defence = 10;
		speed = 10;
		desc = "Un Slime erre ici, en vous voyant il se montre agressif";
		name= "Slime";
	}

}
