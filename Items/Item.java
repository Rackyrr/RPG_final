
public class Item {
	String name;
	String desc;
	boolean isWearable = false;
	String wearloc;
	
	public Item(String name, String desc, boolean isWearable, String wearloc) {
		this.name = name;
		this.desc = desc;
		this.isWearable = isWearable;
		this.wearloc = wearloc;
	}

}
