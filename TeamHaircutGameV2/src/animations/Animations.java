package animations;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import strings.Strings;

public class Animations {
    
	private Animation brickBoxAni;
	private Animation brickBlankAni;
	private Animation coinBoxAni;
	
	public Animation getCoinBoxAni() {
		return coinBoxAni;
	}

	public void setCoinBoxAni(Animation coinBoxAni) {
		this.coinBoxAni = coinBoxAni;
	}

	public Animation getBrickBlankAni() {
		return brickBlankAni;
	}

	public void setBrickBlankAni(Animation brickBlankAni) {
		this.brickBlankAni = brickBlankAni;
	}

	public Animation getBrickBoxAni() {
		return brickBoxAni;
	}

	public void setBrickBoxAni(Animation brickBoxAni) {
		this.brickBoxAni = brickBoxAni;
	}

	public Animations() throws SlickException {

		brickBoxAni = new Animation(new Image[]{
				new Image(Strings.TILE_BREAK),
				new Image(Strings.TILE_BOX)},
				new int[]{10,1}, true);
		//brickBoxAni.setLooping(false);
		
		brickBlankAni = new Animation(new Image[]{
				new Image(Strings.TILE_BREAK),
				new Image(Strings.TILE_BLANK)},
				new int[]{10,1}, true);
		//brickBlankAni.setLooping(false);
		
		coinBoxAni = new Animation(new Image[]{
				new Image(Strings.TILE_COIN1),
				new Image(Strings.TILE_COIN2),
				new Image(Strings.TILE_COIN3),
				new Image(Strings.TILE_BOX)},
				new int[]{200,200,200,1}, true);
		//coinBoxAni.setPingPong(true);
		//coinBoxAni.setLooping(false);
		
		
	}

	

}
