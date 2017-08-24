package supportclasses;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

import states.HeroState;
import animations.CustomAnimation;
import arrays.ImageArrays;

public class OneUp extends Item{

	private int dir;
	private float dX;
	public float voy;
	private Animation ani;
	private Animation postAni;
	private boolean isAvailable;
	
	private static int counter;
	
	
	
	public OneUp(float x, int y) {
		super(x,y+1);
		dir = 1;
		dX = x;
		this.ani = new Animation();
		this.postAni = new Animation();
		this.isAvailable = true;
		counter = 0;
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
	{
		vox = 0.0f;
		voy = 0.05f;
		super.init(gc, sbg);
		ani = new CustomAnimation(ImageArrays.getOneUp(),200).getAni();
		postAni = new CustomAnimation(ImageArrays.getOneUpPost(),1500).getAni();
		ani.setLooping(false);
		postAni.setLooping(false);
		postAni.stop();
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
	{
		super.render(gc, sbg, g);
		if(!isAvailable) {
			ani.draw(-2000, super.getY());
			postAni.draw(super.getX()+dX,super.getY());
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
		
		counter += delta;
		
		nx = nx - ((vox)*(dir)*delta);
		if(super.isHit()) {
			if(isAvailable) {
				vox = 0.0f;
				dX = x;
				postAni.restart();
				HeroState.incrementLives();

			}
			else {
				y = y-((voy)*delta);
				dX = (float) (20*Math.sin(y/10));
			}
			isAvailable = false;
		}
		 boolean flag = Collision.checkObjectCollision(getRec(), RectangleList.getSolids());
//		 if(flag && counter > ) {
//			 HeroState.setCoins(dir);
//			 dir = -1*dir;
//		 }
		 
		 if (counter > 1000) {
			 if(flag) {
				 dir = -1*dir;
				 counter = 0;
			 }
		 } 
			 
		 
	}
	
  public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

}
