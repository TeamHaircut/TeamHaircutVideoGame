//	www.teamhaircut.org
package supportclasses;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import states.HeroState;
import animations.CustomAnimation;
import arrays.ImageArrays;

public class Coin extends Item{

	private Animation ani;
	private boolean isAvailable;
	
	public Coin(float x, int y) {
		super(x,y);
		
		this.ani = new Animation();
		this.isAvailable = true;
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
	{
		super.init(gc, sbg);
		ani = new CustomAnimation(ImageArrays.getCoin(),200).getAni();
		ani.setLooping(true);
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
	{
		super.render(gc, sbg, g);
		if(!isAvailable) {
			ani.draw(-2000, super.getY());
			super.getRec().setX(-2000);
		}
		if(isAvailable) {
			ani.draw(super.getX(), super.getY());
			super.getRec().setX(super.getX());
			super.getRec().setY(super.getY());
		}
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{
		super.update(gc, sbg, delta);
		if(super.isHit()) {
			if(isAvailable) {
				HeroState.incrementCoins();
			}
			isAvailable = false;
		}		
	}
	
  public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

}
