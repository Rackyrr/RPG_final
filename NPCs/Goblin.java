
public class Goblin extends NPC {
	int coord_X;
	int coord_Y;
	
	public Goblin (int coord_x, int coord_y) {
		super(coord_x,coord_y);
		id = "Goblin";
		hp = 10;
		attack = 10;
		defence = 10;
		speed = 10;
		desc = "Un goblin surgit devant vous";
		name= "Goblin";
	}
}
