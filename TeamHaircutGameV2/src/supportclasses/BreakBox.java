package supportclasses;

import org.newdawn.slick.SlickException;

import animations.CustomAnimation;
import arrays.ImageArrays;
import dimensions.Ints;

public class BreakBox extends Tile{
	
	public BreakBox(float x, int y) throws SlickException {
		super(x,y);
		super.setAnin(new CustomAnimation(ImageArrays.getBrickBox(),1000).getAni());
		super.setPost(new CustomAnimation(ImageArrays.getBreakBox(),100).getAni());
		super.setxOffset(-80);
		super.setyOffset(-120);
		super.setLooping(false);
		super.setAction(Ints.TILE_ACTION_BREAK);
		
	}

}
