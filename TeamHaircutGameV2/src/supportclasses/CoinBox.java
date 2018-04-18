//	www.teamhaircut.org
package supportclasses;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import states.HeroState;
import dimensions.Ints;
import animations.CustomAnimation;
import arrays.ImageArrays;

public class CoinBox extends Tile{
	
	private Item item;
	
	public CoinBox(float x, int y) throws SlickException {
		super(x,y);
		super.setAnin(new CustomAnimation(ImageArrays.getCoinBox(),200).getAni());
		super.setPost(new CustomAnimation(ImageArrays.getEmptyBox(),1000).getAni());
		super.setLooping(false);
		super.setAction(Ints.TILE_ACTION_NONE);
		item = new HiddenCoin(x,y);
	}
	
	public CoinBox(float x, int y, int itemType) throws SlickException {
		super(x,y);
		super.setAnin(new CustomAnimation(ImageArrays.getCoinBox(),200).getAni());
		super.setPost(new CustomAnimation(ImageArrays.getEmptyBox(),1000).getAni());
		super.setLooping(false);
		super.setAction(Ints.TILE_ACTION_NONE);
		switch(itemType) {
		case Ints.ITEM_POWERUP:
			item = new PowerUp(x,y);
			break;
			
		default:
			item = new HiddenCoin(x,y);
			break;
		}	
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
	{
		super.init(gc, sbg);
		item.init(gc, sbg);
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
	{
		super.render(gc, sbg, g);
		if(super.isHit()  && item instanceof HiddenCoin) {
			item.render(gc, sbg, g);
			if(	((HiddenCoin) item).isAvailable()) {
				HeroState.incrementCoins();
				HeroState.incrementScore(Ints.COIN_VALUE);
				((HiddenCoin) item).setAvailable(false);
			}
		}
		if(super.isHit()  && item instanceof PowerUp) {
			item.render(gc, sbg, g);
		}
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{
		super.update(gc, sbg, delta);
		item.update(gc, sbg, delta);
	}
	
}//[end CoinBox]
