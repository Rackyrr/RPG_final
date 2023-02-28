
public class Weapon extends Item {
	boolean IsWeared;
	int Dammage;
	int MalusOnSpeed;

	public Weapon(String name, String desc, boolean isWearable, String wearloc, 
			int dammage, int malusSpeed) {
		super(name, desc, isWearable, wearloc);
		// TODO Auto-generated constructor stub
		Dammage = dammage;
		MalusOnSpeed = malusSpeed;
	}

}
