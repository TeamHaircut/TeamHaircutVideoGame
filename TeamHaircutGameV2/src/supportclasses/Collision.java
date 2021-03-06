//	www.teamhaircut.org
package supportclasses;

import org.newdawn.slick.geom.Rectangle;


public class Collision {
	
	private static boolean flagTop;
	private static boolean flagBottomLeft;
	private static boolean flagBottomRight;
	private static boolean flagBottomPartial;
	private static boolean flagBottomFull;
	private static boolean flagRight;
	private static boolean flagLeft;
	private static boolean flagBadGuy;
	
	private static boolean flagBullet;
	
	public Collision()
	{
//		setFlagTop(false);
//		setFlagBottom(false);
//		setFlagRight(false);
//		setFlagLeft(false);
//		setFlagBadGuy(false);
	}
	
	public static boolean checkObjectCollision(Rectangle r, Rectangle[] list) {
		boolean flag = false;
		for(int i =0; i < list.length; i++) {
			if(r.intersects(list[i])) {
				flag = true;
			}
			
		}
		return flag;
	}

	public static void checkHeroCollision(Rectangle[] r)
	{
		
		setFlagTop(false);
		setFlagBottomLeft(false);
		setFlagBottomRight(false);
		setFlagBottomFull(false);
		setFlagBottomPartial(false);
		setFlagRight(false);
		setFlagLeft(false);
		for(int i = 0; i < r.length-Item.count; i++)
		{
			if(	r[i].contains(Hero.bottomLeft)) {
				setFlagBottomLeft(true);
			}
			
			if(	r[i].contains(Hero.bottomRight)) {
				setFlagBottomRight(true);
			}
			
			
			if(	r[i].contains(Hero.bottomLeft) || r[i].contains(Hero.bottomRight)	) {
				setFlagBottomPartial(true);
				
			}
			
			if(	r[i].contains(Hero.bottomLeft) && r[i].contains(Hero.bottomRight)	) {
				setFlagBottomFull(true);
			}
			
			if(	(r[i].contains(Hero.leftHigh) || r[i].contains(Hero.leftMid) || r[i].contains(Hero.leftLow)) &&
				(r[i].contains(Hero.leftHighPercept) || r[i].contains(Hero.leftMidPercept) || r[i].contains(Hero.leftLowPercept))
			) {
				setFlagLeft(true);
				Hero.dX--;
			}
			else if((r[i].contains(Hero.leftHighPercept) || r[i].contains(Hero.leftMidPercept) || r[i].contains(Hero.leftLowPercept))) {
				setFlagLeft(true);
			}
			
			if(	(r[i].contains(Hero.rightHigh) || r[i].contains(Hero.rightMid) || r[i].contains(Hero.rightLow)) &&
				(r[i].contains(Hero.rightHighPercept) || r[i].contains(Hero.rightMidPercept) || r[i].contains(Hero.rightLowPercept))
			) {
				setFlagRight(true);
				Hero.dX++;
				}
			else if((r[i].contains(Hero.rightHighPercept) || r[i].contains(Hero.rightMidPercept) || r[i].contains(Hero.rightLowPercept))) {
				setFlagRight(true);
			}
			
			if(	r[i].contains(Hero.topLeft)	|| r[i].contains(Hero.topRight)
			) {
				setFlagTop(true);
			}	
		}
	}
	
	public static void checkCollisionBadguy(Rectangle r) {
		//setFlagBadGuy(false);
		if (r.intersects(Hero.bottomRec)) {
			setFlagBadGuy(true);
		}
	}
	
	public static void checkBulletCollisionBadguy(Rectangle r) {
		setFlagBullet(false);
		if(!BulletList.getList().isEmpty()) {
			if (r.intersects(BulletList.getList().get(0).getRec())) {
				setFlagBullet(true);
			}
		}
	}
	
	public static boolean isFlagBottomLeft() {
		return flagBottomLeft;
	}

	public static void setFlagBottomLeft(boolean flagBottomLeft) {
		Collision.flagBottomLeft = flagBottomLeft;
	}

	public static boolean isFlagBottomRight() {
		return flagBottomRight;
	}

	public static void setFlagBottomRight(boolean flagBottomRight) {
		Collision.flagBottomRight = flagBottomRight;
	}

	public static boolean isFlagBottomPartial() {
		return flagBottomPartial;
	}

	public static void setFlagBottomPartial(boolean flagBottomPartial) {
		Collision.flagBottomPartial = flagBottomPartial;
	}

	public static boolean isFlagBottomFull() {
		return flagBottomFull;
	}

	public static void setFlagBottomFull(boolean flagBottomFull) {
		Collision.flagBottomFull = flagBottomFull;
	}

	public static void setFlagTop(boolean newSetting)
	{
		flagTop = newSetting;
	}
	
	public static void setFlagRight(boolean newSetting)
	{
		flagRight = newSetting;
	}
	
	public static void setFlagLeft(boolean newSetting)
	{
		flagLeft = newSetting;
	}
	
	public static void setFlagBadGuy(boolean newSetting)
	{
		flagBadGuy = newSetting;
	}
	
	public static boolean getFlagTop()
	{
		return flagTop;
	}
	
	public static boolean getFlagRight()
	{
		return flagRight;
	}
	
	public static boolean getFlagLeft()
	{
		return flagLeft;
	}
	
	
	public static boolean getFlagBadGuy()
	{
		return flagBadGuy;
	}

	public static boolean isFlagBullet() {
		return flagBullet;
	}

	public static void setFlagBullet(boolean flagBullet) {
		Collision.flagBullet = flagBullet;
	}
}//[end Collision]