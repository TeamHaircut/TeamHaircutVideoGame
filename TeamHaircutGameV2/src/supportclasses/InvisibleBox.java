package supportclasses;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import animations.CustomAnimation;
import arrays.ImageArrays;
import dimensions.Ints;

public class InvisibleBox extends Tile{
	
	private Item item;
	
	public InvisibleBox(float x, int y) throws SlickException {
		super(x,y);
		super.setAnin(new CustomAnimation(ImageArrays.getBlankBox(),1000).getAni());
		super.setPost(new CustomAnimation(ImageArrays.getEmptyBox(),1000).getAni());
		super.setLooping(false);
		super.setAction(Ints.TILE_ACTION_MAKE);
		
	}
	
	public InvisibleBox(float x, int y, int itemType) throws SlickException {
		super(x,y);
		super.setAnin(new CustomAnimation(ImageArrays.getBlankBox(),1000).getAni());
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
		//if(super.isHit()  && item instanceof OneUp) {
		if(super.isHit() && item instanceof OneUp) {
			item.render(gc, sbg, g);
		}
		//	if(	((OneUp) item).isAvailable()) {
				//incrementLives()
//				OldCoin.incrementCoin();
		//		((OneUp) item).setAvailable(false);
		//	}
		//}
//		if(super.isHit()  && item instanceof PowerUp) {
//			item.render(gc, sbg, g);
//		}
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{
		super.update(gc, sbg, delta);
		if(super.isHit()) {
			item.update(gc, sbg, delta);
		}
	}
	


}
