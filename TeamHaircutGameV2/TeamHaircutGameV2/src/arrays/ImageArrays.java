//	www.teamhaircut.org
package arrays;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import strings.Strings;

public class ImageArrays{
	
	public static Image[] CoinBox;
	public static Image[] BrickBox;
	public static Image[] EmptyBox;
	public static Image[] BreakBox;
	public static Image[] BlankBox;
	
	public static Image[] CoinItem;
	public static Image[] PowerUpItem;
	
	public static Image[] Coin;
	public static Image[] OneUp;
	public static Image[] OneUpPost;
	
	public static Image[] Starman;
	
	public static Image[] BasicBadGuyL;
	public static Image[] BasicBadGuyR;
	public static Image[] BasicBadGuyPost;
	
	public static Image[] Bullet;
	
	
	public static Image[] getCoinBox() throws SlickException {
		CoinBox = new Image[]{ 
				new Image(Strings.TILE_COIN1),
				new Image(Strings.TILE_COIN2),
				new Image(Strings.TILE_COIN3)};
		return CoinBox;
	}
	
	public static Image[] getBrickBox() throws SlickException {
		BrickBox = new Image[]{ 
				new Image(Strings.TILE_BREAK)};
		return BrickBox;
	}
	
	public static Image[] getEmptyBox() throws SlickException {
		EmptyBox = new Image[]{ 
				new Image(Strings.TILE_BOX)};
		return EmptyBox;
	}
	
	public static Image[] getBreakBox() throws SlickException {
		BreakBox = new Image[]{ 
				new Image(Strings.TILE_BREAK1),
				new Image(Strings.TILE_BREAK2),
				new Image(Strings.TILE_BREAK3),
				new Image(Strings.TILE_BREAK4),
				new Image(Strings.TILE_BLANK)};
		return BreakBox;
	}
	
	public static Image[] getBlankBox() throws SlickException {
		BlankBox = new Image[]{ 
				new Image(Strings.TILE_BLANK)};
		return BlankBox;
	}
	
	public static Image[] getCoinItem() throws SlickException {
		CoinItem = new Image[]{ 
				new Image(Strings.ITEM_COIN1),
				new Image(Strings.ITEM_COIN2),
				new Image(Strings.TILE_BLANK)};
		return CoinItem;
	}
	
	public static Image[] getPowerUpItem() throws SlickException {
		PowerUpItem = new Image[]{ 
				new Image(Strings.ITEM_POWERUP)};
		return PowerUpItem;
	}
	
	public static Image[] getCoin() throws SlickException {
		Coin = new Image[]{ 
				new Image(Strings.ITEM_COIN1),
				new Image(Strings.ITEM_COIN2)};
		return Coin;
	}
	
	public static Image[] getOneUp() throws SlickException {
		OneUp = new Image[]{ 
				new Image(Strings.ITEM_1UP)};
		return OneUp;
	}
	
	public static Image[] getOneUpPost() throws SlickException {
		OneUpPost = new Image[]{ 
				new Image(Strings.ITEM_1UP_POST),
				new Image(Strings.TILE_BLANK)};
		return OneUpPost;
	}
	
	public static Image[] getStarman() throws SlickException {
		Starman = new Image[]{ 
				new Image(Strings.ITEM_STARMAN1),
				new Image(Strings.ITEM_STARMAN2)};
		return Starman;
	}
	
	public static Image[] getBasicBadGuyL() throws SlickException {
		BasicBadGuyL = new Image[]{ 
				new Image(Strings.BAD_WALK_L_BASIC),
				new Image(Strings.BAD_NONE_L_BASIC)};
		return BasicBadGuyL;
	}
	
	public static Image[] getBasicBadGuyR() throws SlickException {
		BasicBadGuyR = new Image[]{ 
				new Image(Strings.BAD_WALK_R_BASIC),
				new Image(Strings.BAD_NONE_R_BASIC)};
		return BasicBadGuyR;
	}
	
	public static Image[] getBasicBadGuyPost() throws SlickException {
		BasicBadGuyPost = new Image[]{ 
				new Image(Strings.BAD_POST1_BASIC),
				new Image(Strings.BAD_POST2_BASIC)};
		return BasicBadGuyPost;
	}	
	
	public static Image[] getBullet() throws SlickException {
		Bullet = new Image[]{ 
				new Image(Strings.BULLET1)};
		return Bullet;
	}	
}//[end ImageArrays]