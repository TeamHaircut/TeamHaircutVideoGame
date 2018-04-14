//	www.teamhaircut.org
package supportclasses;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

import dimensions.Ints;

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
	
	private int type;
	
	public Platform(float x, float y, int col, int row, String res) {
		count++;
	
		this.x = x*Ints.D;
		this.y = y*Ints.D;
		this.col = col;
		this.row = row;
		this.res = res;
		this.type = Ints.PLATFORM;
		nx = -((x*Ints.D)-350);
	}
	
	public Platform(float x, float y, String res) {
		count++;
	
		this.x = x*Ints.D;
		this.y = y*Ints.D;
		
		this.col = 0;
		this.row = 0;
		this.res = res;
		this.type = Ints.TUBE;
		nx = -((x*Ints.D)-350);
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
	{
		image = new Image(res);
		switch(type) {
			case Ints.TUBE:
				rec = new Rectangle(x,y,image.getWidth(),image.getHeight());
				break;
				
			default:
				rec = new Rectangle(x,y,col*Ints.D,row*Ints.D);
				break;		
		}
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
	{
		switch(type) {
		case Ints.TUBE:
			g.drawImage(image,x,y);
			break;
			
		default:
			for(int r = 0; r < row; r++) {
				for(int c = 0; c < col; c++) {
					g.drawImage(image,x+(Ints.D*c),y+(Ints.D*r));
				}
			}
			break;		
		}
		rec.setX(x);
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		x = GameFunc.scrollImage(x, nx, Ints.WALL, Ints.NX);
	}

	public Rectangle getRec() {
		return rec;
	}

	public void setRec(Rectangle rec) {
		this.rec = rec;
	}
		
}//[end Platform]
