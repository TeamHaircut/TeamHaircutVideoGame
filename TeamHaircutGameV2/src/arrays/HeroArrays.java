package arrays;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import strings.HeroStrings;
import strings.Strings;

public class HeroArrays {
	
public static Image[] DHfaceR;
	
	
	public static Image[] getDHfaceR() throws SlickException {
		DHfaceR = new Image[]{ 
				new Image(HeroStrings.DH_FACE_R)};
		return DHfaceR;
	}

}
