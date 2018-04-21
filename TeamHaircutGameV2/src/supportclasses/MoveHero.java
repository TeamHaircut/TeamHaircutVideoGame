//	www.teamhaircut.org
package supportclasses;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

import dimensions.Ints;
import states.HeroState;
import supportclasses.Bullet;

public class MoveHero {
	//gravitational acceleration
	private final static float a = -750f;
	
	private static float vox;
	
	public static void checkMoving(GameContainer gc) {
		Input input = gc.getInput();
		if(HeroState.getAction() != HeroState.ACTION_JUMP) {
			if (	(input.isKeyDown(Input.KEY_A) || input.isKeyDown(Input.KEY_D)) &&
					!(input.isKeyDown(Input.KEY_A) && input.isKeyDown(Input.KEY_D))	
			) {
				HeroState.setAction(HeroState.ACTION_WALK);
			}
			else {
				HeroState.setAction(HeroState.ACTION_NONE);
			}
		}
	}
	
	public static void moveLeft(GameContainer gc, int delta){
		Input input = gc.getInput();
		if(!Collision.getFlagRight()) {	
			if (input.isKeyDown(Input.KEY_A)) {
				HeroState.setDirection(HeroState.LEFT);
				if(Hero.dX > 0) {
					vox = 0.25f;
					Hero.dX -= (vox) * delta;
				}
				else {
					vox = 0;
					Hero.dX += vox * delta;
				}		
			}
		}
	}//[end moveLeft(...)]
	
	
	public static void moveRight(GameContainer gc, int delta){
		Input input = gc.getInput();
		if(!Collision.getFlagLeft()) {
			if (input.isKeyDown(Input.KEY_D)) {
				HeroState.setDirection(HeroState.RIGHT);
				if (Hero.dX < 350) {
					vox = 0.25f;
					Hero.dX += (vox) * delta;
				}
				else {
					vox = 0.25f;
					Ints.NX = Ints.NX - ((vox)*delta);
				}		   
			}
		}
	}//[end moveRight(...)]
	
	public static void bounceDown() {
		if(HeroState.getAction() == HeroState.ACTION_JUMP) {
			if (Collision.getFlagTop() == true){
		   		Hero.timeY = 0;
		   		Hero.jumpCounter = 0;
		   		Hero.vo = -300;
		   		Hero.v = 0;
		   		Hero.yo = Hero.dY;	
		   	}
		}
	}//[end bounceDown()]
	
	public static void bounceUp() {
		if(HeroState.getAction() == HeroState.ACTION_JUMP) {
			if (Collision.getFlagBadGuy() == true){
		   		Hero.timeY = 0;
		   		Hero.jumpCounter = 0;
		   		Hero.vo = +400;
		   		Hero.v = 0;
		   		Hero.yo = Hero.dY;
		   		Collision.setFlagBadGuy(false);
		   	}
		}
	}//[end bounceUp()]
	
	public static void jump(GameContainer gc, int delta){
		
		Input input = gc.getInput();
		if (Hero.jumpTrigger) {
			Hero.vo = 500;Hero.dY--;
			
		}
		Hero.jumpCounter = Hero.jumpCounter + delta;
		Hero.timeY = Hero.jumpCounter/1000;
		
		if (Collision.isFlagBottomPartial()) {//on ground
			if(HeroState.getAction() == HeroState.ACTION_JUMP) {
				HeroState.setAction(HeroState.ACTION_NONE);
			}
			Hero.vo = 0;
			if (Hero.dY != Hero.yo && Hero.jumpCounter !=0) {
				Hero.yo = (int) (((Hero.dY/Ints.D)*Ints.D)/10);
				if (Hero.yo % 2 == 1) {
					Hero.yo = (Hero.yo - 1)*10;
				}
				else {
					Hero.yo = Hero.yo *10;
				}
				MoveHero.correctFloor(Hero.yo);

				Hero.dY =Hero.yo;  Hero.vo = 0;
		   }
		   Hero.jumpCounter = 0;
		   if(input.isKeyPressed(Input.KEY_L)	) {
			   if(Collision.getFlagLeft() && Collision.isFlagBottomFull()) {
				   Hero.jumpTrigger = true;Hero.isJumping=true; 
				   HeroState.setAction(HeroState.ACTION_JUMP);
			   }
			   
			   if(Collision.getFlagRight() && Collision.isFlagBottomFull()) {
				   Hero.jumpTrigger = true;Hero.isJumping=true; 
				   HeroState.setAction(HeroState.ACTION_JUMP);
			   }
			   
			   if(!Collision.getFlagLeft() && !Collision.getFlagRight() && Collision.isFlagBottomPartial()) {
				   Hero.jumpTrigger = true;Hero.isJumping=true; 
				   HeroState.setAction(HeroState.ACTION_JUMP);
			   }
		   }
	    }
		else {	
			Hero.v = Hero.vo + a*Hero.timeY;
			Hero.dY = -(((Hero.v))*Hero.timeY -0.5f*(a)*Hero.timeY*Hero.timeY)+Hero.yo;
			if (Hero.timeY > 0) {
				Hero.jumpTrigger = false;
			}
		}
		if(Hero.dY > Hero.yo+1) {
			HeroState.setAction(HeroState.ACTION_JUMP);
		}
		
	}//[end jump(...)]
	
	public static void spawnBullet(GameContainer gc, int delta) {
		Input input = gc.getInput();	
		Hero.item.setX((Hero.dX));
		Hero.item.setY((Hero.dY));
			if (input.isKeyDown(Input.KEY_SPACE)) {
				
				Hero.item.vox = 0.6f;
				((Bullet) Hero.item).isShot = true;
			}
	}
	
	private static void correctFloor(float oldYo) {
		if (oldYo > 0 && oldYo < 40) {Hero.yo = 0;}
		if (oldYo > 40 && oldYo < 80) {Hero.yo = 40;}
		if (oldYo > 80 && oldYo < 120) {Hero.yo = 80;}
		if (oldYo > 120 && oldYo < 160) {Hero.yo = 120;}
		if (oldYo > 160 && oldYo < 200) {Hero.yo = 160;}
		if (oldYo > 200 && oldYo < 240) {Hero.yo = 200;}
		if (oldYo > 240 && oldYo < 280) {Hero.yo = 240;}
		if (oldYo > 280 && oldYo < 320) {Hero.yo = 280;}
		if (oldYo > 320 && oldYo < 360) {Hero.yo = 320;}
		if (oldYo > 360 && oldYo < 400) {Hero.yo = 360;}
		if (oldYo > 400 && oldYo < 440) {Hero.yo = 400;}
		if (oldYo > 440 && oldYo < 480) {Hero.yo = 440;}
		if (oldYo > 480 && oldYo < 520) {Hero.yo = 480;}
		if (oldYo > 520 && oldYo < 560) {Hero.yo = 520;}
		if (oldYo > 560 && oldYo < 600) {Hero.yo = 560;}
		if (oldYo > 600 && oldYo < 640) {Hero.yo = 600;}
		if (oldYo > 640 && oldYo < 680) {Hero.yo = 640;}
	}
}//[end MoveHero]