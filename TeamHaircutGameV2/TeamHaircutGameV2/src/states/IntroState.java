//	www.teamhaircut.org
/*****************************************************
 * This is the first state called from the gamedriver
 * it displays a string designed to change color
 *****************************************************/

package states;

import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

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
	   java.awt.Font f;
	try {
		f = java.awt.Font.createFont(java.awt.Font.TRUETYPE_FONT, new File(Strings.TTF_PATHNAME));
		   GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		   ge.registerFont(f);
	} catch (FontFormatException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	   font = new TrueTypeFont(new java.awt.Font(Strings.FONTNAME, java.awt.Font.PLAIN, Ints.FONTSIZE+12), false);
   }
   
   public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
	   g.setBackground(Color.black);
	   font.drawString(ScrRes.getWidth(2)-(((Ints.FONTSIZE+12)/2)*19), ScrRes.getHeight(2), "WWW.TEAMHAIRCUT.ORG", ca.getColor()); 
	   font.drawString(ScrRes.getWidth(2)-(((Ints.FONTSIZE+12)/2)*10), (ScrRes.getHeight(2))+(Ints.FONTSIZE+12)+1, " PRESENTS ", ca.getColor());
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
