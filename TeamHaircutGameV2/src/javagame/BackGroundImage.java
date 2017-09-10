//	www.teamhaircut.org
package javagame;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import supportclasses.GameFunc;
//import dansLibrary.GameFunc;
import dimensions.Ints;

public class BackGroundImage{
	
	private String resource;
	private Image image;
	private float x;
	private float y;
	
	private float nx;
	
	public BackGroundImage(String res) 
	{
		resource = res;
		nx = -(x-350);
		x = 0;
		y = 0;
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
	{
		image = new Image(resource);
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
	{
		g.drawImage(image,x,y);	
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{
			//x = GameFunc.scrollImage(x, nx, Hero.wall, Hero.nx);
			x = GameFunc.scrollImage(x, nx, Ints.WALL, Ints.NX);
	}
	
}//end class