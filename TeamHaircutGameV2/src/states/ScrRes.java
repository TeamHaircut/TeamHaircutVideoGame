//	www.teamhaircut.org
package states;

public class ScrRes {
	
	private static int height;
	private static int width;
	
	private ScrRes() {
		height = 480;
		width = 980;
	}
	
	public static int getHeight() {
		return height;
	}
	public static int getHeight(int d) {
		return height/d;
	}
	public static void setHeight(int newHeight) {
		height = newHeight;
	}
	public static int getWidth() {
		return width;
	}
	public static int getWidth(int d) {
		return width/d;
	}
	public static void setWidth(int newWidth) {
		width = newWidth;
	}
	

}
