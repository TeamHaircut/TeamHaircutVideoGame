package supportclasses;

import javagame.Hero;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
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
	private String res0;
	private String res1;
	
	private float nx;
	private Image image;
	private boolean isHit;
	
	public Tile(float x, float y, String res0, String res1) {
		count++;
		
		this.x = x*Dimensions.D;
		this.y = y*Dimensions.D;
		this.res0 = res0;
		this.res1 = res1;
		
		nx = -((x*Dimensions.D)-350);
		this.isHit = false;
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
	{
		image = new Image(res0);
		rec = new Rectangle(x,y,Dimensions.D,Dimensions.D);
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
	{
		if(isHit) {
			g.drawImage(new Image(res1),x,y);
		}
		else {
			g.drawImage(new Image(res0),x,y);
		}
		rec.setX(x);
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{
		x = GameFunc.scrollImage(x, nx, Hero.wall, Hero.nx);
		isHit = GameFunc.isHitCheck(rec, Hero.rec3, isHit);
	}

	public Rectangle getRec() {
		return rec;
	}

	public void setRec(Rectangle rec) {
		this.rec = rec;
	}
	
}
