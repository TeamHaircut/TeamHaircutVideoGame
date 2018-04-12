//	www.teamhaircut.org
package states;

public class GameState {
	
	public static final int INTROSTATE = -4;//0
	public static final int TITLESTATE = -3;//1
	public static final int SELECTSTATE = -2;//2
	public static final int STARTSTATE = -1;//3
	
	public static final int LEVEL_Test = -99;
	public static final int LEVEL_1_1 = 1;//4
	public static final int LEVEL_1_2 = 2;
	
	
	public static final int GAMEOVERSTATE = -5;//99
	
	private static int currentState = 1;

	public static int getCurrentState() {
		return currentState;
	}

	public static void setCurrentState(int currentState) {
		GameState.currentState = currentState;
	}
	
}//[end GameState]
