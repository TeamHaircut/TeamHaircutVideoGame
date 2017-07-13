package supportclasses;

import states.HeroState;

public class PowerState {
	
	private static int powerUpState;
	
	public PowerState()
	{
		setPowerUpState(1);
	}
	
	public static void setPowerUpState(int newPowerUpState)
	{
		powerUpState = newPowerUpState;
	}
	
	public static int getPowerUpState()
	{
		return powerUpState;
	}
	
	public static void incrementPowerUpState()
	{
//		if (powerUpState < 2)
//			powerUpState = powerUpState + 1;
		HeroState.setEffect(HeroState.EFFECT_BIGMAN);
	}
	
	public static void decrementPowerUpState()
	{
		if(powerUpState > 0)
			powerUpState = powerUpState - 1;
	}

}
