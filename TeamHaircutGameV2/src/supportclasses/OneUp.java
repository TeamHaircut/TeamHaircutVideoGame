package supportclasses;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Point;
import org.newdawn.slick.state.StateBasedGame;

import dimensions.Ints;
import states.HeroState;
import states.ScrRes;
import animations.CustomAnimation;
import arrays.ImageArrays;

public class OneUp extends Item{
	
	public int dir;
	public int counter;
	
	public Point leftHigh;
	public Point leftMid;
	public Point leftLow;
	public  Point leftHighPercept;
	public  Point leftMidPercept;
	public  Point leftLowPercept;
	
	public  Point rightHigh;
	public  Point rightMid;
	public  Point rightLow;
	public  Point rightHighPercept;
	public  Point rightMidPercept;
	public  Point rightLowPercept;
	
	public  Point bottomLeft;
	public  Point bottomRight;
	public  Point bottomLeftPercept;
	public  Point bottomRightPercept;
	
	public  Point topLeft;
	public  Point topRight;
	public  Point topLeftPercept;
	public  Point topRightPercept;
	private ObjectCollision coll;
	

	private Animation ani;
	private float vo;
	private float dY;
	private float jumpCounter;
	private float timeY;
	private float yo;
	private float a = -750f;
	private float v;
	
	
	public OneUp(float x, int y) {
		super(x, y);
		dir = 1;
		counter = 0;
		coll = new ObjectCollision();
		this.ani = new Animation();
		dY = 0;
		yo = this.y;
		vo = 0;
		v = 0;
		timeY = 0;
		jumpCounter = 0;
		
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
	{
		super.init(gc, sbg);
		ani = new CustomAnimation(ImageArrays.getOneUp(),200).getAni();
		ani.setLooping(false);
		leftHigh = new Point(x+Ints.D,y+1); leftHighPercept = new Point(x+Ints.D+1,y+1);
		leftMid = new Point(x+Ints.D,y+Ints.D); leftMidPercept = new Point(x+Ints.D+1, y+Ints.D);
		leftLow = new Point(x+Ints.D,y+(2*Ints.D)-1); leftLowPercept = new Point(x+Ints.D+1,y+(2*Ints.D)-1);
		
		rightHigh = new Point(x,y+1); rightHighPercept = new Point(x-1,y+1);
		rightMid = new Point(x,y+Ints.D); rightMidPercept = new Point(x-1, y+Ints.D);
		rightLow = new Point(x,y+(2*Ints.D)-1); rightLowPercept = new Point(x-1,y+(2*Ints.D)-1);
		
		bottomLeft = new Point(x+1,y+(2*Ints.D)); bottomLeftPercept = new Point(x+1,y+(2*Ints.D)+1);
		bottomRight = new Point(x+Ints.D-1,y+(2*Ints.D)); bottomRightPercept = new Point(x+Ints.D-1,y+(2*Ints.D)+1);
		
		topLeft = new Point(x+1,y); topLeftPercept = new Point(x+1,y-1);
		topRight = new Point(x+Ints.D-1,y); topRightPercept = new Point(x+Ints.D-1,y-1);
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
	{
		super.render(gc, sbg, g);
		
		super.getRec().setX(super.getX());
		super.getRec().setY(super.getY());
		ani.draw(super.getX(), super.getY());
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{
		super.update(gc, sbg, delta);
		nx = nx - ((vox)*(dir)*delta);
		jump(gc,delta);
		
		counter += delta;
		 jump(gc,delta);
		 if (counter > 1000) {
			 if(coll.isFlagMidLeft() || coll.isFlagMidRight()) {
				 
				 dir = -1*dir;
				 counter = 0;
			 }
		 } 
		
		leftHigh.setLocation(x+Ints.D,y+1); leftHighPercept.setLocation(x+Ints.D+1,y+1);
		leftMid.setLocation(x+Ints.D,y+Ints.D); leftMidPercept.setLocation(x+Ints.D+1, y+Ints.D);
		leftLow.setLocation(x+Ints.D,y+(2*Ints.D)-1); leftLowPercept.setLocation(x+Ints.D+1,y+(2*Ints.D)-1);
		
		rightHigh.setLocation(x,y+1); rightHighPercept.setLocation(x-1,y+1);
		rightMid.setLocation(x,y+Ints.D); rightMidPercept.setLocation(x-1, y+Ints.D);
		rightLow.setLocation(x,y+(2*Ints.D)-1); rightLowPercept.setLocation(x-1,y+(2*Ints.D)-1);
			
		bottomLeft.setLocation(x+10,y+(2*Ints.D)); bottomLeftPercept.setLocation(x+10,y+(2*Ints.D)+1);
		bottomRight.setLocation(x+Ints.D-10,y+(2*Ints.D)); bottomRightPercept.setLocation(x+Ints.D-10,y+(2*Ints.D)+1);
		
		topLeft.setLocation(x+1,y); topLeftPercept.setLocation(x+1,y-1);
		topRight.setLocation(x+Ints.D-1,y); topRightPercept.setLocation(x+Ints.D-1,y-1);
		
		
		coll.checkObjectCollision(RectangleList.getSolids(), this);
	}
	

	public void jump(GameContainer gc, int delta){
		//implement jump trigger
		if(getJumpTrigger() == true) {
			vo = 500;// dY--;
		}
		jumpCounter = jumpCounter + delta;
		timeY = jumpCounter/1000;
		
		if (v < 0 && coll.isFlagBottomPartial()) {//on ground
			vo = 0;
			if (dY != yo && jumpCounter !=0) {
				yo = (int) (((dY/Ints.D)*Ints.D)/10);
				if (yo % 2 == 1) {
					yo = (yo - 1)*10;
				}
				else {
					yo = yo *10;
				}
				dY =yo; vo = 0;
		   }
		   jumpCounter = 0;
	    }
		
		else {
			v = vo + a*timeY;
			dY = -(((v))*timeY -0.5f*(a)*timeY*timeY)+yo;
			y = dY;
			if (timeY > 0) {
				setJumpTrigger(false);
			}
		}
		
	}//end jump
	
}//end class