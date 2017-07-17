package supportclasses;

import org.newdawn.slick.Animation;
import org.newdawn.slick.geom.Rectangle;

import supportclasses.Hero;

public class GameFunc {
	
	public static float scrollImage(float xPos, float xShift, float wall, float heroShift ){
		   
		   xPos = wall-(xShift-heroShift);
		return xPos;
	   }
	
	public static int wasHitCheck(Rectangle REC, Rectangle Hrec, int wH){
		   if (REC.intersects(Hrec)){wH = 1;}
		   return wH;
		}
	
//	public static boolean isHitCheck(Rectangle REC, Rectangle Hrec, boolean isHit){
//		   if (REC.intersects(Hrec)){isHit = true;}
//		   return isHit;
//		}
	
	public static boolean isHitCheck(Rectangle REC, int collisionType, boolean isHit){
	   
		if(collisionType == 0) {
			if (REC.contains(Hero.topLeft)	|| REC.contains(Hero.topRight)){isHit = true;}
		}
		if(collisionType == 1) {
			if (REC.intersects(Hero.rec)){isHit = true;}
		}
		
	   return isHit;
	}
	
	public static void bounce(int i, int[] collides2, float[] vox, int[] currentState){
		
		   if (collides2[i] == 1 && vox[i] < 0f && currentState[i] != 2)
		   {
			   currentState[i] = 1; vox[i] = -1*vox[i];
		   }
		   else if (collides2[i] == 1 && vox[i] > 0f && currentState[i] != 1)
		   {
			   currentState[i] = 2; vox[i] = -1*vox[i];		   
		   }
		   if (collides2[i] == 0){currentState[i] = 0;}
		   
	}
	
	public static void fall(int i, int[] collides, float[] jumpCounter, float[] timeY, float[] v, float[] vo, float a, float[] yo, float[] y, int delta){
		   
		   if (collides[i] == 0)
		   		{jumpCounter[i] = jumpCounter[i] + delta;
		   		timeY[i] = jumpCounter[i]/1000;
		   		v[i] = vo[i] + a*timeY[i];
		   		y[i] = -(((v[i]))*timeY[i] -0.5f*(a)*timeY[i]*timeY[i])+yo[i];}
		   else if (collides[i] == 1)
		   		{
			   	if (y[i] != yo[i] && jumpCounter[i] !=0)
			   		{
			   		yo[i] = (int) (((y[i]/40)*40)/10);
			   		if (yo[i] % 2 == 1)
			   		{
			   			yo[i] = (yo[i] - 1)*10;
			   		}
			   		else yo[i] = yo[i] *10;
			   		y[i] =yo[i]; vo[i] = 0;
			   		}
			   	jumpCounter[i] = 0;
		   		}
			
	     }//end fall
	
	public static int checkCollisionBG(int i, Rectangle[] r, Rectangle[] rec, int[] check)
	   {
		for(int j = 0; j < r.length-1 ; j++)
			   {if(r[j].intersects(rec[i])||r[j+1].intersects(rec[i])){check[i] = 1;}}
		return check[i];
	   }
	
	public static void jump(int i, boolean[] jumpTrigger, float[] vo, float[] jumpCounter, float[] timeY, int[] collides, float[] yo, float[] y, float[] v, float a,int delta){
		   
		   if (jumpTrigger[i]){vo[i] = 500;y[i]--;}
		   jumpCounter[i] = jumpCounter[i] + delta;
	  		timeY[i] = jumpCounter[i]/1000;
		   if (collides[i] == 1)//on ground
	  		{
			   if (y[i] != yo[i] && jumpCounter[i] !=0)
		   		{
		   		yo[i] = (int) (((y[i]/40)*40)/10);
		   		if (yo[i] % 2 == 1)
		   		{
		   			yo[i] = (yo[i] - 1)*10;
		   		}
		   		else yo[i] = yo[i] *10;
		   		y[i] =yo[i]; vo[i] = 0;
		   		}
		   	    jumpCounter[i] = 0;
			   
			   		jumpTrigger[i] = true;
		    }
		   else //in air
		   {
			    v[i] = vo[i] + a*timeY[i];
		   		y[i] = -(((v[i]))*timeY[i] -0.5f*(a)*timeY[i]*timeY[i])+yo[i];
		    	if (timeY[i] > 0){jumpTrigger[i] = false;}
			}
		}//end jump
	
	public static void jump(int i, boolean[] jumpTrigger, float[] vo, float[] jumpCounter, float[] timeY, int[] collides, float[] yo, float[] y, float[] v, float a,int delta, int speed){
		   
		   if (jumpTrigger[i]){vo[i] = speed;y[i]--;}
		   jumpCounter[i] = jumpCounter[i] + delta;
	  		timeY[i] = jumpCounter[i]/1000;
		   if (collides[i] == 1)//on ground
	  		{
			   if (y[i] != yo[i] && jumpCounter[i] !=0)
		   		{
		   		yo[i] = (int) (((y[i]/40)*40)/10);
		   		if (yo[i] % 2 == 1)
		   		{
		   			yo[i] = (yo[i] - 1)*10;
		   		}
		   		else yo[i] = yo[i] *10;
		   		y[i] =yo[i]; vo[i] = 0;
		   		}
		   	    jumpCounter[i] = 0;
			   
			   		jumpTrigger[i] = true;
		    }
		   else //in air
		   {
			    v[i] = vo[i] + a*timeY[i];
		   		y[i] = -(((v[i]))*timeY[i] -0.5f*(a)*timeY[i]*timeY[i])+yo[i];
		    	if (timeY[i] > 0){jumpTrigger[i] = false;}
			}
		}//end jump
	
	public static void initializer(int i, float[] x, float[] xo, float[]y, float[] yo, float[] nx, Animation[] main, Animation[] setting){
		   x[i] = xo[i];	
			y[i] = yo[i];
			nx[i] = -(xo[i]-350);
			main[i] = setting[i];
	   }
	
	

}
