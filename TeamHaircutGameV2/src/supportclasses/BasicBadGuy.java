//	www.teamhaircut.org
package supportclasses;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Point;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

import dimensions.Ints;
import states.GameState;
import states.HeroState;
import states.ScrRes;
import animations.CustomAnimation;
import arrays.ImageArrays;

public class BasicBadGuy extends Item{
	
	public int dir;
	public int counter;
	
	public Point leftHigh, leftMid, leftLow;
	public Point leftHighPercept, leftMidPercept, leftLowPercept;
	public Point rightHigh, rightMid, rightLow;
	public Point rightHighPercept, rightMidPercept, rightLowPercept;
	public Point bottomLeft, bottomRight, bottomLeftPercept;
	public Point bottomRightPercept, topLeft, topRight;
	public Point topLeftPercept, topRightPercept;
	
	private ObjectCollision coll;
	
	private float a = -750f;
	private float dX;
	private float dY;
	private float yo;
	private float v;
	private float vo;
	public float voy;
	private float timeY;
	private float jumpCounter;
	
	private Animation aniL;
	private Animation aniR;
	private Animation postAni;
	private boolean isAvailable;
	
	public BasicBadGuy(float x, int y) {
		super(x, y);

		dir = 1;
		dX=-2000;
		counter = 0;
		coll = new ObjectCollision();
		this.aniL = new Animation();
		this.aniR = new Animation();
		this.postAni = new Animation();
		this.isAvailable = true;
		dY = 0;
		yo = this.y-30;
		vo = 0;
		v = 0;
		timeY = 0;
		jumpCounter = 0;
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
	{
		super.init(gc, sbg);
		aniL = new CustomAnimation(ImageArrays.getBasicBadGuyL(),200).getAni();
		aniR = new CustomAnimation(ImageArrays.getBasicBadGuyR(),200).getAni();
		postAni = new CustomAnimation(ImageArrays.getBasicBadGuyPost(),200).getAni();
		postAni.setLooping(false);
		postAni.stop();

		aniL.setLooping(true);
		aniR.setLooping(true);
		leftHigh = new Point(x+Ints.D,y+1); leftHighPercept = new Point(x+Ints.D+1,y+1);
		leftMid = new Point(x+Ints.D,y+Ints.D); leftMidPercept = new Point(x+Ints.D+1, y+Ints.D);
		leftLow = new Point(x+Ints.D,y+(2*Ints.D)-1); leftLowPercept = new Point(x+Ints.D+1,y+(2*Ints.D)-1);
		
		rightHigh = new Point(x,y+1); rightHighPercept = new Point(x-1,y+1);
		rightMid = new Point(x,y+Ints.D); rightMidPercept = new Point(x-1, y+Ints.D);
		rightLow = new Point(x,y+(2*Ints.D)-1); rightLowPercept = new Point(x-1,y+(2*Ints.D)-1);
		
		bottomLeft = new Point(x+1,y+(2*Ints.D)); bottomLeftPercept = new Point(x+1,y+(2*Ints.D)+1);
		bottomRight = new Point(x+Ints.D-1,y+(2*Ints.D)); bottomRightPercept = new Point(x+Ints.D-1,y+(2*Ints.D)+1);
		
		topLeft = new Point(x+1,y); topLeftPercept = new Point(x+1,y-1);
		topRight = new Point(x+Ints.D-1,y); topRightPercept = new Point(x+Ints.D-1,y-1);
		
		vox = 0.0f;
		voy = 0.05f;
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
	{
		super.render(gc, sbg, g);
		super.getRec().setX(super.getX());
		super.getRec().setY(super.getY());
		
		if(!isAvailable) {
			if(dir > 0){
				aniL.draw(-2000, super.getY());
			}
			else{
				aniR.draw(-2000, super.getY());
			}
			postAni.draw(super.getX(),super.getY());
			super.getRec().setX(-2000);
		}
		if(isAvailable) {
			if(dir > 0) {
				aniL.draw(super.getX(), super.getY());
			}
			else {
				aniR.draw(super.getX(), super.getY());
			}
			postAni.draw(-2000,super.getY());
			super.getRec().setX(super.getX());
		}
		
//		g.setColor(Color.yellow);
//		g.fill(super.getRec());
		
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{
		super.update(gc, sbg, delta);
		nx = nx - ((vox)*(dir)*delta);
		
		if(GameFunc.isHitCheck(super.getRec(), Ints.COLLISION_FULL, false)){
			
			if(HeroState.getEffect() != HeroState.EFFECT_STARMAN) {
			   HeroState.decrementLives();
			   HeroState.setState(HeroState.STATE_DEAD);
			}

			   if(HeroState.getState() == HeroState.STATE_DEAD) {
				   if(HeroState.getLives() <= 0) {
					   sbg.enterState(GameState.GAMEOVERSTATE);
				   }
				   else {
					   sbg.enterState(GameState.STARTSTATE);
				   }  
			   }
		}
		
		Collision.checkCollisionBadguy(super.getRec());
		
		 jump(gc,delta);
		 if ((x < ScrRes.getWidth()+200) && vox == 0){
			 vox = -0.15f;
		 }
		 else {
			 vox = 0.0f;
		 }
		 
		 
		 counter += delta;
		 if (counter > 1000) {
			 if(coll.isFlagMidLeft() || coll.isFlagMidRight()) {
				 dir = -1*dir;
				 counter = 0;
			 }
		 } 
		 
		 if(super.isHit()) {
				if(isAvailable) {
					vox = 0.0f;
					postAni.restart();
					isAvailable = false;

				}
				else {
					vox = 0.0f;
					y = y+(delta*0.2f);

				}
			}
		
		leftHigh.setLocation(x+Ints.D,y+1); leftHighPercept.setLocation(x+Ints.D+1,y+1);
		leftMid.setLocation(x+Ints.D,y+Ints.D); leftMidPercept.setLocation(x+Ints.D+1, y+Ints.D);
		leftLow.setLocation(x+Ints.D,y+(2*Ints.D)-1); leftLowPercept.setLocation(x+Ints.D+1,y+(2*Ints.D)-1);
		rightHigh.setLocation(x,y+1); rightHighPercept.setLocation(x-1,y+1);
		rightMid.setLocation(x,y+Ints.D); rightMidPercept.setLocation(x-1, y+Ints.D);
		rightLow.setLocation(x,y+(2*Ints.D)-1); rightLowPercept.setLocation(x-1,y+(2*Ints.D)-1);
		bottomLeft.setLocation(x+10,y+(2*Ints.D)); bottomLeftPercept.setLocation(x+10,y+(2*Ints.D)+1);
		bottomRight.setLocation(x+Ints.D-10,y+(2*Ints.D)); bottomRightPercept.setLocation(x+Ints.D-10,y+(2*Ints.D)+1);
		topLeft.setLocation(x+1,y); topLeftPercept.setLocation(x+1,y-1);
		topRight.setLocation(x+Ints.D-1,y); topRightPercept.setLocation(x+Ints.D-1,y-1);
		
		coll.checkObjectCollision(RectangleList.getSolids(), this);
	}
	
	public void jump(GameContainer gc, int delta){
		if(getJumpTrigger() == true) {
			vo = 500;
		}
		jumpCounter = jumpCounter + delta;
		timeY = jumpCounter/1000;
		
		if (v < 0 && coll.isFlagBottomPartial()) {//on ground
			vo = 0;
			if (dY != yo && jumpCounter !=0) {
				yo = (int) (((dY/Ints.D)*Ints.D)/10);
				if (yo % 2 == 1) {
					yo = (yo - 1)*10;
				}
				else {
					yo = yo *10;
				}
				
				correctFloor(yo);//correction1
				dY = yo; y = dY;vo = 0;//correction2
		   }
		   jumpCounter = 0;
	    }
		
		else {
			v = vo + a*timeY;
			dY = -(((v))*timeY -0.5f*(a)*timeY*timeY)+yo;
			if(isAvailable)
			y = dY;
			if (timeY > 0) {
				setJumpTrigger(false);
			}
		}
		
	}//end jump
	
	private void correctFloor(float oldYo) {//correction3
		if (oldYo > 0 && oldYo < 40) {yo = 0;}
		if (oldYo > 40 && oldYo < 80) {yo = 40;}
		if (oldYo > 80 && oldYo < 120) {yo = 80;}
		if (oldYo > 120 && oldYo < 160) {yo = 120;}
		if (oldYo > 160 && oldYo < 200) {yo = 160;}
		if (oldYo > 200 && oldYo < 240) {yo = 200;}
		if (oldYo > 240 && oldYo < 280) {yo = 240;}
		if (oldYo > 280 && oldYo < 320) {yo = 280;}
		if (oldYo > 320 && oldYo < 360) {yo = 320;}
		if (oldYo > 360 && oldYo < 400) {yo = 360;}
		if (oldYo > 400 && oldYo < 440) {yo = 400;}
		if (oldYo > 440 && oldYo < 480) {yo = 440;}
		if (oldYo > 480 && oldYo < 520) {yo = 480;}
		if (oldYo > 520 && oldYo < 560) {yo = 520;}
		if (oldYo > 560 && oldYo < 600) {yo = 560;}
		if (oldYo > 600 && oldYo < 640) {yo = 600;}
		if (oldYo > 640 && oldYo < 680) {yo = 640;}
	}
	
}//[end BasicBadGuy]