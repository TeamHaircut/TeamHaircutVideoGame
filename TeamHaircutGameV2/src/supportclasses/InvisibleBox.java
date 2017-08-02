package supportclasses;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import dimensions.Ints;
import animations.CustomAnimation;
import arrays.ImageArrays;

public class InvisibleBox extends Tile{
	
	private Item item;
	
	public InvisibleBox(float x, int y) throws SlickException {
		super(x,y);
		super.setAnin(new CustomAnimation(ImageArrays.getBlankBox(),200).getAni());
		super.setPost(new CustomAnimation(ImageArrays.getEmptyBox(),1000).getAni());
		super.setLooping(false);
		super.setAction(Ints.TILE_ACTION_MAKE);
		item = new HiddenCoin(x,y);
	}
	
	public InvisibleBox(float x, int y, int itemType) throws SlickException {
		super(x,y);
		super.setAnin(new CustomAnimation(ImageArrays.getBlankBox(),200).getAni());
		super.setPost(new CustomAnimation(ImageArrays.getEmptyBox(),1000).getAni());
		super.setLooping(false);
		super.setAction(Ints.TILE_ACTION_MAKE);
		switch(itemType) {
		case Ints.ITEM_1UP:
			item = new OneUp(x,y);
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
				OldCoin.incrementCoin();
				((HiddenCoin) item).setAvailable(false);
			}
		}
		if(super.isHit()  && item instanceof OneUp) {
			item.render(gc, sbg, g);
			item.vox = 0.1f;
		}
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{
		super.update(gc, sbg, delta);
		item.update(gc, sbg, delta);
	}
	
}
