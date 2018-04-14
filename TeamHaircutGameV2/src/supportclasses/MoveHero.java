package supportclasses;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

import dimensions.Ints;
import states.HeroState;

public class MoveHero {
	private final static float a = -750f;//-750
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
			//			   if (input.isKeyDown(Input.KEY_A))
			//			   {
			//				   if (Hero.dX > 0)
			//					   {vox = 0.25f;
			//					   Hero.dX -= (vox) * delta;}
			//		    	   else 
			//		    		   {vox = 0;
			//		    		   Hero.dX += vox *delta;} 
						   
			//				   Hero.direction = false;
			//				   if(Collision.getFlagBottom()==true)
			//				   {
			//					   if (HeroState.getIndex()==1)
			//					   {
			//						   if (PowerState.getPowerUpState() == 2 && !Hero.invinsable)
			//							   Hero.heroAni = Hero.SDHwalkL;
			//						   else if(PowerState.getPowerUpState() == 2 && Hero.invinsable)
			//							   Hero.heroAni = Hero.SDHwalkLi;
			//						   else if(PowerState.getPowerUpState() == 1 && Hero.invinsable)
			//							   Hero.heroAni = Hero.DHwalkLi;
			//						   else Hero.heroAni = Hero.DHwalkL;
			//					   }
			//					   else
			//					   {
			//						   if (PowerState.getPowerUpState() == 2)
			//							   Hero.heroAni = Hero.SDSwalkL;
			//						   else Hero.heroAni = Hero.DSwalkL;  
			//					   }
			//				   }
			//				   
			//			   }
			//			}
			//		   else//if collidesLeft
			//		   {	Hero.recBottom.setLocation(Hero.dX+10,Hero.dY+70);
			//		   Hero.recBottom.setSize(28,10);
			//		   vox = 0;
			//		   Hero.dX += vox *delta;
			}
//		else {
//			   if(HeroState.getAction() != HeroState.ACTION_JUMP) {
//			   HeroState.setAction(HeroState.ACTION_NONE);
//			   }
//		}
		}
		
	}//end move left
	
	
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
		//				   Hero.direction = true;
		//				   if(Collision.getFlagBottom()== true)
		//				   {
		//					   if (HeroState.getIndex()==1)
		//					   {
		//						   if (PowerState.getPowerUpState() == 2 && !Hero.invinsable)
		//							   Hero.heroAni = Hero.SDHwalkR;
		//						   else if(PowerState.getPowerUpState() == 2 && Hero.invinsable)
		//							   Hero.heroAni = Hero.SDHwalkRi;
		//						   else if(PowerState.getPowerUpState() == 1 && Hero.invinsable)
		//							   Hero.heroAni = Hero.DHwalkRi;
		//						   else Hero.heroAni = Hero.DHwalkR;
		//					   }
		//					   else
		//					   {
		//						   if (PowerState.getPowerUpState() == 2)
		//							   Hero.heroAni = Hero.SDSwalkR;
		//						   else Hero.heroAni = Hero.DSwalkR;  
		//					   }
		//				   }	   
			}
//			else {
//				if(HeroState.getAction() != HeroState.ACTION_JUMP) {
//					HeroState.setAction(HeroState.ACTION_NONE);
//				}
//			}
	//			}
	//		   else //if collidesRight
	//		   {
	//			   Hero.recBottom.setLocation(Hero.dX,Hero.dY+70);
	//			   Hero.recBottom.setSize(28, 10);
	//			   
	//			   vox = 0; Hero.dX += (vox) * delta; 
	//			   if (input.isKeyDown(Input.KEY_D))
	//			   		{Hero.nx = Hero.nx - ((vox)*delta);}
	//			}
		}

	}//end move right
		   
	//	public static void jump(GameContainer gc, int delta) {
	//		Input input = gc.getInput();
	//		
	//		if (Hero.jumpTrigger) {
	//			Hero.vo = 40;//500
	//			Hero.dY--;
	//		}
	//		
	//		if(!Collision.isCollides()) {
	//			Hero.yo = Hero.dY;
	//			if(Hero.jumpTrigger) {
	//				Hero.jumpTrigger = false;
	//			}
	//		}
	//		
	//		if(Collision.isCollides()) {
	//			Hero.vo = 0;
	//			
	//			Hero.dY = Hero.yo;
	////			   if (Hero.dY != Hero.yo && Hero.jumpCounter !=0)
	////			   {
	////				   Hero.yo = (int) (((Hero.dY/40)*40)/10);
	////				   if (Hero.yo % 2 == 1)
	////				   {
	////					   Hero.yo = (Hero.yo - 1)*10;
	////				   }
	////				   else Hero.yo = Hero.yo *10;
	////			   
	////				   Hero.dY =Hero.yo; Hero.vo = 0;
	////			   }
	//			   Hero.jumpCounter = 0;
	//			   if(input.isKeyPressed(Input.KEY_L)) {
	//					Hero.jumpTrigger = true;
	//				}
	//		}
	//		
	//	    Hero.jumpCounter = Hero.jumpCounter + delta;
	//	    Hero.timeY = Hero.jumpCounter/1000;
	//	   
	//	    Hero.v = Hero.vo + a*Hero.timeY;
	//	    Hero.dY = -(((Hero.v))*Hero.timeY -0.5f*(a)*Hero.timeY*Hero.timeY)+Hero.yo;
	////	    if (Hero.timeY > 0) {
	////		    Hero.jumpTrigger = false;
	////	   }
	//		
	//	}//end jump
	
	public static void bounce() {
		if(HeroState.getAction() == HeroState.ACTION_JUMP) {
			if (Collision.getFlagTop() == true){
		   		Hero.timeY = 0;
		   		Hero.jumpCounter = 0;
		   		Hero.vo = -300;
		   		Hero.v = 0;
		   		Hero.yo = Hero.dY;	
		   	}
		}
	}
	
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
			
	//			   if (HeroState.getIndex()==1)
	//				   if (Hero.direction)
	//				   {
	//					   if (PowerState.getPowerUpState() == 2 && !Hero.invinsable)
	//						   Hero.heroAni = Hero.SDHjumpR;
	//					   else if(PowerState.getPowerUpState() == 2 && Hero.invinsable)
	//						   Hero.heroAni = Hero.SDHjumpRi;
	//					   else if(PowerState.getPowerUpState() == 1 && Hero.invinsable)
	//						   Hero.heroAni = Hero.DHjumpRi;
	//					   else Hero.heroAni = Hero.DHjumpR;
	//				   }
	//				   else
	//				   {
	//					   if (PowerState.getPowerUpState() == 2 && !Hero.invinsable)
	//						   Hero.heroAni = Hero.SDHjumpL;
	//					   else if(PowerState.getPowerUpState() == 2 && Hero.invinsable)
	//						   Hero.heroAni = Hero.SDHjumpLi;
	//					   else if(PowerState.getPowerUpState() == 1 && Hero.invinsable)
	//						   Hero.heroAni = Hero.DHjumpLi;
	//					   else Hero.heroAni = Hero.DHjumpL;
	//				   }
	//			   else 
	//			   {
	//				   if (Hero.direction)
	//				   {
	//					   if (PowerState.getPowerUpState() == 2)
	//						   Hero.heroAni = Hero.SDSjumpR;
	//					   else Hero.heroAni = Hero.DSjumpR;
	//				   }
	//				   else
	//				   {
	//					   if (PowerState.getPowerUpState() == 2)
	//						   Hero.heroAni = Hero.SDSjumpL;
	//					   else Hero.heroAni = Hero.DSjumpL;
	//				   }
	//			   }
			
			Hero.v = Hero.vo + a*Hero.timeY;
			Hero.dY = -(((Hero.v))*Hero.timeY -0.5f*(a)*Hero.timeY*Hero.timeY)+Hero.yo;
			if (Hero.timeY > 0) {
				Hero.jumpTrigger = false;
			}
		}
		if(Hero.dY > Hero.yo+1) {
			HeroState.setAction(HeroState.ACTION_JUMP);
		}
		
	}//end jump
	
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
	
	
}
