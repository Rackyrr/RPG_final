

public class Troll extends NPC {
	int coord_X;
	int coord_Y;
	
	public Troll (int coord_y, int coord_x) {
		coord_X = coord_x;
		coord_Y = coord_y;
		id = "Troll";
		hp = 10;
		attack = 10;
		defence = 10;
		speed = 10;
		desc = "Un troll se tient en face de vous";
		name= "Un Troll";
	}

}
