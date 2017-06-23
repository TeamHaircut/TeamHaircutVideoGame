package supportclasses;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import animations.CustomAnimation;
import arrays.ImageArrays;
import dimensions.Ints;

public class Coin extends Tile{
	
	private boolean isAvailable;
	
	public Coin(float x, int y) throws SlickException {
		super(x,y);
		super.setAnin(new CustomAnimation(ImageArrays.getCoin(),200).getAni());
		super.setPost(new CustomAnimation(ImageArrays.getBlankBox(),1000).getAni());
		super.setxOffset(0);
		super.setyOffset(0);
		super.setLooping(false);
		super.setAction(Ints.TILE_ACTION_TAKE);
		isAvailable = true;
		
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{
		super.update(gc, sbg, delta);
		if(super.isHit()) {
			if(isAvailable) {
				OldCoin.incrementCoin();
			}
			isAvailable = false;
		}
	}

}
