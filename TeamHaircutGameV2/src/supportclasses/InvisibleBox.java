package supportclasses;

import org.newdawn.slick.SlickException;

import animations.CustomAnimation;
import arrays.ImageArrays;
import dimensions.Ints;

public class InvisibleBox extends Tile{
	
	public InvisibleBox(float x, int y) throws SlickException {
		super(x,y);
		super.setAnin(new CustomAnimation(ImageArrays.getBlankBox(),1000).getAni());
		super.setPost(new CustomAnimation(ImageArrays.getEmptyBox(),1000).getAni());
		super.setLooping(false);
		super.setAction(Ints.TILE_ACTION_MAKE);
		
	}
	


}
