package states;

public class GameState {
	public static final String FONTNAME = "Emulogic";
	
	public static final int INTROSTATE = 0;
	public static final int TITLESTATE = 1;
	public static final int SELECTSTATE = 2;
	public static final int STARTSTATE = 3;
	
	public static final int LEVEL1 = 4;
	public static final int LEVEL2 = 5;
	
	public static final int GAMEOVERSTATE = 99;
	
	private static int currentState = 4;

	public static int getCurrentState() {
		return currentState;
	}

	public static void setCurrentState(int currentState) {
		GameState.currentState = currentState;
	}
	
}
