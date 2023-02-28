
public class Goblin extends NPC {
	int coord_X;
	int coord_Y;
	
	public Goblin (int coord_y, int coord_x) {
		coord_X = coord_x;
		coord_Y = coord_y;
		id = "Goblin";
		hp = 10;
		attack = 10;
		defence = 10;
		speed = 10;
		desc = "Un goblin surgit devant vous";
		name= "Un Goblin";
	}
}
