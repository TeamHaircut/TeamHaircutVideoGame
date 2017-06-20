package supportclasses;

import javagame.Hero;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

import animations.CustomAnimation;
import arrays.ImageArrays;
import strings.Strings;
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
		if(action == Ints.TILE_ACTION_MAKE) {
			rec = new Rectangle(-2000,y,Ints.D,Ints.D);
		}
		else {
			rec = new Rectangle(x,y,Ints.D,Ints.D);
		}
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
	{
		if(isHit) {
			anin.draw(x+xOffset,y+yOffset);
			if(action == Ints.TILE_ACTION_BREAK) {
				rec.setX(-2000);
			}
//			else if(action == Ints.TILE_ACTION_MAKE) {
//				
//			}
			else {
				rec.setX(x);
			}
			
			
		}
		else {
			anin.draw(x, y);
			rec.setX(x);
		}
//		g.fill(rec);
//		g.setColor(Color.white);
		
		
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{
		//this is a mess
		x = GameFunc.scrollImage(x, nx, Hero.wall, Hero.nx);
		if(action == Ints.TILE_ACTION_MAKE) {
			if (Hero.jumpingUp) {
				rec.setX(x);
				isHit = GameFunc.isHitCheck(rec, Hero.rec3, isHit);
			}
			else {
				if(isHit) {
					rec.setX(x);
				}
				else {
					rec.setX(-2000);
				}
			}
		}
		else {
		
		
		isHit = GameFunc.isHitCheck(rec, Hero.rec3, isHit);
		
		}
		
		if(isHit) {
			anin = post;
			anin.setLooping(looping);
			anin.start();
		}
		

		
		
	}

	public Rectangle getRec() {
		return rec;
	}

	public void setRec(Rectangle rec) {
		this.rec = rec;
	}
	
}
