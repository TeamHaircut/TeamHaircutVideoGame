//	www.teamhaircut.org
package states;

public class HeroState {
	
	public static final int DAMIAN = 0;
	public static final int DAN = 1;
	
	public static final int LEFT = 0;
	public static final int RIGHT = 1;
	
	public static final int ACTION_NONE = 0;
	public static final int ACTION_WALK = 1;
	public static final int ACTION_JUMP = 2;
	
	public static final int EFFECT_NONE = 0;
	public static final int EFFECT_BIGMAN = 1;
	public static final int EFFECT_STARMAN = 2;
	
	public static final int STATE_DEAD = 0;
	public static final int STATE_ALIVE = 1;
	
	
	private static int index = 0;
	private static int direction = 0;
	private static int action = 0;
	private static int effect = 0;
	
	private static int state = 1;
	
	private static int lives = 3;
	private static int coins = 0;

	public static int getIndex() {
		return index;
	}

	public static void setIndex(int index) {
		HeroState.index = index;
	}

	public static int getDirection() {
		return direction;
	}

	public static void setDirection(int direction) {
		HeroState.direction = direction;
	}

	public static int getAction() {
		return action;
	}

	public static void setAction(int action) {
		HeroState.action = action;
	}

	public static int getEffect() {
		return effect;
	}

	public static void setEffect(int effect) {
		HeroState.effect = effect;
	}

	public static int getState() {
		return state;
	}

	public static void setState(int state) {
		HeroState.state = state;
	}

	public static int getLives() {
		return lives;
	}

	public static void setLives(int lives) {
		HeroState.lives = lives;
	}
	
	public static void incrementLives() {
		HeroState.lives++;
	}
	
	public static void decrementLives() {
		HeroState.lives--;
	}

	public static int getCoins() {
		return coins;
	}

	public static void setCoins(int coins) {
		HeroState.coins = coins;
	}
	
	public static void incrementCoins() {
		HeroState.coins++;
	}
	
}
