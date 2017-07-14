package supportclasses;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

public class LevelItemBuilder {

	public Rectangle[] rec;
	private Item[] myArray;
	private int size;

	public LevelItemBuilder(Item[] tileArray) {
		size = tileArray.length;
		myArray = new Item[size];
		rec = new Rectangle[size];
		for(int i = 0; i < size; i++) {
			myArray[i] = tileArray[i];
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
	
}
