package supportclasses;

import org.newdawn.slick.SlickException;

import dimensions.Ints;
import animations.CustomAnimation;
import arrays.ImageArrays;

public class HiddenBox extends Tile{
	
	public HiddenBox(float x, int y) throws SlickException {
		super(x,y);
		super.setAnin(new CustomAnimation(ImageArrays.getBrickBox(),1000).getAni());
		super.setPost(new CustomAnimation(ImageArrays.getEmptyBox(),1000).getAni());
		super.setLooping(false);
		super.setAction(Ints.TILE_ACTION_NONE);
		
	}

}
