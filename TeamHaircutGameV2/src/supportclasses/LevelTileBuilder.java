package supportclasses;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

public class LevelTileBuilder {

	public Rectangle[] rec;
	private Tile[] myArray;
	private int size;

	public LevelTileBuilder(Tile[] tileArray) {
		size = tileArray.length;
		myArray = new Tile[size];
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
