//	www.teamhaircut.org
/*****************************************************
 * This is the first state called from the gamedriver
 * it displays a string designed to change color
 *****************************************************/

package states;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import dimensions.Ints;
import strings.Strings;
import supportclasses.CustomAnimator;

public class IntroState extends BasicGameState{
	
	//for FONTSIZE use 6 points and its multipliers: 12,18,24,30,36,42,48,54,60...
	private static int counter;
	private static Font font;
	private CustomAnimator ca;
	
   public IntroState() {
	   counter = 0;
	   ca = new CustomAnimator();
   }
   
   public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
	   font = new TrueTypeFont(new java.awt.Font(Strings.FONTNAME, java.awt.Font.PLAIN, Ints.FONTSIZE+12), false);
   }
   
   public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
	   g.setBackground(Color.black);
	   font.drawString((ScrRes.getWidth(2))-(((Ints.FONTSIZE+12)/2)*15), 
			   ScrRes.getHeight(2), "TEAMHAIRCUT.ORG", ca.getColor());//TEAMHAIRCUT.ORG 
	   font.drawString((ScrRes.getWidth(2))-(((Ints.FONTSIZE+12)/2)*10), 
			   (ScrRes.getHeight(2))+(Ints.FONTSIZE+12)+1, " PRESENTS ", ca.getColor());
   }
   
   public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
	   ca.animateString(delta, 300);
	   counter += delta;
	   if (counter >= 4000) {
		   sbg.enterState(GameState.TITLESTATE, new FadeOutTransition(), new FadeInTransition());
	   }   
	}
   
   public int getID(){
      return -4;
   }
}//[end IntroState]
