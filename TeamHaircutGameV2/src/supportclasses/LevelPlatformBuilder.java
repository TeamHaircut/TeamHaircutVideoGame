//	www.teamhaircut.org
package supportclasses;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.*;

public class LevelPlatformBuilder{
	
	public Rectangle[] rec;
	private Platform[] myArray;
	private int size;
	
	public LevelPlatformBuilder(Platform[] platformArray) {
		
		size = platformArray.length;
		myArray = new Platform[size];
		rec = new Rectangle[size];
		for(int i = 0; i < size; i++) {
			myArray[i] = platformArray[i];
		}
		
	}	

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		for(int i = 0; i < size; i++) {
			myArray[i].init(gc, sbg);
			rec[i] = myArray[i].getRec();
		}
	}
   
   public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
	   for(int i = 0; i < size; i++) {
			myArray[i].render(gc, sbg, g);
		}
	}
   
   public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
	   for(int i = 0; i < size; i++) {
			myArray[i].update(gc, sbg, delta);
		}
	}
}//[end LevelPlatformBuilder]