package supportclasses;

import org.newdawn.slick.geom.Rectangle;

public class RectangleList {
	
	private static Rectangle[] list;
	private static int count;
	
	public static void addSolid(Rectangle[] newArray) {
		for(int i = 0; i < newArray.length; i++) {
			list[count] = newArray[i];
			count++;
		}
	}
	
	public static void createNewList(int length) {
		count = 0;
		list = new Rectangle[length];
	}
	
	public static Rectangle[] getSolids()
	{
		return list;
	}
	
	
	
	
	

}

