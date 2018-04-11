package supportclasses;

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
	
	private boolean jumpTriggerIsSet;
	
	public Item(float x, int y) {
		
		nx = -((x*Ints.D)-350);
		this.isHit = false;
		this.x = -2000;
		//this.x = (x*Ints.D);
		this.y = (toFloor(y)*Ints.D)-Ints.D;
	}
	
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
	{
		if(this instanceof OneUp || this instanceof BasicBadGuy ) {
			rec = new Rectangle(x,y,Ints.D,(Ints.D*2));
		}
		else {
			rec = new Rectangle(x,y,Ints.D,Ints.D);
		}
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
	{
		//g.setColor(Color.white);
		//g.fill(getRec());
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{
		if (this instanceof BasicBadGuy ) {
			isHit = GameFunc.isHitCheck(rec, Ints.COLLISION_BOTTOM, isHit);
		}
		else {
			isHit = GameFunc.isHitCheck(rec, Ints.COLLISION_FULL, isHit);

		}
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
	
	public void setJumpTrigger(boolean newSetting) {
		this.jumpTriggerIsSet = newSetting;
	}
	
	public boolean getJumpTrigger() {
		return jumpTriggerIsSet;
	}

}
