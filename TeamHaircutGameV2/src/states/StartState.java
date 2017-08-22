package states;

import strings.Strings;
import supportclasses.Hero;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.state.transition.EmptyTransition;

public class StartState extends BasicGameState{
	//use 6 points and its multipliers: 12,18,24,30,36,42,48,54,60...
	private static final int FONTSIZE = 24;
	private static Font font;
	
	private int counter;
  
	public StartState() {
		counter = 0;
	}
   
   public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
       font = new TrueTypeFont(new java.awt.Font(Strings.FONTNAME, java.awt.Font.BOLD, FONTSIZE), false);
       HeroState.setState(HeroState.STATE_ALIVE);
   }
   
   public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
	   g.setBackground(Color.black);
	   if (HeroState.getIndex()== HeroState.DAMIAN) {
		   Image damianImage = new Image("res/setupImages/damianselectA.png");
		   g.drawImage(damianImage, (ScrRes.getWidth(2))-(damianImage.getWidth()), 
				   (ScrRes.getHeight(2))-(damianImage.getHeight()/2));
	   }
	   if (HeroState.getIndex()==HeroState.DAN) {
		   Image danImage = new Image("res/setupImages/danselectA.png");
		   g.drawImage(danImage, (ScrRes.getWidth(2))-(danImage.getWidth()), 
				   (ScrRes.getHeight(2))-(danImage.getHeight()/2));
	   }
	   
	   font.drawString(ScrRes.getWidth(2)+25, ScrRes.getHeight(2)-15, "X", Color.white);
	   font.drawString(ScrRes.getWidth(2)+75, ScrRes.getHeight(2)-15, ""+ HeroState.getLives(), Color.white);
   }
   
   public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
	   counter += delta;
	   if (counter >= 1000) {
		   counter = 0;
		   switch(GameState.getCurrentState()) {
		   	case GameState.LEVEL_1_1:
		   		sbg.getState(GameState.LEVEL_1_1).init(gc, sbg);
				sbg.enterState(GameState.LEVEL_1_1, new EmptyTransition() ,new EmptyTransition());
		   		break;
		   	case GameState.LEVEL_1_2:
		   		sbg.enterState(GameState.LEVEL_1_2, new EmptyTransition(), new EmptyTransition());
		   		break;
			default:
				break;
		   }

	   }
	}
   
   public int getID(){
      return -1;
   }
}