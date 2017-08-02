package supportclasses;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import dimensions.Ints;
import animations.CustomAnimation;
import arrays.ImageArrays;

public class OneUp extends Item{

	private float dX;
	//public float vox;
	private Animation ani;
	private Animation postAni;
	private boolean isAvailable;
	
	public OneUp(float x, int y) {
		super(x,y);
		dX = x;
		this.ani = new Animation();
		this.postAni = new Animation();
		this.isAvailable = true;
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
	{
		vox = 0.0f;
		super.init(gc, sbg);
		ani = new CustomAnimation(ImageArrays.getOneUp(),200).getAni();
		postAni = new CustomAnimation(ImageArrays.getOneUpPost(),3000).getAni();
		ani.setLooping(false);
		postAni.setLooping(false);
		postAni.stop();
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
	{
		super.render(gc, sbg, g);
		if(!isAvailable) {
			ani.draw(-2000, super.getY());
			postAni.draw(super.getX(),super.getY());
			super.getRec().setX(-2000);
		}
		if(isAvailable) {
			ani.draw(super.getX(), super.getY());
			postAni.draw(-2000,super.getY());
			super.getRec().setX(super.getX());
		}
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{
		super.update(gc, sbg, delta);
		nx = nx - ((vox)*delta);
		if(super.isHit()) {
			if(isAvailable) {
				vox = 0.0f;
				postAni.restart();
				//PowerState.incrementPowerUpState();
				//LiveState.incrementLives();
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
