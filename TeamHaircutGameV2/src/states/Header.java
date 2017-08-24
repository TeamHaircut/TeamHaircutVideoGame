package states;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import supportclasses.OldCoin;
import strings.Strings;

public class Header{
	private static final int FONTSIZE = 18;
	
	private Font font;
	private int initialTime;
	private int screenTime;
	
	private String name;
	
	public Header(int time)
	{
		this.initialTime = time*1000;
	}
   
   public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
   {
       font = new TrueTypeFont(new java.awt.Font(Strings.FONTNAME, java.awt.Font.BOLD, FONTSIZE), false);
       setTime(initialTime);
       
       switch(HeroState.getIndex()) {
       		case HeroState.DAMIAN:
       			setName("DAMIAN");
       			break;
       		case HeroState.DAN:
       			setName("DAN   ");
       			break;
       		default:
       			break;
       }
   }
   
   public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
   {
	   font.drawString((ScrRes.getWidth(2))-((FONTSIZE/2)*49), 0, getName() + "                        WORLD           TIME", Color.white);
	   
	   font.drawString((ScrRes.getWidth(2))-((FONTSIZE/2)*49),25,"      "+ "        x "+HeroState.getCoins() + "             " +"header.java ln 44"+"            "+String.valueOf(screenTime/1000), Color.white); 

	   g.drawImage(new Image(Strings.ICON_COIN), (ScrRes.getWidth(2))-((FONTSIZE/2)*49)+(13*FONTSIZE), 25); 
	 }
   
   public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
	   screenTime = screenTime - delta;
	}
   
   private void setTime(int time) {
	   screenTime = time;
   }
   
   private void setName(String name) {
	   this.name = name; 
   }
   
   private String getName() {
	   return name;
   }
   
 }
