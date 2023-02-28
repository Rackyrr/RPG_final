
public class Potion extends Item {
	int Healing;

	public Potion(String name, String desc, boolean isWearable, String wearloc, int heal) {
		super(name, desc, isWearable, wearloc);
		// TODO Auto-generated constructor stub
		Healing = heal;
	}

}
