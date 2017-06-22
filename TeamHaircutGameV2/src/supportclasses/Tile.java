package supportclasses;

import javagame.Hero;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

import states.ScrRes;
import dansLibrary.GameFunc;
import dimensions.Ints;

public class Tile {
	
	public static int count;
	private Rectangle rec;
	
	private float x;
	private float y;
	
	private float nx;
	private boolean isHit;
	private Animation anin;
	private Animation post;
	private boolean looping;
	private int action;
	
	private float xOffset;
	private float yOffset;
	
	public Tile(float x, int y) {
		count++;
		
		this.x = x*Ints.D;
		this.y = toFloor(y)*Ints.D;
		
		nx = -((x*Ints.D)-350);
		this.isHit = false;
		
	}
	
	public Tile(float x, float y, Animation ani, Animation post, boolean looping) {
		count++;
		
		this.x = x*Ints.D;
		this.y = y*Ints.D;
		
		nx = -((x*Ints.D)-350);
		this.isHit = false;
		anin = new Animation();
		anin = ani.copy();
		this.post = post;
		this.looping = looping;
		this.xOffset = 0;
		this.yOffset = 0;
		this.action = Ints.TILE_ACTION_NONE;
	}
	
	public Tile(float x, float y, Animation ani, Animation post, boolean looping, int action) {
		count++;
		
		this.x = x*Ints.D;
		this.y = y*Ints.D;
		
		nx = -((x*Ints.D)-350);
		this.isHit = false;
		anin = new Animation();
		anin = ani.copy();
		this.post = post;
		this.looping = looping;
		this.xOffset = 0;
		this.yOffset = 0;
		this.action = action;
	}
	
	
	public Tile(float x, float y, Animation ani, Animation post, float xOffset, float yOffset, boolean looping) {
		count++;
		
		this.x = x*Ints.D;
		this.y = y*Ints.D;
		
		nx = -((x*Ints.D)-350);
		this.isHit = false;
		anin = new Animation();
		anin = ani.copy();
		this.post = post;
		this.looping = looping;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
		this.action = Ints.TILE_ACTION_NONE;
	}
	
	public Tile(float x, float y, Animation ani, Animation post, float xOffset, float yOffset, boolean looping, int action) {
		count++;
		
		this.x = x*Ints.D;
		this.y = y*Ints.D;
		
		nx = -((x*Ints.D)-350);
		this.isHit = false;
		anin = new Animation();
		anin = ani.copy();
		this.post = post;
		this.looping = looping;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
		this.action = action;
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
	{
		rec = new Rectangle(x,y,Ints.D,Ints.D);
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
	{
		if(isHit) {
			anin.draw(x+xOffset,y+yOffset);	
		}
		else {
			anin.draw(x, y);
		}
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{
		x = GameFunc.scrollImage(x, nx, Hero.wall, Hero.nx);
		rec.setX(x);
		switch (action){
			case Ints.TILE_ACTION_MAKE:
				if(Hero.jumpingUp && (Hero.dY <= (y+Ints.D) && Hero.dY >= (y+(Ints.D/2)))	) {
					isHit = GameFunc.isHitCheck(rec, Hero.rec3, isHit);
				}
				if(!isHit) {
					rec.setX(-2000);
				}
				break;
			case Ints.TILE_ACTION_BREAK:
				isHit = GameFunc.isHitCheck(rec, Hero.rec3, isHit);
				if(isHit) {
					rec.setX(-2000);
				}
				break;
			case Ints.TILE_ACTION_NONE:
				isHit = GameFunc.isHitCheck(rec, Hero.rec3, isHit);
				break;
			default:
				break;
		}
		
		if(isHit) {
			anin = post;
			anin.setLooping(looping);
			anin.start();
		}
	}
	
   private float toFloor(int floor) {
	   return (ScrRes.getHeight()-(Ints.D*floor))/Ints.D;
   }

	public Rectangle getRec() {
		return rec;
	}

	public void setRec(Rectangle rec) {
		this.rec = rec;
	}

	public Animation getAnin() {
		return anin;
	}

	public void setAnin(Animation anin) {
		this.anin = anin;
	}

	public Animation getPost() {
		return post;
	}

	public void setPost(Animation post) {
		this.post = post;
	}

	public boolean isLooping() {
		return looping;
	}

	public void setLooping(boolean looping) {
		this.looping = looping;
	}

	public int getAction() {
		return action;
	}

	public void setAction(int action) {
		this.action = action;
	}

	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}

	public boolean isHit() {
		return isHit;
	}

	public void setHit(boolean isHit) {
		this.isHit = isHit;
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

	public float getNx() {
		return nx;
	}

	public void setNx(float nx) {
		this.nx = nx;
	}
	
}
