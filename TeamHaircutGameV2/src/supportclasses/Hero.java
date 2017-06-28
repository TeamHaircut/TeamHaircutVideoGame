package supportclasses;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

import animations.CustomAnimation;
import arrays.HeroArrays;
import dimensions.Ints;

public class Hero {
	
	public static Rectangle rec;
	private Animation ani;
	
	public static boolean isJumping;
	
	public static float dX;
	public static float dY;
	
	public static float vo;
	public static float v;
	public static float timeY;
	public static float jumpCounter;
	public static float yo;
	public static boolean jumpTrigger;
	
	public Hero() {
		
		isJumping = false;
		
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
		rec = new Rectangle(dX,dY,Ints.D,Ints.D*2);
		ani = new CustomAnimation(HeroArrays.getDHfaceR(),1000).getAni();
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
		
		
		System.out.println("jumping "+isJumping);
		
		System.out.print("| dx "+dX);
		System.out.print("| dy "+dY);
		
		System.out.print("| vo "+vo);
		System.out.print("| v "+v);
		System.out.print("| time y "+timeY);
		System.out.print("| counter "+jumpCounter);
		System.out.print("| yo "+yo);
		System.out.print("| trigger "+jumpTrigger);
		
	}
	

}
