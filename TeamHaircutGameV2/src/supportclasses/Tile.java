package supportclasses;

import javagame.Hero;

import org.newdawn.slick.Color;
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
	
	private Image image;
	public Rectangle rec;
	private float x;
	private float y;
	private float nx;
	private String res0;
	private String res1;
	
	private boolean isHit;
	
	public Tile(float x, float y, String res0, String res1) {
		count++;
		this.x = x*Dimensions.D;
		this.y = y*Dimensions.D;
		nx = -((x*Dimensions.D)-350);
		this.res0 = res0;
		this.res1 = res1;
		this.isHit = false;
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
	{
		isHit = false;
		image = new Image(res0);
		rec = new Rectangle(x,y,Dimensions.D,Dimensions.D);
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
	{
		if(isHit) {
			g.drawImage(new Image(res1),x,y);
		}
		else {
			g.drawImage(image,x,y);
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

	public String getRes0() {
		return res0;
	}


	public void setRes0(String res0) {
		this.res0 = res0;
	}


	public String getRes1() {
		return res1;
	}


	public void setRes1(String res1) {
		this.res1 = res1;
	}

	public boolean isHit() {
		return isHit;
	}

	public void setHit(boolean isHit) {
		this.isHit = isHit;
	}

}
