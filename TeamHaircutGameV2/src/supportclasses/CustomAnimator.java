//	www.teamhaircut.org
package supportclasses;

import org.newdawn.slick.Color;

public class CustomAnimator {
	
	private static final Color[] COLORARRAY = new Color[]{new Color(0,0,252),new Color(0,120,248),new Color(60,188,252),
		new Color(164,228,252), new Color(60,188,252),new Color(0,120,248)};
	
	private int duration;
	private int frame;
	private Color color;
	
	
	public CustomAnimator () {
		color = Color.white;
		frame = 0;
		duration = 0;
	}
	
	public void animateString(int delta, int frameRate) {
		duration += delta; 
		if(duration >= frameRate) {
			setColor(COLORARRAY[frame]);
			frame++;
			duration = 0;
		}
		if(frame == 6) {
			frame = 0;
		}
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getFrame() {
		return frame;
	}

	public void setFrame(int frame) {
		this.frame = frame;
	}

	public Color getColor() {
		return color;
	}

	private void setColor(Color color) {
		this.color = color;
	}
}//[end CustomAnimator]