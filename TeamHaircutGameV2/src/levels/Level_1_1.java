package levels;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javagame.BackGroundImage;
import javagame.BadGuyBasic;
import javagame.BadGuyBasicDouble;
import javagame.BadGuyBeetle;
import javagame.BadGuyBullet;
import javagame.BadGuyEdge;
import javagame.BadGuyFireball;
import javagame.BadGuyFirerod;
import javagame.BadGuyFloat;
import javagame.BadGuyJump;
import javagame.BadGuyJumpDouble;
import javagame.BadGuyKnife;
import javagame.BadGuySpiny;
import javagame.Bullet;
import javagame.Duckcoin;
import javagame.Goal;
//import javagame.Hero;
import supportclasses.Hero;
import javagame.MysteryOneUp;
import javagame.MysteryStarMan;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import animations.CustomAnimation;
import arrays.ImageArrays;
import dimensions.Ints;
import states.Header;
import states.ScrRes;
import strings.Strings;
import supportclasses.BreakBox;
import supportclasses.Coin;
import supportclasses.CoinBox;
import supportclasses.HiddenBox;
import supportclasses.HiddenCoin;
import supportclasses.InvisibleBox;
import supportclasses.Item;
import supportclasses.LevelPlatformBuilder;
import supportclasses.LevelTileBuilder;
import supportclasses.Platform;
import supportclasses.RectangleList;
import supportclasses.Collision;
import supportclasses.PowerState;
import supportclasses.Tile;
//make change in prepstate to start on level1
public class Level_1_1 extends BasicGameState {
	
	private BackGroundImage bi;
	private LevelPlatformBuilder level1_Platforms;
	private LevelTileBuilder level1_Tiles;

	/*

	private MysteryOneUp hiddenoneup;
	private MysteryStarMan hiddenstarman;
	
	private BadGuyBasic bgBasic;
	private float[] bgx = {25,42,50,52,83,85,99,100,123,124,126,127,174,175};
	private float[] bgy = {9,9,9,9,1,9,9,9,9,9,9,9,9,9};
	private int b0 = bgx.length;
	
	private BadGuyJump bgJump;
	private float[] bgjx = {};/////////////////////////////////////////////////
	private float[] bgjy = {};////////////////////////////////////////////////
	private int b1 = bgjx.length;
	
	private BadGuyKnife bgKnife;
	private float[] bgkx = {109};
	private float[] bgky = {9};
	private int b2 = bgkx.length;
	
	private BadGuyEdge bgEdge;
	private float[] bgex = {};/////////////////////////////////////////////////
	private float[] bgey = {};////////////////////////////////////////////////
	private int b3 = bgex.length;
	
	private BadGuyFloat bgFloat;
	private float[] bgfx = {};/////////////////////////////////////////////////
	private float[] bgfy = {};////////////////////////////////////////////////
	private int b4 = bgfx.length;
	
	private BadGuyBeetle bgBeetle;
	private float[] bgbtx = {};/////////////////////////////////////////////////
	private float[] bgbty = {};////////////////////////////////////////////////
	private int b5 = bgbtx.length;
	
	private BadGuySpiny bgSpiny;
	private float[] bgsx = {};/////////////////////////////////////////////////
	private float[] bgsy = {};////////////////////////////////////////////////
	
	private BadGuyBullet bgBullet;
	private float[] bgblx = {};///////////////////////////////////////////////
	private float[] bgbly = {};///////////////////////////////////////////////
	private int b6 = bgblx.length;
	
	private BadGuyBasicDouble bgBDouble;
	private float[] bgbdx = {};///////////////////////////////////////////////
	private float[] bgbdy = {};///////////////////////////////////////////////
	private int b7 = bgbdx.length;
	
	private BadGuyJumpDouble bgJDouble;
	private float[] bgjdx = {};///////////////////////////////////////////////
	private float[] bgjdy = {};///////////////////////////////////////////////
	private int b8 = bgjdx.length;
	
	private BadGuyFireball bgFireball;
	private float[] bgfbx = {};///////////////////////////////////////////////
	private float[] bgfby = {};///////////////////////////////////////////////
	
	private BadGuyFirerod bgFirerod;
	private float[] bgfrx = {};///////////////////////////////////////////////
	private float[] bgfry = {};///////////////////////////////////////////////
	
//	private RectangleList mySolids = new RectangleList(c0 + c1 + c2 + c3 + c4 + c5 + c6 + c7 + c8 + b6 +1);//plus 1 from goal
	private RectangleList mySolids = new RectangleList(c0 + c2 + c3 + c4 + c5 + c6 + c7 + b6 +1);//plus 1 from goal
//	private RectangleList myBounds = new RectangleList(c1 + c2 + c3 + c4 + c5 + c6 +c7 + b6 );
	private RectangleList myBounds = new RectangleList(c2 + c3 + c4 + c5 + c6 +c7 + b6 );
	private RectangleList myBadGuys = new RectangleList(b0 + b1 + b2 + b3 + b4 + b5 + b6 + b7 +b8);
	*/
	private RectangleList mySolids;//plus 1 from goal//temp
	//private RectangleList myBadGuys = new RectangleList(b0 + b1 + b2 + b3 + b4 + b5 + b6 + b7 +b8);//temp
	private Hero hero;
	//Goal levelGoal;
	private Header hd;
	
	public Level_1_1(){
		bi = new BackGroundImage(Strings.LEVEL1_BI);
		
		/*
		barriers = new Barriers(obx,oby,80,400,"res/objects/barriers/tube/tube.png");
		powerbox = new ChangeTile(powerx,powery, powermyResource1, powermyResource2, new int[] {200,200,200} ,new int[] {200}, false);
		hiddenpowerups = new MysteryPowerUp(powerx,powery,powerbox);
		coins = new Duckcoin(dcx,dcy);
		hiddenoneup = new MysteryOneUp(mtx,mty,maketile,myBounds, mySolids);
		hiddenstarman = new MysteryStarMan(cbx,cby,changetile,myBounds,mySolids);
		bgBasic = new BadGuyBasic(bgx,bgy,myBounds, mySolids);
		bgJump = new BadGuyJump(bgjx,bgjy,myBounds, mySolids);
		bgKnife = new BadGuyKnife(bgkx,bgky,myBounds, mySolids);
		bgEdge = new BadGuyEdge(bgex,bgey,myBounds, mySolids);
		bgFloat = new BadGuyFloat(bgfx,bgfy,myBounds, mySolids);
		bgBeetle = new BadGuyBeetle(bgbtx,bgbty,myBounds, mySolids);
		bgSpiny = new BadGuySpiny(bgsx,bgsy,myBounds, mySolids);
		bgBullet = new BadGuyBullet(bgblx,bgbly,myBounds, mySolids, "short");
		bgBDouble = new BadGuyBasicDouble(bgbdx,bgbdy,myBounds, mySolids);
		bgJDouble = new BadGuyJumpDouble(bgjdx,bgjdy,myBounds, mySolids);
		bgFireball = new BadGuyFireball(bgfbx,bgfby,myBounds, mySolids, "short");
		bgFirerod = new BadGuyFirerod(bgfrx,bgfry,myBounds, mySolids);
		*/
		hero = new Hero();
		//levelGoal = new Goal(new float[] {204},new float[] {7});
		hd = new Header(400);
	}
   
	public void resetLevel(GameContainer gc, StateBasedGame sbg) throws SlickException
	   {
		/*
		hiddenoneup.reset(gc, sbg);
		hiddenstarman.reset(gc, sbg);
		coins.reset(gc, sbg);
		bgBasic.reset(gc, sbg);
		bgJump.reset(gc, sbg);
		bgKnife.reset(gc, sbg);
		bgEdge.reset(gc, sbg);
		bgFloat.reset(gc, sbg);
		bgBeetle.reset(gc, sbg);
		bgSpiny.reset(gc, sbg);
		bgBullet.reset(gc, sbg);
		bgBDouble.reset(gc,sbg);
		bgJDouble.reset(gc,sbg);
		bgFireball.reset(gc,sbg);
		bgFirerod.reset(gc,sbg);
		*/
		//hd.reset(gc, sbg);
	   }
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		
		bi.init(gc, sbg);
		
		Platform.count = 0;
		level1_Platforms = new LevelPlatformBuilder(new Platform[]{
				
				new Platform(0,toFloor(1),69,2,Strings.PLATFORM_BRICK),
				new Platform(73,toFloor(1),15,2,Strings.PLATFORM_BRICK),
				new Platform(92,toFloor(1),62,2,Strings.PLATFORM_BRICK),
				new Platform(156,toFloor(1),48,2,Strings.PLATFORM_BRICK),
				new Platform(207,toFloor(1),22,2,Strings.PLATFORM_BRICK),
				new Platform(136,toFloor(2),1,1,Strings.PLATFORM_BLOCK),
				new Platform(137,toFloor(3),1,2,Strings.PLATFORM_BLOCK),
				new Platform(138,toFloor(4),1,3,Strings.PLATFORM_BLOCK),
				new Platform(139,toFloor(5),1,4,Strings.PLATFORM_BLOCK),
				new Platform(142,toFloor(5),1,4,Strings.PLATFORM_BLOCK),
				new Platform(143,toFloor(4),1,3,Strings.PLATFORM_BLOCK),
				new Platform(144,toFloor(3),1,2,Strings.PLATFORM_BLOCK),
				new Platform(145,toFloor(2),1,1,Strings.PLATFORM_BLOCK),
				new Platform(150,toFloor(2),1,1,Strings.PLATFORM_BLOCK),
				new Platform(151,toFloor(3),1,2,Strings.PLATFORM_BLOCK),
				new Platform(152,toFloor(4),1,3,Strings.PLATFORM_BLOCK),
				new Platform(153,toFloor(5),1,4,Strings.PLATFORM_BLOCK),
				new Platform(156,toFloor(5),1,4,Strings.PLATFORM_BLOCK),
				new Platform(157,toFloor(4),1,3,Strings.PLATFORM_BLOCK),
				new Platform(158,toFloor(3),1,2,Strings.PLATFORM_BLOCK),
				new Platform(159,toFloor(2),1,1,Strings.PLATFORM_BLOCK),
				new Platform(182,toFloor(2),1,1,Strings.PLATFORM_BLOCK),
				new Platform(183,toFloor(3),1,2,Strings.PLATFORM_BLOCK),
				new Platform(184,toFloor(4),1,3,Strings.PLATFORM_BLOCK),
				new Platform(185,toFloor(5),1,4,Strings.PLATFORM_BLOCK),
				new Platform(186,toFloor(6),1,5,Strings.PLATFORM_BLOCK),
				new Platform(187,toFloor(7),1,6,Strings.PLATFORM_BLOCK),
				new Platform(188,toFloor(8),1,7,Strings.PLATFORM_BLOCK),
				new Platform(189,toFloor(9),1,8,Strings.PLATFORM_BLOCK),
				new Platform(190,toFloor(9),1,8,Strings.PLATFORM_BLOCK),
				new Platform(204,toFloor(1),3,2,Strings.PLATFORM_TELE),
				
				new Platform(29,toFloor(3),Strings.PLATFORM_TUBE),
				new Platform(39,toFloor(4),Strings.PLATFORM_TUBE),
				new Platform(47,toFloor(5),Strings.PLATFORM_TUBE),
				new Platform(58,toFloor(5),Strings.PLATFORM_TUBE),
				new Platform(164,toFloor(3),Strings.PLATFORM_TUBE),
				new Platform(180,toFloor(3),Strings.PLATFORM_TUBE),
				
				});
		
		
		
		Tile.count = 0;
		level1_Tiles = new LevelTileBuilder(new Tile[] {
	
				/*
				 * BREAK BLOCKS
				 */
				new BreakBox(20,5),new BreakBox(22,5),new BreakBox(24,5),new BreakBox(78,5),new BreakBox(80,5),
				new BreakBox(82,9),new BreakBox(83,9),new BreakBox(84,9),new BreakBox(85,9),new BreakBox(86,9),
				new BreakBox(87,9),new BreakBox(88,9),new BreakBox(89,9),new BreakBox(90,9),new BreakBox(91,9),
				new BreakBox(94,9),new BreakBox(95,9),new BreakBox(96,9),new BreakBox(97,9),new BreakBox(102,5),
				new BreakBox(120,5),new BreakBox(123,9),new BreakBox(124,9),new BreakBox(125,9),new BreakBox(130,9),
				new BreakBox(131,5),new BreakBox(132,5),new BreakBox(133,9),new BreakBox(168,5),new BreakBox(169,5),
				new BreakBox(171,5),
	
				/*
				 * CHANGE TILES		
				 */
				new CoinBox(17,5),
				new CoinBox(22,9),
				new CoinBox(21,5,Ints.ITEM_POWERUP),
				new CoinBox(23,5),
				new CoinBox(79,5,Ints.ITEM_POWERUP),
				new CoinBox(98,9),
				new CoinBox(98,5),
				new CoinBox(109,5),
				new CoinBox(112,5),
				new CoinBox(112,9,Ints.ITEM_POWERUP),
				new CoinBox(115,5),
				new CoinBox(131,9),
				new CoinBox(132,9),
				new CoinBox(170,5),
												
				/*
				 * MAKE TILES
				 */
				new InvisibleBox(64,5),//1up							
						
				/*
				 * STARMAN		
				 */
				new HiddenBox(103,5),//starman

				
				new Coin(87,5),
				new Coin(89,10),
				new Coin(199,10),
				new Coin(200,9),
				new Coin(200,8),
				new Coin(200,7),
				new Coin(201,6),
				new Coin(201,5),
				new Coin(201,4),
				

						
		}); 

		mySolids = new RectangleList(Platform.count + Tile.count);
		level1_Platforms.init(gc, sbg);
		level1_Tiles.init(gc, sbg);
			mySolids.addSolid(level1_Platforms.rec);
			mySolids.addSolid(level1_Tiles.rec);
//			myBounds.addSolid(myPlatforms.rec);
		/*

		hiddencoins.init(gc, sbg);
		powerbox.init(gc, sbg);
			mySolids.addSolid(powerbox.rec);
			myBounds.addSolid(powerbox.getRec2());

		hiddenoneup.init(gc, sbg);

		hiddenstarman.init(gc, sbg);
		bgBasic.init(gc, sbg);
			myBadGuys.addSolid(bgBasic.rec);
		bgJump.init(gc, sbg);
			myBadGuys.addSolid(bgJump.rec);
		bgKnife.init(gc, sbg);
			myBadGuys.addSolid(bgKnife.rec);
		bgEdge.init(gc, sbg);
			myBadGuys.addSolid(bgEdge.rec);
		bgFloat.init(gc, sbg);
			myBadGuys.addSolid(bgFloat.rec);
		bgBeetle.init(gc, sbg);
			myBadGuys.addSolid(bgBeetle.rec);
		bgSpiny.init(gc, sbg);
		bgBullet.init(gc, sbg);
			mySolids.addSolid(bgBullet.rec2);
			myBounds.addSolid(bgBullet.rec2);
			myBadGuys.addSolid(bgBullet.rec);
		bgBDouble.init(gc,sbg);
			myBadGuys.addSolid(bgBDouble.rec);
		bgJDouble.init(gc,sbg);
			myBadGuys.addSolid(bgJDouble.rec);
		bgFireball.init(gc,sbg);
		bgFirerod.init(gc,sbg);
		barriers.init(gc, sbg);
			mySolids.addSolid(barriers.rec);
			myBounds.addSolid(barriers.rec);
		coins.init(gc, sbg);
		*/
		hero.init(gc, sbg);
		//levelGoal.init(gc, sbg);
			//mySolids.addSolid(levelGoal.rec2);
		hd.init(gc, sbg);
	 }
   
   public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
	   bi.render(gc, sbg, g);
	   g.setBackground(new Color(127,131,231));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////RENDER OBJECTS//////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	   level1_Platforms.render(gc, sbg, g);
	   level1_Tiles.render(gc, sbg, g);
	   
	   
	   /*

	   powerbox.render(gc, sbg, g);
	   hiddenoneup.render(gc, sbg, g);
	   bgBasic.render(gc, sbg, g);
	   bgJump.render(gc, sbg, g);
	   bgKnife.render(gc, sbg, g);
	   bgEdge.render(gc, sbg, g);
	   bgFloat.render(gc, sbg, g);
	   bgBeetle.render(gc, sbg, g);
	   bgSpiny.render(gc, sbg, g);
	   bgBullet.render(gc, sbg, g);
	   bgBDouble.render(gc,sbg,g);
	   bgJDouble.render(gc,sbg,g);
	   bgFireball.render(gc,sbg,g);
	   bgFirerod.render(gc,sbg,g);
	   barriers.render(gc, sbg, g);
	   coins.render(gc, sbg, g);
	   */
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	   hero.render(gc, sbg, g);//hero
	   //hiddenstarman.render(gc, sbg, g);
	   //levelGoal.render(gc, sbg, g);//goal
	   hd.render(gc, sbg, g);//header
	}
   
   public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
	   
	   bi.update(gc, sbg, delta);//backdrop
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////UPDATE OBJECTS////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	   level1_Platforms.update(gc, sbg, delta);
	   level1_Tiles.update(gc, sbg, delta);
	   
	   
//	   telePlatforms.update(gc, sbg, delta);
//	   myVertPlatforms.update(gc, sbg, delta);
	   /*
	   powerbox.update(gc, sbg, delta);
	   hiddenoneup.update(gc, sbg, delta);
	   hiddenstarman.update(gc, sbg, delta);
	   bgBasic.update(gc, sbg, delta);
	   bgJump.update(gc, sbg, delta);
	   bgKnife.update(gc, sbg, delta);
	   bgEdge.update(gc, sbg, delta);
	   bgFloat.update(gc, sbg, delta);
	   bgBeetle.update(gc, sbg, delta);
	   bgSpiny.update(gc, sbg, delta);
	   bgBullet.update(gc, sbg, delta);
	   bgBDouble.update(gc,sbg, delta);
	   bgJDouble.update(gc,sbg, delta);
	   bgFireball.update(gc,sbg,delta);
	   bgFirerod.update(gc,sbg,delta);
	   barriers.update(gc, sbg, delta);
	   coins.update(gc, sbg, delta);
	   */
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	   hero.update(gc, sbg, delta);//hero
	   //levelGoal.update(gc, sbg, delta);//goal
	   hd.update(gc, sbg, delta);//header
	  
	    
	   /*******************************************************************************************************************/
	   ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////LEVEL RESET CONDITIONS/////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//	   if (Hero.downAHole||PowerState.getPowerUpState() <= 0)
//	   {
//		  //sbg.enterState(3);
//		  //resetLevel(gc,sbg);
//	   }
//	   Hero.downAHole = false;
	   
	   //if (levelGoal.rec[0].intersects(Hero.rec5)){Hero.reachedGoal = true;Hero.currentState = 5;Hero.world = "1-2";resetLevel(gc,sbg);}
	   
	   /*******************************************************************************************************************/
	   ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////COLLISION CONTROL//////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	   
	  // Bullet.collides = false;Bullet.collides = Bullet.checkCollisionB(mySolids.getSolids());if (Bullet.collides){Hero.bDone = true;}
	   //Bullet.collides1 = false;Bullet.collides1 = Bullet.checkCollisionB1(mySolids.getSolids());if (Bullet.collides1){Hero.tDone = true;}
	  // Bullet.collides2 = false;Bullet.collides2 = Bullet.checkCollisionB2(mySolids.getSolids());if (Bullet.collides2){Hero.fDone = true;}
	   
	   Collision.checkHeroCollision(mySolids.getSolids());

	  // Collision.checkHeroXCollision(mySolids.getSolids());
	   //Collision.checkCollisionBadguy(myBadGuys.getSolids());
	
   }//end update
   
   private float toFloor(int floor) {
	   return (ScrRes.getHeight()-(Ints.D*floor))/Ints.D;
   }
   
   
   public int getID(){
      return 1;
   }
   
}//end class level1






