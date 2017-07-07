package supportclasses;

import org.newdawn.slick.geom.Rectangle;

import states.HeroState;
import dimensions.Ints;

public class Collision {
	
	private static boolean flagTop;
	private static boolean flagBottom;
	private static boolean flagRight;
	private static boolean flagLeft;
//	private static boolean flagBadGuy;
	
	
	
	public Collision()
	{
//		setFlagTop(false);
//		setFlagBottom(false);
//		setFlagRight(false);
//		setFlagLeft(false);
//		setFlagBadGuy(false);
	}

	public static void checkHeroCollision(Rectangle[] r)
	{
		setFlagTop(false);
		setFlagBottom(false);
		setFlagRight(false);
		setFlagLeft(false);
		for(int i = 0; i < r.length; i++)
		{

			if(	(r[i].contains((float)Hero.bottom.getEndX(), (float)Hero.bottom.getEndY()) ||
				 r[i].contains((float)Hero.bottom.getStartX(), (float)Hero.bottom.getStartY()))) {
				setFlagBottom(true);
			}

			if(	r[i].contains((float)Hero.left.getEndX(), (float)Hero.left.getEndY()) && r[i].contains(Hero.leftA)) {
				setFlagLeft(true);
				HeroState.setAction(HeroState.ACTION_NONE);
				Hero.dX--;
			}
			else if(r[i].contains(Hero.leftA)) {
				setFlagLeft(true);
			}
		//	
			if(	r[i].contains((float)Hero.right.getEndX(), (float)Hero.right.getEndY()) && r[i].contains(Hero.rightA)) {
				setFlagRight(true);
				Hero.dX++;
				HeroState.setAction(HeroState.ACTION_NONE);
			}
			else if(r[i].contains(Hero.rightA)) {
				setFlagRight(true);
			}
		//	
			if(	r[i].contains((float)Hero.top.getEndX(), (float)Hero.top.getEndY()) ||
				r[i].contains((float)Hero.top.getStartX(), (float)Hero.top.getStartY())) {
				setFlagTop(true);
				System.out.println("top Collision!");
			}	
		}
	}
	
	
	
	public static void checkCollisionBadguy(Rectangle[] r)
	{
//		setFlagBadGuy(false);
//		for (int i = 0; i < r.length; i++)
//		   {
//			   if (r[i].intersects(Hero.recBottom))
//				   setFlagBadGuy(true);
//		   }
		}
	
	public static void setFlagTop(boolean newSetting)
	{
		flagTop = newSetting;
	}
	
	public static void setFlagBottom(boolean newSetting)
	{
		flagBottom = newSetting;
	}
	
	public static void setFlagRight(boolean newSetting)
	{
		flagRight = newSetting;
	}
	
	public static void setFlagLeft(boolean newSetting)
	{
		flagLeft = newSetting;
	}
//	
//	public static void setFlagBadGuy(boolean newSetting)
//	{
//		flagBadGuy = newSetting;
//	}
//	
	public static boolean getFlagTop()
	{
		return flagTop;
	}
	
	public static boolean getFlagBottom()
	{
		return flagBottom;
	}
	
	public static boolean getFlagRight()
	{
		return flagRight;
	}
	
	public static boolean getFlagLeft()
	{
		return flagLeft;
	}
//	
//	public static boolean getFlagBadGuy()
//	{
//		return flagBadGuy;
//	}
	
	
	
	

}
