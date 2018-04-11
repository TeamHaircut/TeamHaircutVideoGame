//	www.teamhaircut.org
package states;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import strings.Strings;

public class GameOverState extends BasicGameState{
	//use 6 points and its multipliers: 12,18,24,30,36,42,48,54,60...
	private static final int FONTSIZE = 24;
	private static Font font;
	private static int counter;
	
	public GameOverState()
	{
		counter = 0;
	}
   
   public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
	   font = new TrueTypeFont(new java.awt.Font(Strings.FONTNAME, java.awt.Font.PLAIN, FONTSIZE), false);
   }
   
   public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
	   g.setBackground(Color.black);
	   
	   font.drawString((ScrRes.getWidth(2))-((FONTSIZE/2)*9), 
			   ScrRes.getHeight(2), "GAME OVER", Color.white); 
	}
   
   public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
	   counter += delta;
	   GameState.setCurrentState(GameState.LEVEL_1_1);
	   //Hero.world = " 1-1";
	   HeroState.setCoins(0);
	   if (counter >= 5000) {
		   counter = 0;
		   sbg.enterState(GameState.TITLESTATE, new FadeOutTransition(), new FadeInTransition());
	   }
	}
   
   public int getID(){
      return -5;
   }
   
 }
