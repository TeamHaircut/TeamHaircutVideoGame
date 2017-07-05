package supportclasses;

import javafx.scene.shape.Line;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Point;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.StateBasedGame;

import states.HeroState;
import animations.AnimateHero;
import animations.AnimationLoader;
import animations.CustomAnimation;
import arrays.HeroArrays;
import dimensions.Ints;

public class Hero {
	
	public static Rectangle rec;
	
	public static Line top;
	public static Line left;
	public static Line bottom;
	public static Line right;
	
	
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
	
	public static boolean lastTop;
	public static boolean lastLeft;
	public static boolean lastRight;
	public static boolean lastBottom;
	
	
	public Hero() {
		HeroState.setDirection(HeroState.RIGHT);
		HeroState.setAction(HeroState.ACTION_NONE);
		HeroState.setEffect(HeroState.EFFECT_NONE);
		lastDirection = HeroState.getDirection();
		lastAction = HeroState.getAction();
		lastEffect = HeroState.getEffect();
		
		lastTop = false;
		lastLeft = false;
		lastRight = false;
		lastBottom = false;
		
		
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
		rec = new Rectangle(dX,dY,Ints.D,Ints.D*2);
		
		top = new Line(dX+1,dY,dX+Ints.D-1,dY);
		left = new Line(dX+Ints.D,dY+1,dX+Ints.D,dY+(Ints.D*2)-1);
		bottom = new Line(dX+1,dY+(Ints.D*2),dX+Ints.D-1,dY+(Ints.D*2));
		right = new Line(dX,dY+1,dX,dY+(Ints.D*2)-1);
		
		ani = new CustomAnimation(HeroArrays.getDHnoneRn(),1000).getAni();
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
	{
		g.drawLine(dX+1,dY,dX+Ints.D-1,dY);
		g.drawLine(dX+Ints.D,dY+1,dX+Ints.D,dY+(Ints.D*2)-1);
		g.drawLine(dX+1,dY+(Ints.D*2),dX+Ints.D-1,dY+(Ints.D*2));
		g.drawLine(dX,dY+1,dX,dY+(Ints.D*2)-1);
		g.setLineWidth(1);
		g.setColor(Color.white);
		ani.draw(dX, dY);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{
		MoveHero.jump(gc,delta);
		
		if(!Collision.getFlagLeft()) {
			MoveHero.moveRight(gc,delta);
		}
		Collision.setFlagLeft(false);
		
		
		MoveHero.moveLeft(gc,delta);
		
		
		MoveHero.bounce();
		
		right.setStartX(dX);
		right.setStartY(dY+1);
		right.setEndX(dX);
		right.setEndY(dY+(Ints.D*2)-1);
		
		bottom.setStartX(dX+1);
		bottom.setStartY(dY+(Ints.D*2));
		bottom.setEndX(dX+Ints.D-1);
		bottom.setEndY(dY+(Ints.D*2));
		
		left.setStartX(dX+Ints.D);
		left.setStartY(dY+1);
		left.setEndX(dX+Ints.D);
		left.setEndY(dY+(Ints.D*2)-1);
		
		top.setStartX(dX+1);
		top.setStartY(dY);
		top.setEndX(dX+Ints.D-1);
		top.setEndY(dY);
		
		
		rec.setX(dX);
		rec.setY(dY);
		
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
