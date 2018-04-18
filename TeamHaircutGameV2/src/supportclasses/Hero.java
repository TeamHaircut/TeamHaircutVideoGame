package supportclasses;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Point;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

import states.HeroState;
import animations.AnimateHero;
import animations.AnimationLoader;
import animations.CustomAnimation;
import arrays.HeroArrays;
import dimensions.Ints;

public class Hero {
	
	public static Rectangle rec;
	public static Rectangle bottomRec;
		
	public static Point leftHigh;
	public static Point leftMid;
	public static Point leftLow;
	public static Point leftHighPercept;
	public static Point leftMidPercept;
	public static Point leftLowPercept;
	
	public static Point rightHigh;
	public static Point rightMid;
	public static Point rightLow;
	public static Point rightHighPercept;
	public static Point rightMidPercept;
	public static Point rightLowPercept;
	
	public static Point bottomLeft;
	public static Point bottomRight;
	public static Point bottomLeftPercept;
	public static Point bottomRightPercept;
	
	public static Point topLeft;
	public static Point topRight;
	public static Point topLeftPercept;
	public static Point topRightPercept;
	
	private static Animation ani;
	
	public static float dX;
	public static float dY;
	
	public static float vo;
	public static float v;
	public static float timeY;
	public static float jumpCounter;
	public static float yo;
	public static boolean jumpTrigger;
	
	public static boolean isJumping;
	
	private int lastDirection;
	private int lastAction;
	private int lastEffect;
	
	//
	//public static Rectangle vrec;
	//public static float vheight;
	//
	
	public Hero() {
		HeroState.setDirection(HeroState.RIGHT);
		HeroState.setAction(HeroState.ACTION_NONE);
		HeroState.setEffect(HeroState.EFFECT_NONE);
		lastDirection = HeroState.getDirection();
		lastAction = HeroState.getAction();
		lastEffect = HeroState.getEffect();
		
		isJumping = true;
		dY = 0;
		dX = 6*Ints.D;
		yo = 6*Ints.D;
		Ints.NX = dX;
		
		vo = 0;
		v = 0;
		timeY = 0;
		jumpCounter = 0;
		
		jumpTrigger = false;
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
	{
		AnimationLoader.getAniMap();
		rec = new Rectangle(dX,dY,Ints.D,(Ints.D*2)-20);
		bottomRec = new Rectangle(dX+10, dY+60, 20,20);
		//vrec = new Rectangle(dX,dY+(Ints.D*2),Ints.D,vheight);
		
		leftHigh = new Point(dX+Ints.D,dY+1); leftHighPercept = new Point(dX+Ints.D+1,dY+1);
		leftMid = new Point(dX+Ints.D,dY+Ints.D); leftMidPercept = new Point(dX+Ints.D+1, dY+Ints.D);
		leftLow = new Point(dX+Ints.D,dY+(2*Ints.D)-1); leftLowPercept = new Point(dX+Ints.D+1,dY+(2*Ints.D)-1);
		
		rightHigh = new Point(dX,dY+1); rightHighPercept = new Point(dX-1,dY+1);
		rightMid = new Point(dX,dY+Ints.D); rightMidPercept = new Point(dX-1, dY+Ints.D);
		rightLow = new Point(dX,dY+(2*Ints.D)-1); rightLowPercept = new Point(dX-1,dY+(2*Ints.D)-1);
		
		bottomLeft = new Point(dX+1,dY+(2*Ints.D)); bottomLeftPercept = new Point(dX+1,dY+(2*Ints.D)+1);
		bottomRight = new Point(dX+Ints.D-1,dY+(2*Ints.D)); bottomRightPercept = new Point(dX+Ints.D-1,dY+(2*Ints.D)+1);
		
		topLeft = new Point(dX+1,dY); topLeftPercept = new Point(dX+1,dY-1);
		topRight = new Point(dX+Ints.D-1,dY); topRightPercept = new Point(dX+Ints.D-1,dY-1);
		
		ani = new CustomAnimation(HeroArrays.getDHnoneRn(),1000).getAni();
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
	{
		ani.draw(dX, dY);
		
		
//		g.setColor(Color.white);
//		g.fill(rec);
//		g.setColor(Color.red);
//		g.fill(bottomRec);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{
		MoveHero.checkMoving(gc);
		MoveHero.jump(gc,delta);
		MoveHero.moveRight(gc,delta);
		MoveHero.moveLeft(gc,delta);
		MoveHero.bounceDown();
		MoveHero.bounceUp();
		
		
		leftHigh.setLocation(dX+Ints.D,dY+1); leftHighPercept.setLocation(dX+Ints.D+1,dY+1);
		leftMid.setLocation(dX+Ints.D,dY+Ints.D); leftMidPercept.setLocation(dX+Ints.D+1, dY+Ints.D);
		leftLow.setLocation(dX+Ints.D,dY+(2*Ints.D)-1); leftLowPercept.setLocation(dX+Ints.D+1,dY+(2*Ints.D)-1);
		
		rightHigh.setLocation(dX,dY+1); rightHighPercept.setLocation(dX-1,dY+1);
		rightMid.setLocation(dX,dY+Ints.D); rightMidPercept.setLocation(dX-1, dY+Ints.D);
		rightLow.setLocation(dX,dY+(2*Ints.D)-1); rightLowPercept.setLocation(dX-1,dY+(2*Ints.D)-1);
			
		bottomLeft.setLocation(dX+10,dY+(2*Ints.D)); bottomLeftPercept.setLocation(dX+10,dY+(2*Ints.D)+1);
		bottomRight.setLocation(dX+Ints.D-10,dY+(2*Ints.D)); bottomRightPercept.setLocation(dX+Ints.D-10,dY+(2*Ints.D)+1);
		
		topLeft.setLocation(dX+1,dY); topLeftPercept.setLocation(dX+1,dY-1);
		topRight.setLocation(dX+Ints.D-1,dY); topRightPercept.setLocation(dX+Ints.D-1,dY-1);
		
		rec.setX(dX);
		rec.setY(dY);
		
		bottomRec.setX(dX+10);
		bottomRec.setY(dY+60);
		
		//vrec.setX(dX);
		//vrec.setY(dY+(Ints.D*2));
		//vrec.setHeight(vheight);
		
		
		if(	lastDirection != HeroState.getDirection() || 
			lastAction != HeroState.getAction() ||
			lastEffect != HeroState.getEffect()) {
		ani = AnimateHero.getHeroAni(ani);
		lastDirection = HeroState.getDirection();
		lastAction = HeroState.getAction();
		lastEffect = HeroState.getEffect();
		}
		
	}
	
}
