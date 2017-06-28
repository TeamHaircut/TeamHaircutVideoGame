package supportclasses;

import org.newdawn.slick.geom.Rectangle;

public class Collision {
	
//	private static boolean flagTop;
//	private static boolean flagBottom;
//	private static boolean flagRight;
//	private static boolean flagLeft;
//	private static boolean flagBadGuy;
	
	private static boolean collides;
	
	public Collision()
	{
//		setFlagTop(false);
//		setFlagBottom(false);
//		setFlagRight(false);
//		setFlagLeft(false);
//		setFlagBadGuy(false);
		setCollides(false);
	}
	
	public static boolean isCollides() {
		return collides;
	}

	public static void setCollides(boolean collides) {
		Collision.collides = collides;
	}
	
	public static void checkHeroCollision(Rectangle[] r)
	{
		setCollides(false);
//		setFlagTop(false);
//		setFlagBottom(false);
//		setFlagRight(false);
//		setFlagLeft(false);
//		for(int i = 0; i < r.length; i++)
//		{
//			if(r[i].intersects(Hero.rec3))
//				setFlagTop(true);
//			else if (r[i].intersects(Hero.recBottom))
//				{setFlagBottom(true);}
//			else if (r[i].intersects(Hero.recRight))
//				setFlagRight(true);
//			else if (r[i].intersects(Hero.recLeft))
//				setFlagLeft(true);
//			
//		}
		for(int i = 0; i < r.length; i++) {
			if(r[i].intersects(Hero.rec)) {
				setCollides(true);
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
	
//	public static void setFlagTop(boolean newSetting)
//	{
//		flagTop = newSetting;
//	}
//	
//	public static void setFlagBottom(boolean newSetting)
//	{
//		flagBottom = newSetting;
//	}
//	
//	public static void setFlagRight(boolean newSetting)
//	{
//		flagRight = newSetting;
//	}
//	
//	public static void setFlagLeft(boolean newSetting)
//	{
//		flagLeft = newSetting;
//	}
//	
//	public static void setFlagBadGuy(boolean newSetting)
//	{
//		flagBadGuy = newSetting;
//	}
//	
//	public static boolean getFlagTop()
//	{
//		return flagTop;
//	}
//	
//	public static boolean getFlagBottom()
//	{
//		return flagBottom;
//	}
//	
//	public static boolean getFlagRight()
//	{
//		return flagRight;
//	}
//	
//	public static boolean getFlagLeft()
//	{
//		return flagLeft;
//	}
//	
//	public static boolean getFlagBadGuy()
//	{
//		return flagBadGuy;
//	}
	
	
	
	

}
