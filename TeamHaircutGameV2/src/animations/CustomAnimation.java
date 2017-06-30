package animations;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;

public class CustomAnimation {
    
	private Animation ani;
	
	public CustomAnimation(Image[] imageArray, int dur) {
		int[] duration = new int[imageArray.length];
		for(int i = 0; i < imageArray.length; i++) {
			duration[i] = dur;
		}
		ani = new Animation(imageArray,duration);
	}
	
	public Animation getAni() {
		return ani;
	}
	
}
