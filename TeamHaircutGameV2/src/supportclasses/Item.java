package supportclasses;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

import states.ScrRes;
import dimensions.Ints;

public class Item{
	
	public static int count;
	public float x;
	public float y;
	private Rectangle rec;
	private boolean isHit;
	public float nx;
	public float vox;
	
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
//		g.fill(rec);
//		g.setColor(Color.white);
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{
		isHit = GameFunc.isHitCheck(rec, Ints.COLLISION_FULL, isHit);//rec5
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

	public float getNx() {
		return nx;
	}


	public void setNx(float nx) {
		this.nx = nx;
	}


	private float toFloor(int floor) {
		   return (ScrRes.getHeight()-(Ints.D*floor))/Ints.D;
	}

}
