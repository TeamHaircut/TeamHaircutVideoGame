//	www.teamhaircut.org
package states;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.state.transition.EmptyTransition;

import dimensions.Ints;
import strings.Strings;

public class SelectState extends BasicGameState{
	
	private Font font;
	private int x, y;
	private Animation selectAnimation;
	
	private String name;
	private Image damianImage, danImage;
	
	public SelectState() {
		name = "Damian";
	}
   
   public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
	   damianImage = new Image(Strings.SELECT_STATE_IMAGE_0);
	   danImage = new Image(Strings.SELECT_STATE_IMAGE_1);
	   x = (ScrRes.getWidth(2))-(damianImage.getWidth())-(damianImage.getWidth()/2);
	   y = (ScrRes.getHeight(2))-(damianImage.getHeight()/2)-(50);
       font = new TrueTypeFont(new java.awt.Font(Strings.FONTNAME, java.awt.Font.BOLD, Ints.FONTSIZE), false);
	   selectAnimation = new Animation(new Image[]{new Image(Strings.SELECT_STATE_IMAGE_2), 
			   new Image(Strings.SELECT_STATE_IMAGE_3)}, new int[]{75,75}, true);
	}
   
   public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
	   font.drawString((ScrRes.getWidth(2))-((Ints.FONTSIZE/2)*13), 
			   (ScrRes.getHeight(2)) -(200), "SELECT PLAYER", Color.white);
	   g.setColor(Color.white);
	   g.setLineWidth(5);
	   System.out.println(ScrRes.getWidth(3));
	   g.drawLine(ScrRes.getWidth(3), (ScrRes.getHeight()/2)-(150), (ScrRes.getWidth(3)+ScrRes.getWidth(3)), (ScrRes.getHeight(2))-(150));
	   
	   g.drawImage(damianImage, (ScrRes.getWidth(2))-(damianImage.getWidth())-(damianImage.getWidth()/2), 
			   (ScrRes.getHeight(2))-(damianImage.getHeight()/2)-(50));
	   g.drawImage(danImage, (ScrRes.getWidth(2))+(danImage.getWidth()/2), 
			   (ScrRes.getHeight(2))-(danImage.getHeight()/2)-(50));
	   
	   g.drawAnimation(selectAnimation, x, y);
	   
	   font.drawString((ScrRes.getWidth(2))-((Ints.FONTSIZE/2)*name.length()), 
			   ScrRes.getHeight(2)+ScrRes.getHeight(5)+50, name, Color.white);
   }
   
   public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
	   Input input = gc.getInput();
	   if(input.isKeyDown(Input.KEY_RIGHT)){x = (ScrRes.getWidth(2))+(danImage.getWidth()/2); 
	   y =  (ScrRes.getHeight(2))-(damianImage.getHeight()/2)-(50); HeroState.setIndex(HeroState.DAN); name = "Dan";}
	   if(input.isKeyDown(Input.KEY_LEFT)){x = (ScrRes.getWidth(2))-(damianImage.getWidth())-(damianImage.getWidth()/2);
	   y = (ScrRes.getHeight(2))-(danImage.getHeight()/2)-(50); HeroState.setIndex(HeroState.DAMIAN); name = "Damian";}
	   if(input.isKeyPressed(Input.KEY_ENTER)){HeroState.setLives(3); sbg.enterState(GameState.STARTSTATE, new EmptyTransition(), 
			   new EmptyTransition());}
	}
   
   public int getID(){
      return -2;
   }
}//[end SelectState]
