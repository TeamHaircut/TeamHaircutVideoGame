//	www.teamhaircut.org
package levels;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
//import javagame.Bullet;
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
import states.GameState;
import states.Header;
import states.HeroState;
import states.ScrRes;
import strings.Strings;
import supportclasses.BackGroundImage;
import supportclasses.BasicBadGuy;
import supportclasses.BreakBox;
import supportclasses.Bullet;
import supportclasses.BulletList;
import supportclasses.Coin;
import supportclasses.CoinBox;
import supportclasses.HiddenBox;
import supportclasses.HiddenCoin;
import supportclasses.InvisibleBox;
import supportclasses.Item;
import supportclasses.LevelItemBuilder;
import supportclasses.LevelPlatformBuilder;
import supportclasses.LevelTileBuilder;
import supportclasses.Platform;
import supportclasses.RectangleList;
import supportclasses.Collision;
import supportclasses.PowerState;
import supportclasses.Tile;
//make change in prepstate to start on level1
public class Level_1_2 extends BasicGameState {
	
	private BackGroundImage bi;
	private LevelPlatformBuilder level2_Platforms;
	private LevelTileBuilder level2_Tiles;
	private LevelItemBuilder level2_Items;

	private Hero hero;
	private Header hd;
	
	
	public Level_1_2(){
		bi = new BackGroundImage(Strings.LEVEL2_BI, -569);
		hd = new Header(Ints.LEVEL_1_1_TIME);
	}
   
	public void resetLevel(GameContainer gc, StateBasedGame sbg) throws SlickException
	   {

	   }
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		hero = new Hero();
		bi.init(gc, sbg);
		
		Platform.count = 0;
		level2_Platforms = new LevelPlatformBuilder(new Platform[]{
				
				//new Platform(29,toFloor(3),Strings.PLATFORM_TUBE),
				//new Platform(39,toFloor(4),Strings.PLATFORM_TUBE),
				//new Platform(47,toFloor(5),Strings.PLATFORM_TUBE),
				//new Platform(58,toFloor(5),Strings.PLATFORM_TUBE),
				//new Platform(164,toFloor(3),Strings.PLATFORM_TUBE),
				//new Platform(180,toFloor(3),Strings.PLATFORM_TUBE),
				
				new Platform(0,toFloor(1),83,2,Strings.PLATFORM_BRICK),//_BRICK, BLOCK,TUBE
				new Platform(87,toFloor(1),36,2,Strings.PLATFORM_BRICK),
				new Platform(125,toFloor(1),2,2,Strings.PLATFORM_BRICK),
				new Platform(129,toFloor(1),13,1,Strings.PLATFORM_BRICK),
				new Platform(149,toFloor(1),8,2,Strings.PLATFORM_BRICK),
				new Platform(164,toFloor(1),33,2,Strings.PLATFORM_BRICK),
				new Platform(20,toFloor(2),1,1,Strings.PLATFORM_BLOCK),
				new Platform(22,toFloor(3),1,2,Strings.PLATFORM_BLOCK),
				new Platform(24,toFloor(4),1,3,Strings.PLATFORM_BLOCK),
				new Platform(26,toFloor(5),1,4,Strings.PLATFORM_BLOCK),
				new Platform(28,toFloor(5),1,4,Strings.PLATFORM_BLOCK),
				new Platform(30,toFloor(4),1,3,Strings.PLATFORM_BLOCK),
				new Platform(34,toFloor(4),1,3,Strings.PLATFORM_BLOCK),
				new Platform(36,toFloor(3),1,2,Strings.PLATFORM_BLOCK),
				new Platform(137,toFloor(2),1,1,Strings.PLATFORM_BLOCK),
				new Platform(138,toFloor(3),1,2,Strings.PLATFORM_BLOCK),
				new Platform(139,toFloor(4),1,3,Strings.PLATFORM_BLOCK),
				new Platform(140,toFloor(5),1,4,Strings.PLATFORM_BLOCK),
				new Platform(141,toFloor(5),1,4,Strings.PLATFORM_BLOCK),
				
				new Platform(2,toFloor(12),2,11,Strings.TILE_BREAK),
				

				
				});
		
		
		
		Tile.count = 0;
		level2_Tiles = new LevelTileBuilder(new Tile[] {
	
				/*
				 * BREAK BLOCKS
				 */																		
				new BreakBox(78,5),new BreakBox(80,5),
				new BreakBox(82,9),new BreakBox(83,9),new BreakBox(84,9),new BreakBox(85,9),new BreakBox(86,9),
				new BreakBox(87,9),new BreakBox(88,9),new BreakBox(89,9),new BreakBox(90,9),new BreakBox(91,9),
				new BreakBox(94,9),new BreakBox(95,9),new BreakBox(96,9),new BreakBox(97,9),new BreakBox(102,5),
				new BreakBox(120,5),new BreakBox(123,9),new BreakBox(124,9),new BreakBox(125,9),new BreakBox(130,9),
				new BreakBox(131,5),new BreakBox(132,5),new BreakBox(133,9),new BreakBox(168,5),new BreakBox(169,5),
				new BreakBox(171,5),
	
				/*
				 * CHANGE TILES		
				 */
				new CoinBox(13,5,Ints.ITEM_POWERUP),
				new CoinBox(14,5),
				new CoinBox(15,5),
				new CoinBox(16,5),
				new CoinBox(17,5),
				new CoinBox(32,6),
				
												
				/*
				 * MAKE TILES
				 */	
				
				new InvisibleBox(64,5,Ints.ITEM_1UP),//64
						
				/*
				 * STARMAN		
				 */
				//new HiddenBox(20,5,Ints.ITEM_STARMAN),//starman 103
				

								
		});
		
		Item.count = 0;
		Coin.count = 0;
		level2_Items = new LevelItemBuilder(new Item[] {
				
				//new BasicBadGuy(25,2),
				//new BasicBadGuy(42,2),
				//new BasicBadGuy(50,2),
				//new BasicBadGuy(52,2),
				//new BasicBadGuy(83,9),
				//new BasicBadGuy(85,2),
				//new BasicBadGuy(99,2),
				//new BasicBadGuy(100,2),
				//new BasicBadGuy(123,2),
				//new BasicBadGuy(124,2),
				//new BasicBadGuy(125,2),
				//new BasicBadGuy(126,2),
				//new BasicBadGuy(127,2),
				//new BasicBadGuy(174,2),
				//new BasicBadGuy(175,2),
				
				/*
				 * non-rigidbodies
				 */
				new Coin(87,4),
				new Coin(89,9),
				new Coin(199,9),
				new Coin(200,8),
				new Coin(200,7),
				new Coin(200,6),
				new Coin(201,5),
				new Coin(201,4),
				new Coin(201,3),

		});
		
		RectangleList.createNewList(Platform.count+Tile.count+Item.count);
		level2_Platforms.init(gc, sbg);
		level2_Tiles.init(gc, sbg);
		level2_Items.init(gc, sbg);
		RectangleList.addSolid(level2_Platforms.rec);
		RectangleList.addSolid(level2_Tiles.rec);
		RectangleList.addSolid(level2_Items.rec);

		hero.init(gc, sbg);
		hd.init(gc, sbg);
	 }
   
   public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
	   bi.render(gc, sbg, g);
	   g.setBackground(new Color(127,131,231));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////RENDER OBJECTS//////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	   level2_Platforms.render(gc, sbg, g);
	   level2_Tiles.render(gc, sbg, g);
	   level2_Items.render(gc, sbg, g);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	   hero.render(gc, sbg, g);//hero
	   hd.render(gc, sbg, g);//header
	}
   
   public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
	   bi.update(gc, sbg, delta);//backdrop
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////UPDATE OBJECTS////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	   level2_Platforms.update(gc, sbg, delta);
	   level2_Tiles.update(gc, sbg, delta);
	   level2_Items.update(gc, sbg, delta);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	   hero.update(gc, sbg, delta);//hero
	   hd.update(gc, sbg, delta);//header
	  
	    
	   /*******************************************************************************************************************/
	   ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////LEVEL RESET CONDITIONS/////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	   //if down-a-hole
	   if(Hero.dY > ScrRes.getHeight()) {
		   if(HeroState.getState() == HeroState.STATE_ALIVE) {
			   HeroState.decrementLives();
			   HeroState.setState(HeroState.STATE_DEAD);
		   }
		}
		else {
			HeroState.setState(HeroState.STATE_ALIVE);
		}
	   
	   if(HeroState.getState() == HeroState.STATE_DEAD) {
		   if(HeroState.getLives() <= 0) {
			   sbg.enterState(GameState.GAMEOVERSTATE);
		   }
		   else {
			   sbg.enterState(GameState.STARTSTATE);
		   }  
	   }
	   
	   /*******************************************************************************************************************/
	   ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////COLLISION CONTROL//////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	   
	   Collision.checkHeroCollision(RectangleList.getSolids());
	
   }//end update
   
   private float toFloor(int floor) {
	   return (ScrRes.getHeight()-(Ints.D*floor))/Ints.D;
   }
   
   public int getID(){
      return 2;
   }
   
}//[end Level_1_2]