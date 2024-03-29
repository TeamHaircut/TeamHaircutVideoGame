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
				
				new Platform(106,toFloor(4),Strings.PLATFORM_TUBE),
				new Platform(112,toFloor(5),Strings.PLATFORM_TUBE),
				new Platform(118,toFloor(3),Strings.PLATFORM_TUBE),
				new Platform(182,toFloor(4),Strings.PLATFORM_TUBE),
				new Platform(186,toFloor(4),Strings.PLATFORM_TUBE),
				new Platform(190,toFloor(4),Strings.PLATFORM_TUBE),
				
				new Platform(9,toFloor(13),16,1,Strings.TILE_BREAK_U),
				new Platform(100,toFloor(13),42,1,Strings.TILE_BREAK_U),
				new Platform(126,toFloor(2),2,2,Strings.TILE_BREAK_U),
				new Platform(126,toFloor(3),2,2,Strings.TILE_BREAK_U),
				new Platform(126,toFloor(4),2,2,Strings.TILE_BREAK_U),
				new Platform(164,toFloor(4),17,3,Strings.TILE_BREAK_U),//
				new Platform(174,toFloor(13),7,9,Strings.TILE_BREAK_U),
				new Platform(181,toFloor(13),10,1,Strings.TILE_BREAK_U),
				new Platform(194,toFloor(15),13,14,Strings.TILE_BREAK_U),
				
				new Platform(0,toFloor(1),83,2,Strings.PLATFORM_BRICK_U),//_BRICK, BLOCK,TUBE
				new Platform(87,toFloor(1),36,2,Strings.PLATFORM_BRICK_U),
				new Platform(126,toFloor(1),2,2,Strings.PLATFORM_BRICK_U),
				new Platform(130,toFloor(1),12,1,Strings.PLATFORM_BRICK_U),
				new Platform(149,toFloor(1),8,2,Strings.PLATFORM_BRICK_U),
				new Platform(164,toFloor(1),50,2,Strings.PLATFORM_BRICK_U),
				new Platform(20,toFloor(2),1,1,Strings.PLATFORM_BLOCK_U),
				new Platform(22,toFloor(3),1,2,Strings.PLATFORM_BLOCK_U),
				new Platform(24,toFloor(4),1,3,Strings.PLATFORM_BLOCK_U),
				new Platform(26,toFloor(5),1,4,Strings.PLATFORM_BLOCK_U),
				new Platform(28,toFloor(5),1,4,Strings.PLATFORM_BLOCK_U),
				new Platform(30,toFloor(4),1,3,Strings.PLATFORM_BLOCK_U),
				new Platform(34,toFloor(4),1,3,Strings.PLATFORM_BLOCK_U),
				new Platform(36,toFloor(3),1,2,Strings.PLATFORM_BLOCK_U),
				new Platform(137,toFloor(2),1,1,Strings.PLATFORM_BLOCK_U),
				new Platform(138,toFloor(3),1,2,Strings.PLATFORM_BLOCK_U),
				new Platform(139,toFloor(4),1,3,Strings.PLATFORM_BLOCK_U),
				new Platform(140,toFloor(5),1,4,Strings.PLATFORM_BLOCK_U),
				new Platform(141,toFloor(5),1,4,Strings.PLATFORM_BLOCK_U),
				
				new Platform(2,toFloor(13),2,12,Strings.TILE_BREAK),
				
				//new FloatingPlatform(144, 3 tiles long),
				//new FloatingPlatform(158, 3 tiles long),
				//new hor tube at 169, 9 tiles tall
				

				
				});
		
		
		
		Tile.count = 0;
		level2_Tiles = new LevelTileBuilder(new Tile[] {
	
				/*
				 * BREAK BLOCKS
				 */
				new BreakBox(45,7),new BreakBox(46,7),
				new BreakBox(42,7),                   new BreakBox(44,7),new BreakBox(47,7),                   
				new BreakBox(42,6),                   new BreakBox(44,6),new BreakBox(47,6),                   new BreakBox(49,6),
				new BreakBox(42,5),new BreakBox(43,5),new BreakBox(44,5),new BreakBox(47,5),new BreakBox(48,5),new BreakBox(49,5),
				new BreakBox(25,13),new BreakBox(26,13),new BreakBox(27,13),new BreakBox(28,13),new BreakBox(29,13),new BreakBox(30,13),
				new BreakBox(31,13),new BreakBox(32,13),new BreakBox(33,13),new BreakBox(34,13),new BreakBox(35,13),new BreakBox(36,13),
				new BreakBox(37,13),new BreakBox(38,13),new BreakBox(39,13),new BreakBox(40,13),new BreakBox(41,13),new BreakBox(42,13),
				new BreakBox(43,13),new BreakBox(44,13),new BreakBox(45,13),new BreakBox(46,13),new BreakBox(47,13),new BreakBox(48,13),
				new BreakBox(49,13),new BreakBox(50,13),new BreakBox(51,13),new BreakBox(52,13),new BreakBox(53,13),new BreakBox(54,13),
				new BreakBox(55,13),new BreakBox(56,13),new BreakBox(57,13),new BreakBox(58,13),new BreakBox(59,13),new BreakBox(60,13),
				
				new BreakBox(55,5),new BreakBox(55,6),new BreakBox(55,7),new BreakBox(55,8),new BreakBox(55,9),new BreakBox(57,10),
				new BreakBox(56,5),new BreakBox(56,6),new BreakBox(56,7),new BreakBox(56,8),new BreakBox(56,9),new BreakBox(58,10),
				new BreakBox(57,5),new BreakBox(58,5),new BreakBox(57,4),new BreakBox(58,4),new BreakBox(57,3),new BreakBox(58,3),
				new BreakBox(57,11),new BreakBox(58,11),new BreakBox(57,12),new BreakBox(58,12),
				
				new BreakBox(61,5),new BreakBox(62,5),new BreakBox(63,5),new BreakBox(64,5),new BreakBox(65,5),new BreakBox(66,5),
				new BreakBox(65,6),new BreakBox(66,6),new BreakBox(65,7),new BreakBox(66,7),new BreakBox(65,8),new BreakBox(66,8),
				new BreakBox(65,9),new BreakBox(66,9),new BreakBox(65,10),new BreakBox(66,10),new BreakBox(65,11),new BreakBox(66,11),
				new BreakBox(65,12),new BreakBox(66,12),new BreakBox(65,13),new BreakBox(66,13),
				new BreakBox(61,10),new BreakBox(62,10),new BreakBox(63,10),new BreakBox(64,10),
				new BreakBox(61,11),new BreakBox(62,11),new BreakBox(63,11),new BreakBox(64,11),
				new BreakBox(61,12),new BreakBox(62,12),new BreakBox(63,12),new BreakBox(64,12),
				new BreakBox(61,13),new BreakBox(62,13),new BreakBox(63,13),new BreakBox(64,13),
				new BreakBox(67,13),new BreakBox(68,13),
				new BreakBox(69,13),new BreakBox(70,13),new BreakBox(71,13),new BreakBox(72,13),
				new BreakBox(69,12),new BreakBox(70,12),new BreakBox(71,12),new BreakBox(72,12),
				new BreakBox(69,11),new BreakBox(70,11),new BreakBox(71,11),new BreakBox(72,11),
				new BreakBox(69,10),new BreakBox(70,10),new BreakBox(71,10),new BreakBox(72,10),
				new BreakBox(70,9),
				new BreakBox(70,8),
				new BreakBox(70,7),
				new BreakBox(70,6),
				new BreakBox(70,5),new BreakBox(71,5),new BreakBox(72,5),
				
				new BreakBox(73,13),new BreakBox(74,13),new BreakBox(75,13),new BreakBox(76,13),new BreakBox(77,13),new BreakBox(78,13),
				new BreakBox(75,9),new BreakBox(76,9),
				new BreakBox(75,8),new BreakBox(76,8),
				new BreakBox(75,7),new BreakBox(76,7),
				new BreakBox(75,6),
				new BreakBox(75,5),new BreakBox(76,5),
				
				new BreakBox(79,5),new BreakBox(80,5),new BreakBox(81,5),new BreakBox(82,5),
				new BreakBox(79,13),new BreakBox(80,13),new BreakBox(81,13),new BreakBox(82,13),
				new BreakBox(79,12),new BreakBox(80,12),new BreakBox(81,12),new BreakBox(82,12),
				new BreakBox(79,11),new BreakBox(80,11),new BreakBox(81,11),new BreakBox(82,11),
				new BreakBox(79,10),new BreakBox(80,10),new BreakBox(81,10),new BreakBox(82,10),
				
				new BreakBox(83,13),new BreakBox(84,13),new BreakBox(85,13),new BreakBox(86,13),new BreakBox(87,13),new BreakBox(88,13),new BreakBox(89,13),new BreakBox(90,13),
				new BreakBox(91,13),
				
				new BreakBox(87,7),new BreakBox(88,7),new BreakBox(89,7),new BreakBox(90,7),new BreakBox(91,7),new BreakBox(92,7),
				new BreakBox(87,6),new BreakBox(88,6),new BreakBox(89,6),new BreakBox(90,6),new BreakBox(91,6),new BreakBox(92,6),
				new BreakBox(93,13),new BreakBox(94,13),new BreakBox(95,13),new BreakBox(96,13),new BreakBox(97,13),new BreakBox(98,13),new BreakBox(99,13),
				new BreakBox(148,6),new BreakBox(149,6),new BreakBox(150,6),new BreakBox(151,6),new BreakBox(152,6),
				new BreakBox(158,4),//remove this block in production
				
				new BreakBox(165,13),new BreakBox(166,13),new BreakBox(167,13),new BreakBox(168,13),new BreakBox(169,13),new BreakBox(170,13),new BreakBox(171,13),
				
				
				/*
				 * CHANGE TILES		
				 */
				new CoinBox(13,5,Ints.ITEM_POWERUP),
				new CoinBox(14,5),
				new CoinBox(15,5),
				new CoinBox(16,5),
				new CoinBox(17,5),
				new CoinBox(32,6,ImageArrays.getBrickBox()),
				new CoinBox(72,6,ImageArrays.getBrickBox(), Ints.ITEM_POWERUP),
				new CoinBox(76,6,ImageArrays.getBrickBox()),
				new CoinBox(153,6,ImageArrays.getBrickBox(), Ints.ITEM_POWERUP),

				
												
				/*
				 * MAKE TILES
				 */	
				//new InvisibleBox(92,6,Ints.ITEM_1UP),//64
						
				/*
				 * STARMAN		
				 */
				new HiddenBox(49,7,Ints.ITEM_STARMAN),//starman 103
				new HiddenBox(92,13,Ints.ITEM_1UP),
												
		});
		
		Item.count = 0;
		Coin.count = 0;
		level2_Items = new LevelItemBuilder(new Item[] {
				
				new BasicBadGuy(19,2),
				new BasicBadGuy(20,3),
				new BasicBadGuy(32,2),
				new BasicBadGuy(65,2),
				new BasicBadGuy(67,2),
				new BasicBadGuy(76,10),
				new BasicBadGuy(79,6),
				new BasicBadGuy(81,6),
				new BasicBadGuy(101,2),
				new BasicBadGuy(103,2),
				new BasicBadGuy(105,2),
				new BasicBadGuy(116,2),
				new BasicBadGuy(140,6),
				new BasicBadGuy(138,5),
				
				//new DoubleBadGuy(46,2),
				//new DoubleBadGuy(48,2),
				//new DoubleBadGuy(61,2),
				//new DoubleBadGuy(149,2),
				
				//new piranaBadGuy(106,4),
				//new piranaBadGuy(112,5),
				//new piranaBadGuy(118,3),
				
				
				/*
				 * non-rigidbodies
				 */
				new Coin(44,8),new Coin(45,8),new Coin(46,8),new Coin(47,8),
				new Coin(43,5),new Coin(48,5),
				new Coin(61,5),new Coin(62,5),new Coin(63,5),new Coin(64,5),new Coin(71,5),
				new Coin(87,8),new Coin(88,8),new Coin(89,8),new Coin(90,8),new Coin(91,8),new Coin(92,8),				

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