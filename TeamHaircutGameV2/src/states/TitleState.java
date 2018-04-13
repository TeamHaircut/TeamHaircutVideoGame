//	www.teamhaircut.org
/**********************************************
 * This state displays the title screen
 * until the user presses the enter key
 */
package states;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.state.transition.EmptyTransition;

import dimensions.Ints;
import strings.Strings;
import supportclasses.CustomAnimator;

public class TitleState extends BasicGameState{
	
	//use 6 points and its multipliers: 12,18,24,30,36,42,48,54,60...
//	private static final int FONTSIZE = 18;
	private Font font;
	private Animation titleAnimation;
	private CustomAnimator ca;
	
	public TitleState() {
		ca = new CustomAnimator();
	}
	
   public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
	   font = new TrueTypeFont(new java.awt.Font(Strings.FONTNAME, java.awt.Font.PLAIN, Ints.FONTSIZE), false);
	   Image[] titleImageArray = {new Image(Strings.TITLE_STATE_IMAGE_0), new Image(Strings.TITLE_STATE_IMAGE_1),
			   new Image(Strings.TITLE_STATE_IMAGE_2)};
	   titleAnimation = new Animation(titleImageArray, new int[] {150,150,3000}, true);
   }
   
   public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
	   Image menuImage = new Image(Strings.TITLE_STATE_IMAGE_3);
	   
	   g.drawImage(menuImage, (ScrRes.getWidth(2))-(menuImage.getWidth()/2), 
			   (ScrRes.getHeight(2))-(menuImage.getHeight()/2));
	   
	   font.drawString((ScrRes.getWidth(2))-((Ints.FONTSIZE/2)*11), 
			   ScrRes.getHeight(2)+ScrRes.getHeight(3) , "PRESS ENTER",
			   ca.getColor());
	   
	   font.drawString((ScrRes.getWidth(2))-((Ints.FONTSIZE/2)*22),
			   ScrRes.getHeight()-75, "\u00a9 2018 TeamHaircut.org", Color.white);
	   
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
      return -3;
   }
}//[end TitleState]
