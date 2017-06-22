package supportclasses;

import javagame.Hero;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import animations.CustomAnimation;
import arrays.ImageArrays;
import states.ScrRes;
import dansLibrary.GameFunc;
import dimensions.Ints;

public class HiddenCoin {
	
	private float x;
	private float y;
	
	private float nx;
	
	private Animation ani;
	
	private boolean isAvailable;
	
	public HiddenCoin(float x, int y) {
		this.x = (x*Ints.D);
		this.y = (toFloor(y)*Ints.D)-Ints.D;
		
		nx = -((x*Ints.D)-350);
		
		this.ani = new Animation();
		this.isAvailable = true;
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
	{
		ani = new CustomAnimation(ImageArrays.getCoinItem(),200).getAni();
		ani.setLooping(false);
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
	{
		ani.draw(x, y);
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{
		x = GameFunc.scrollImage(x, nx, Hero.wall, Hero.nx);
	}
	
  public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

private float toFloor(int floor) {
	   return (ScrRes.getHeight()-(Ints.D*floor))/Ints.D;
   }

}
