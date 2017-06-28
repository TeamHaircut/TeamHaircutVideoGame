package supportclasses;

import supportclasses.Hero;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

import states.ScrRes;
import dansLibrary.GameFunc;
import dimensions.Ints;


public class Item{
	
	public static int count;
	private float x;
	private float y;
	private Rectangle rec;
	private boolean isHit;
	private float nx;
	
	public Item(float x, int y) {
		
		nx = -((x*Ints.D)-350);
		this.isHit = false;
		this.x = (x*Ints.D);
		this.y = (toFloor(y)*Ints.D)-Ints.D;
	}
	
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
	{
		rec = new Rectangle(x,y,Ints.D,Ints.D);
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
	{

	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{
		isHit = GameFunc.isHitCheck(rec, Hero.rec, isHit);//rec5
		x = GameFunc.scrollImage(x, nx, Ints.WALL, Ints.NX);
	}
	
	public float getX() {
		return x;
	}


	public void setX(float x) {
		this.x = x;
	}


	public float getY() {
		return y;
	}


	public void setY(float y) {
		this.y = y;
	}


	public boolean isHit() {
		return isHit;
	}


	public void setHit(boolean isHit) {
		this.isHit = isHit;
	}


	public Rectangle getRec() {
		return rec;
	}


	public void setRec(Rectangle rec) {
		this.rec = rec;
	}

	private float toFloor(int floor) {
		   return (ScrRes.getHeight()-(Ints.D*floor))/Ints.D;
	}

}
