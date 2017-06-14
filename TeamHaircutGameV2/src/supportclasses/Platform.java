package supportclasses;

import javagame.Hero;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

import dansLibrary.GameFunc;
import dimensions.Dimensions;

public class Platform {
	public static int count;
	private Rectangle rec;
	
	private float x;
	private float y;
	private int col;
	private int row;
	private String res;
	
	private float nx;
	private Image image;
	
	public Platform(float x, float y, int col, int row, String res) {
		count++;
	
		this.x = x*Dimensions.D;
		this.y = y*Dimensions.D;
		this.col = col;
		this.row = row;
		this.res = res;
		
		nx = -((x*Dimensions.D)-350);
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
	{
		image = new Image(res);
		rec = new Rectangle(x,y,col*Dimensions.D,row*Dimensions.D);
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
	{
		for(int r = 0; r < row; r++) {
			for(int c = 0; c < col; c++) {
				g.drawImage(image,x+(Dimensions.D*c),y+(Dimensions.D*r));
			}
		}
		rec.setX(x);
		
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{
		x = GameFunc.scrollImage(x, nx, Hero.wall, Hero.nx);
	}

	public Rectangle getRec() {
		return rec;
	}

	public void setRec(Rectangle rec) {
		this.rec = rec;
	}
	
	
}
