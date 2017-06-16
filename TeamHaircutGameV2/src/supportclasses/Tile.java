package supportclasses;

import javagame.Hero;

import org.newdawn.slick.Animation;
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
import dimensions.Dimensions;

public class Tile {
	public static int count;
	private Rectangle rec;
	
	private float x;
	private float y;
	
	private float nx;
	private boolean isHit;
	private Animation anin;
	//private String post;
	private Animation post;
	private boolean looping;
	
	private float xOffset;
	private float yOffset;
	
	public Tile(float x, float y, Animation ani, Animation post, boolean looping) {
		count++;
		
		this.x = x*Dimensions.D;
		this.y = y*Dimensions.D;
		
		nx = -((x*Dimensions.D)-350);
		this.isHit = false;
		anin = new Animation();
		anin = ani.copy();
		this.post = post;
		this.looping = looping;
		this.xOffset = 0;
		this.yOffset = 0;
	}
	
	public Tile(float x, float y, Animation ani, Animation post, float xOffset, float yOffset, boolean looping) {
		count++;
		
		this.x = x*Dimensions.D;
		this.y = y*Dimensions.D;
		
		nx = -((x*Dimensions.D)-350);
		this.isHit = false;
		anin = new Animation();
		anin = ani.copy();
		this.post = post;
		this.looping = looping;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
	{
		rec = new Rectangle(x,y,Dimensions.D,Dimensions.D);
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
	{
		if(isHit) {
			anin.draw(x+xOffset,y+yOffset);
		}
		else {
			anin.draw(x, y);
		}
		rec.setX(x);
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{
		x = GameFunc.scrollImage(x, nx, Hero.wall, Hero.nx);
		isHit = GameFunc.isHitCheck(rec, Hero.rec3, isHit);
		
		if(isHit) {
			
			//anin = new Animation();
			//anin.addFrame(new Image(post), 200);
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
