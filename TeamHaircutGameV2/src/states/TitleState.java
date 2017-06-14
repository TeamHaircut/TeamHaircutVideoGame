/**********************************************
 * This state displays the title screen
 * until the user presses the enter key
 */
package states;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.state.transition.EmptyTransition;

import supportclasses.CustomAnimator;

public class TitleState extends BasicGameState{
	
	//use 6 points and its multipliers: 12,18,24,30,36,42,48,54,60...
	private static final int FONTSIZE = 18;
	private Font font;
	private Animation titleAnimation;
	private CustomAnimator ca;
	
	public TitleState() {
		ca = new CustomAnimator();
	}
   
   public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
	   font = new TrueTypeFont(new java.awt.Font(GameState.FONTNAME, java.awt.Font.PLAIN, FONTSIZE), false);
	   Image[] titleImageArray = {new Image("res/setupImages/title1.png"), new Image("res/setupImages/title2.png"),
			   new Image("res/setupImages/title3.png")};
	   titleAnimation = new Animation(titleImageArray, new int[] {150,150,3000}, true);
   }
   
   public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
	   Image menuImage = new Image("res/setupImages/title.png");
	   
	   g.drawImage(menuImage, (ScrRes.getWidth(2))-(menuImage.getWidth()/2), 
			   (ScrRes.getHeight(2))-(menuImage.getHeight()/2));
	   
	   font.drawString((ScrRes.getWidth(2))-((FONTSIZE/2)*11), 
			   ScrRes.getHeight(2)+ScrRes.getHeight(3) , "PRESS ENTER",
			   ca.getColor());
	   
	   font.drawString((ScrRes.getWidth(2))-((FONTSIZE/2)*22),
			   ScrRes.getHeight()-75, "\u00a9 2017 TeamHaircut.org", Color.white);
	   
	   titleAnimation.draw((ScrRes.getWidth(4))+65,(ScrRes.getHeight(5))-15);
	   
	   titleAnimation.setPingPong(true);
   }
   
   public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
	   ca.animateString(delta, 100);
	   Input input = gc.getInput();
	   if(input.isKeyPressed(Input.KEY_ENTER)){sbg.enterState(GameState.SELECTSTATE, new EmptyTransition(), 
			   new EmptyTransition());}
   }
   
   public int getID(){
      return 1;
   }
}
