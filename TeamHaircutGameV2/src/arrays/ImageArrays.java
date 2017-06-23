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
		
}
