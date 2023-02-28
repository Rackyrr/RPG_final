
public class Slime extends NPC{
	int coord_X;
	int coord_Y;
	
	public Slime (int coord_y, int coord_x) {
		this.coord_X = coord_x;
		this.coord_Y = coord_y;
		id = "Slime";
		hp = 10;
		attack = 10;
		defence = 10;
		speed = 10;
		desc = "Un Slime erre ici, en vous voyant il se montre agressif";
		name= "Un Slime";
	}
}
