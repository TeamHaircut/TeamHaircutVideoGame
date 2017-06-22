package supportclasses;

import javagame.Hero;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

import states.ScrRes;
import dansLibrary.GameFunc;
import dimensions.Ints;
import animations.CustomAnimation;
import arrays.ImageArrays;

public class CoinBox extends Tile{
	
	private HiddenCoin hc;
	
	public CoinBox(float x, int y) throws SlickException {
		super(x,y);
		super.setAnin(new CustomAnimation(ImageArrays.getCoinBox(),200).getAni());
		super.setPost(new CustomAnimation(ImageArrays.getEmptyBox(),1000).getAni());
		super.setLooping(false);
		super.setAction(Ints.TILE_ACTION_NONE);
		hc = new HiddenCoin(x,y);
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
	{
		super.init(gc, sbg);
		hc.init(gc, sbg);
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
	{
		super.render(gc, sbg, g);
		if(super.isHit()) {
			hc.render(gc, sbg, g);
			if(hc.isAvailable()) {
				Coin.incrementCoin();
				hc.setAvailable(false);
			}
		}
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{
		super.update(gc, sbg, delta);
		hc.update(gc, sbg, delta);
	}
	

	
}
