package supportclasses;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
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
	
	
	public Hero() {
		HeroState.setDirection(HeroState.RIGHT);
		HeroState.setAction(HeroState.ACTION_NONE);
		HeroState.setEffect(HeroState.EFFECT_NONE);
		lastDirection = HeroState.getDirection();
		lastAction = HeroState.getAction();
		lastEffect = HeroState.getEffect();
		
		isJumping = true;
		
		dX = 6*Ints.D;
		dY = 6*Ints.D;
		Ints.NX = dX;
		
		vo = 0;
		v = 0;
		timeY = 0;
		jumpCounter = 0;
		yo = 0;
		jumpTrigger = false;
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
	{
		AnimationLoader.getAniMap();
		rec = new Rectangle(dX,dY,Ints.D,Ints.D*2);
		ani = new CustomAnimation(HeroArrays.getDHnoneRn(),1000).getAni();
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
	{
		ani.draw(dX, dY);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{
		MoveHero.jump(gc,delta);
		MoveHero.moveRight(gc,delta);
		MoveHero.moveLeft(gc,delta);
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
