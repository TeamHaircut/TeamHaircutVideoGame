package supportclasses;

import java.util.Map;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
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
	public static Animation ani;
	//private CustomAnimation ca;
	
	
	
	public static float dX;
	public static float dY;
	
	public static float vo;
	public static float v;
	public static float timeY;
	public static float jumpCounter;
	public static float yo;
	public static boolean jumpTrigger;
	
	public static boolean isJumping;
	
	private Map<String, Animation> heroAnimationMap;
	private AnimationLoader AL;
	
	
	public Hero() {
		HeroState.setDirection(HeroState.RIGHT);
		HeroState.setAction(HeroState.ACTION_NONE);
		HeroState.setEffect(HeroState.EFFECT_NONE);
		
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
		AL = new AnimationLoader();
		heroAnimationMap = AnimationLoader.getAniMap();
		
		rec = new Rectangle(dX,dY,Ints.D,Ints.D*2);
		if(ani != null)
		ani = new Animation(HeroArrays.getDHnoneRn(),1000);
		//ca = new CustomAnimation(HeroArrays.getDHnoneRn(),1000);
		//HeroArrays.HeroAni = HeroArrays.getDHnoneRn();
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
	{
		g.fill(rec);
		g.setColor(Color.white);
		ani.draw(dX, dY);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{
		MoveHero.jump(gc,delta);
		MoveHero.moveRight(gc,delta);
		MoveHero.moveLeft(gc,delta);
		rec.setX(dX);
		rec.setY(dY);
		
		
		ani = AnimateHero.getHeroAni();

//		
//		
//		
//		System.out.println("jumping "+isJumping);
//		
//		System.out.print("| dx "+dX);
//		System.out.print("| dy "+dY);
//		
//		System.out.print("| vo "+vo);
//		System.out.print("| v "+v);
//		System.out.print("| time y "+timeY);
//		System.out.print("| counter "+jumpCounter);
//		System.out.print("| yo "+yo);
//		System.out.print("| trigger "+jumpTrigger);
		
	}
	

}
