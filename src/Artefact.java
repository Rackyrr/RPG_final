
public class Artefact extends Item{
	boolean IsWeared;
	boolean BonusOnAttack;
	boolean BonusOnDefence;
	boolean BonusOnSpeed;
	int BonusDefence;
	
	public Artefact(String name, String desc, boolean isWearable, String wearloc, int bonus) {
		super(name,desc, isWearable, wearloc);
		// TODO Auto-generated constructor stub
		BonusDefence = bonus;
	}
	
}
