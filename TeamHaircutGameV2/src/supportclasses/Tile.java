package supportclasses;

import javagame.Hero;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

import dansLibrary.GameFunc;
import dimensions.Dimensions;

public class Tile {
	public static int count;
	private Rectangle rec;
	
	private float x;
	private float y;
	
	private float nx;
	private boolean isHit;
	private Animation ani;
	
	public Tile(float x, float y, Animation ani) {
		count++;
		
		this.x = x*Dimensions.D;
		this.y = y*Dimensions.D;
		
		nx = -((x*Dimensions.D)-350);
		this.isHit = false;
		this.ani = ani.copy();
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
	{
		rec = new Rectangle(x,y,Dimensions.D,Dimensions.D);
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
	{
		ani.draw(x, y);
		rec.setX(x);
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{
		x = GameFunc.scrollImage(x, nx, Hero.wall, Hero.nx);
		isHit = GameFunc.isHitCheck(rec, Hero.rec3, isHit);
		
		if(isHit) {
			ani.setAutoUpdate(true);
		}
		
		
	}

	public Rectangle getRec() {
		return rec;
	}

	public void setRec(Rectangle rec) {
		this.rec = rec;
	}
	
}
