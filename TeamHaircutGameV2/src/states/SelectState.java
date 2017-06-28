package states;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.state.transition.EmptyTransition;

import strings.Strings;

public class SelectState extends BasicGameState{
	private static final int FONTSIZE = 18;
	
	private Font font;
	private int x, y;
	private Animation selectAnimation;
	
	private String name;
	private Image damianImage, danImage;
	
	public SelectState() {
		name = "DAMIAN";
	}
   
   public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
	   damianImage = new Image("res/setupImages/damianselectA.png");
	   danImage = new Image("res/setupImages/danselectA.png");
	   x = (ScrRes.getWidth(2))-(damianImage.getWidth())-(damianImage.getWidth()/2);
	   y = (ScrRes.getHeight(2))-(damianImage.getHeight()/2)-(100);
       font = new TrueTypeFont(new java.awt.Font(Strings.FONTNAME, java.awt.Font.BOLD, FONTSIZE), false);
	   selectAnimation = new Animation(new Image[]{new Image("res/setupImages/selectorA.png"), 
			   new Image("res/setupImages/selectorB.png")}, new int[]{75,75}, true);
	   HeroState.setLives(3);
	}
   
   public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
	   font.drawString((ScrRes.getWidth(2))-((FONTSIZE/2)*13), 
			   (ScrRes.getHeight(2)) -(250), "SELECT PLAYER", Color.white);
	   g.setColor(Color.white);
	   g.setLineWidth(5);
	   g.drawLine((ScrRes.getWidth(2))-((FONTSIZE/2)*22), (ScrRes.getHeight()/2)-(200), 
			   (ScrRes.getWidth(3))+(ScrRes.getWidth(3)), (ScrRes.getHeight(2))-(200));
	   
	   g.drawImage(damianImage, (ScrRes.getWidth(2))-(damianImage.getWidth())-(damianImage.getWidth()/2), 
			   (ScrRes.getHeight(2))-(damianImage.getHeight()/2)-(100));
	   g.drawImage(danImage, (ScrRes.getWidth(2))+(danImage.getWidth()/2), 
			   (ScrRes.getHeight(2))-(danImage.getHeight()/2)-(100));
	   
	   g.drawAnimation(selectAnimation, x, y);
	   
	   font.drawString((ScrRes.getWidth(2))-((FONTSIZE/2)*name.length()), 
			   ScrRes.getHeight(2)+ScrRes.getHeight(5), name, Color.white);
   }
   
   public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
	   Input input = gc.getInput();
	   if(input.isKeyDown(Input.KEY_RIGHT)){x = (ScrRes.getWidth(2))+(danImage.getWidth()/2); 
	   y =  (ScrRes.getHeight(2))-(damianImage.getHeight()/2)-(100); HeroState.setIndex(2); name = "DAN";}
	   if(input.isKeyDown(Input.KEY_LEFT)){x = (ScrRes.getWidth(2))-(damianImage.getWidth())-(damianImage.getWidth()/2);
	   y = (ScrRes.getHeight(2))-(danImage.getHeight()/2)-(100); HeroState.setIndex(1); name = "DAMIAN";}
	   if(input.isKeyPressed(Input.KEY_ENTER)){sbg.enterState(GameState.STARTSTATE, new EmptyTransition(), 
			   new EmptyTransition());}
	}
   
   public int getID(){
      return -2;
   }
}
