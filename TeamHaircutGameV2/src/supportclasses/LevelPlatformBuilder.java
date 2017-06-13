 package supportclasses;
import javagame.Hero;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.*;
import dansLibrary.GameFunc;
import dimensions.Dimensions;

public class LevelPlatformBuilder{
	
	private int size;
	private String[] resource;
	private float[] x;
	private float[] y;
	private int[] col;
	private int[] row;
	private float[] nx;
	
	private Image[] image;
	public Rectangle[] rec;
	
	public LevelPlatformBuilder(Platform[] platformArray) {
		size = platformArray.length;
		resource = new String[size];
		x = new float[size];
		y = new float[size];
		col = new int[size];
		row = new int[size];
		nx = new float[size];
		for(int i = 0; i < platformArray.length; i++) {
			resource[i] = platformArray[i].getRes();
			nx[i] = -((platformArray[i].getX()*Dimensions.D)-350);
			x[i] = platformArray[i].getX()*Dimensions.D;
			y[i] = platformArray[i].getY()*Dimensions.D;
			col[i] = platformArray[i].getCol();
			row[i] = platformArray[i].getRow();
		}
		
	}	

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		image = new Image[size];
		rec = new Rectangle[size];
		for (int i = 0; i < getSize(); i++)
		{
			image[i] = new Image(resource[i]);
			rec[i] = new Rectangle(x[i],y[i],col[i]*Dimensions.D,row[i]*Dimensions.D);	
		}
	}
   
   public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
	   for(int i = 0; i < getSize(); i++) {
		   for(int r = 0; r < row[i]; r++) {
			   for(int c = 0; c < col[i]; c++) {
				    g.drawImage(image[i],x[i]+(Dimensions.D*c),y[i]+(Dimensions.D*r));
		   			//g.fill(rec[i]);
		   			//g.setColor(Color.white); 
		   			rec[i].setX(x[i]);
			   }		
		   }			
	   }
	   
	   
	}
   
   public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{
	   for (int i = 0; i < getSize(); i++)
	   {
			x[i] = GameFunc.scrollImage(x[i], nx[i], Hero.wall, Hero.nx);
	   }
	}

	private int getSize() {
		return size;
	}

}//end class

