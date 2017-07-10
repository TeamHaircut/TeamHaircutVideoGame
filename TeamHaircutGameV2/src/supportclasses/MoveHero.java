package supportclasses;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

import dimensions.Ints;
import states.HeroState;

public class MoveHero {
	private final static float a = -750f;//-850
	private static float vox;
	
	public static void moveLeft(GameContainer gc, int delta){
		
		Input input = gc.getInput();
		if(!Collision.getFlagRight()) {
		//		   if (Collision.getFlagLeft() == false)//l
		//		   {
		//			    Hero.recBottom.setLocation(Hero.dX+4,Hero.dY+70);
		
		if (input.isKeyDown(Input.KEY_A)) {
			HeroState.setDirection(HeroState.LEFT);
			if(HeroState.getAction() != HeroState.ACTION_JUMP) {   
			   if(input.isKeyDown(Input.KEY_D)) {
				   HeroState.setAction(HeroState.ACTION_NONE);
			   }
			   else {
				   HeroState.setAction(HeroState.ACTION_WALK);
			   }
			}
			if(Hero.dX > 0) {
				vox = 0.25f;
				Hero.dX -= (vox) * delta;
			}
			else {
				vox = 0;
				Hero.dX += vox * delta;
				HeroState.setAction(HeroState.ACTION_NONE);
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
				if(HeroState.getAction() != HeroState.ACTION_JUMP) {
					if(input.isKeyDown(Input.KEY_A)) {
						HeroState.setAction(HeroState.ACTION_NONE);
					}
					else {
						HeroState.setAction(HeroState.ACTION_WALK);
					}
				}
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
		if (Collision.getFlagTop() == true){
	   		Hero.timeY = 0;
	   		Hero.jumpCounter = 0;
	   		Hero.vo = -300;
	   		Hero.v = 0;
	   		Hero.yo = Hero.dY;	
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
				Hero.dY =Hero.yo; Hero.vo = 0;
		   }
		   Hero.jumpCounter = 0;
		   if(input.isKeyPressed(Input.KEY_L)	) {
			   
			   if(Collision.getFlagLeft() && Collision.isFlagBottomFull()) {
				   Hero.jumpTrigger = true;Hero.isJumping=true; HeroState.setAction(HeroState.ACTION_JUMP);
			   }
			   
			   if(Collision.getFlagRight() && Collision.isFlagBottomFull()) {
				   Hero.jumpTrigger = true;Hero.isJumping=true; HeroState.setAction(HeroState.ACTION_JUMP);
			   }
			   
			   if(!Collision.getFlagLeft() && !Collision.getFlagRight() && Collision.isFlagBottomPartial()) {
				   Hero.jumpTrigger = true;Hero.isJumping=true; HeroState.setAction(HeroState.ACTION_JUMP);
			   }
		   }
	    }
		else {//in air

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
	}//end jump
	
	
}
