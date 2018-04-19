//	www.teamhaircut.org
package states;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import dimensions.Ints;
import strings.Strings;

public class Header{
	
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
       font = new TrueTypeFont(new java.awt.Font(Strings.FONTNAME, java.awt.Font.BOLD, Ints.FONTSIZE), false);
       setTime(initialTime);
       
       switch(HeroState.getIndex()) {
       		case HeroState.DAMIAN:
       			setName("C.SAFETY");
       			break;
       		case HeroState.DAN:
//       			setName("DAN   ");
       			setName("C.AMERIKA");
       			break;
       		default:
       			break;
       }
   }
   
   public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
   {
	   font.drawString((ScrRes.getWidth(2))-((Ints.FONTSIZE/2)*49), 0, getName() + "                        WORLD           TIME", Color.white);
	   font.drawString((ScrRes.getWidth(2))-((Ints.FONTSIZE/2)*49),25,HeroState.getScoreString()+"  "+ "           x "+HeroState.getCoinsString() + "         " +" 1-1"+"            "+" "+timeToString(screenTime/1000), Color.white); 

	   g.drawImage(new Image(Strings.ICON_COIN), (ScrRes.getWidth(2))-((Ints.FONTSIZE/2)*49)+(13*Ints.FONTSIZE)+85, 25); 
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
   
   private static String timeString;
   
   public static String getTimeString() {
		return timeString;
	}

	public static String timeToString(int input) {
		timeString = Integer.toString(input);
		int stringLength = timeString.length();
		for(int i = stringLength; i < 3; i++) {
			timeString = "0"+timeString;
		}
		return timeString;
		
	}
   
 }
