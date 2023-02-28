
public class Simple_RPG {
	static Game_Logic gl = new Game_Logic();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game_Objects.initalizeNPCArray();
		Game_Objects.initalizeWeaponArray();
		Game_Objects.initalizePotionArray();;
		Game_Objects.initalizeArtefactArray();
		gl.createCharacter();
		while(Game_Objects.pc.IsDead == false)
		{
		game_loop();
		}

	}
	public static void game_loop()
	{
		gl.waitforCommand();
	}

}
