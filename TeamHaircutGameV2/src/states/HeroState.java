//	www.teamhaircut.org
package states;

public class HeroState {
	
	public static final int DAMIAN = 0;
	public static final int DAN = 1;
	
	public static final int LEFT = -1;
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
	private static String coinsString = "00";
	private static int score = 0;
	private static String scoreString = "000000";

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
		if(HeroState.coins == 0) {
			HeroState.coinsString = "00";
		}
	}
	
	public static void incrementCoins() {
		HeroState.coins++;
		coinsToString();
	}

	public static int getScore() {
		return score;
	}

	public static void setScore(int score) {
		HeroState.score = score;
		if(HeroState.score == 0) {
			HeroState.scoreString = "000000";
		}
	}
	
	public static void incrementScore(int value) {
		HeroState.score+=value;
		scoreToString();
	}

	public static String getScoreString() {
		return scoreString;
	}

	public static void scoreToString() {
		scoreString = Integer.toString(getScore());
		int stringLength = scoreString.length();
		for(int i = stringLength; i < 6; i++) {
			scoreString = "0"+scoreString;
		}
		if(getScore() >= 1000000) {
			scoreString = "999999";
		}
		
	}
	
	public static String getCoinsString() {
		return coinsString;
	}

	public static void coinsToString() {
		coinsString = Integer.toString(getCoins());
		int stringLength = coinsString.length();
		for(int i = stringLength; i < 2; i++) {
			coinsString = "0"+coinsString;
		}
		if(getCoins() >= 100) {
			coinsString = "00";
			setCoins(0);
			incrementLives();
		}
		
	}
	
}//[end HeroState]
