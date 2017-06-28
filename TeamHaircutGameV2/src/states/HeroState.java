package states;

public class HeroState {
	
	private static int index = 1;
	private static int lives = 3;

	public static int getIndex() {
		return index;
	}

	public static void setIndex(int index) {
		HeroState.index = index;
	}

	public static int getLives() {
		return lives;
	}

	public static void setLives(int lives) {
		HeroState.lives = lives;
	}
	
}
