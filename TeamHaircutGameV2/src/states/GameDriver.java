//	www.teamhaircut.org
package states;

import levels.Level_1_1;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import strings.Strings;

public class GameDriver extends StateBasedGame{
      
   public GameDriver(String gameName){
      super(gameName);
      this.addState(new IntroState());
      this.addState(new TitleState());
      this.addState(new SelectState());
      this.addState(new StartState());
      this.addState(new GameOverState());
      
      
     // this.addState(new Level2());
      this.addState(new Level_1_1());
      //this.addState(new Level_Test());
   }
   
   public void initStatesList(GameContainer gc) throws SlickException{
      this.getState(GameState.INTROSTATE).init(gc, this);
      this.getState(GameState.TITLESTATE).init(gc, this);
      this.getState(GameState.SELECTSTATE).init(gc, this);
      this.getState(GameState.STARTSTATE).init(gc, this);
      this.getState(GameState.GAMEOVERSTATE).init(gc, this);
      this.getState(GameState.LEVEL_1_1).init(gc, this);
      //this.getState(GameState.LEVEL_Test).init(gc, this);


      /*
       * use GameState.INTROSTATE, to start at beginning
       */
//      this.enterState(GameState.INTROSTATE);
//      this.enterState(GameState.TITLESTATE);
//      this.enterState(GameState.SELECTSTATE);
//      this.enterState(GameState.STARTSTATE);
      this.enterState(GameState.LEVEL_1_1);
//      this.enterState(GameState.LEVEL_Test);
   }
   
   public static void main(String[] args) {
      AppGameContainer appgc;
      try{
         appgc = new AppGameContainer(new GameDriver(Strings.GAMENAME));
         ScrRes.setHeight(appgc.getScreenHeight());
         ScrRes.setWidth(appgc.getScreenWidth());
         appgc.setDisplayMode(ScrRes.getWidth(), ScrRes.getHeight(), true);
         
//       alt-tab to exit fullscreen
         appgc.setFullscreen(true);//uncomment for full screen
         appgc.setShowFPS(true);//true
         appgc.start();
      }catch(SlickException e){
         e.printStackTrace();
      }
   }

}//[end GameDriver]
